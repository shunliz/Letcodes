package redistest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.UUID;

public class Demo11 {

    private static Jedis getJedis() {
        return new Jedis("123.57.162.179", 6379);
    }

    private static String getLockValue() {
        return UUID.randomUUID().toString();
    }

    private static final String LOCK_KEY = "LOCK";

    private static final int EXPIRE_SECS = 5;

    public static void main(String[] args) {
        new Thread(() -> firstMethod(LOCK_KEY, getLockValue())).start();
    }

    private static void firstMethod(String lockKey, String lockValue) {
        Jedis redis = getJedis();
        SetParams params = new SetParams();
        params.ex(EXPIRE_SECS);
        params.nx();
        String lockResult = redis.set(lockKey, lockValue, params);
        if ("OK".equalsIgnoreCase(lockResult)) {
            executeBusiness();
            String presentValue = redis.get(lockKey);

            /*判断是否是自己的，是自己的再删除*/
            if (lockValue.equalsIgnoreCase(presentValue)) {
                redis.del(lockKey);
                System.out.println("lock deleted");
            }
        } else {
            System.out.println("Can not get lock");
        }
    }

    private static void executeBusiness() {
        System.out.println("Business execution.....");
    }
}

