package redistest;


import com.sun.corba.se.spi.resolver.LocalResolver;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

public class Demo01 {

    public static final String LOCK_NAME = "LOCK";

    public static final String LOCK_VALUE = "ERICK";

    public static final int EXPIRE_SECS = 5;

    private static Jedis getJedis() {
        return new Jedis("123.57.162.179", 6379);
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> secondLock()).start();
        new Thread(() -> secondLock()).start();
    }

    /*场景一: 假如释放锁失败，则后面永远无法执行*/
    public static void firstLock() {
        //1.上锁
        Jedis redis = getJedis();
        Long lockResult = redis.setnx(LOCK_NAME, LOCK_VALUE);
        if (1 == lockResult) {
            // 2. 执行业务
            executeBusiness();
            // 3. 释放锁
            redis.del(LOCK_NAME);
        } else {
            // 获取锁失败
            System.out.println("Can not get lock");
        }
    }

    /*场景二： 释放锁失败，通过自动过期来保证*/
    public static void secondLock() {
        Jedis redis = getJedis();
        SetParams params = new SetParams();
        params.ex(EXPIRE_SECS);
        params.nx();
        String lockResult = redis.set(LOCK_NAME, LOCK_VALUE, params);
        while(lockResult == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockResult = redis.set(LOCK_NAME, LOCK_VALUE, params);
        }
        executeBusiness();
        redis.del(LOCK_NAME);
    }

    private static void executeBusiness() {
        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"Business execution.....");
    }
}

