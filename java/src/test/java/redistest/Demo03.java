package redistest;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class Demo03 {

    private static final String LOCK_KEY = "COMMERCE-BUSINESS";

    /*Redisson的配置类*/
    private static RedissonClient redissonClient() {
        Config config = new Config();
        /* Redis 单节点*/
        config.useSingleServer().setAddress("redis://123.57.162.179:6379");
        return Redisson.create(config);
    }

    private static void executeBusiness() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Business executing.....");
    }

    public static void main(String[] args) throws InterruptedException {
        RedissonClient redissonClient = redissonClient();
        Thread t1 = new Thread(() -> lockMethodWithRetry(redissonClient));
        t1.start();
        Thread t2 = new Thread(() -> lockMethodWithRetry(redissonClient));
        t2.start();
        t1.join();
        t2.join();
        redissonClient.shutdown();
    }

    /*基本使用*/
    private static void lockMethod() {
        RedissonClient redissonClient = redissonClient();
        /* RLock extends Lock*/
        RLock lock = redissonClient.getLock(LOCK_KEY);

        /*可重入锁： 默认超时时间喂30s*/
        if (lock.tryLock()) {
            try {
                executeBusiness();
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                lock.unlock();
                System.out.println("Lock Released");
            }
        } else {
            System.out.println("Can not get lock");
        }
    }

    /*等待超时的锁*/
    private static void lockMethodWithRetry(RedissonClient redissonClient) {
        /*获取对应的key的锁*/
        RLock lock = redissonClient.getLock(LOCK_KEY);

        // 内部包含 重试机制，通过Redis的发布订阅者模式来实现
        /* 参数一：最长等待时间，超时则不再等待
         * 参数二：锁超时释放时间
         * 参数三：时间单位 */
        boolean hasLok = false;
        try {
            hasLok = lock.tryLock(6, 20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (hasLok) {
            try {
                executeBusiness();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("Lock Released");
            }
        } else {
            System.out.println("Can not get lock");
        }
    }
}
