package redistest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RBucket;
import org.redisson.api.RScript;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class RedissonCollectionTest {

    private RedissonClient redisson;

    @BeforeEach
    void init(){
        Config config = new Config();
        /* Redis 单节点*/
        config.useSingleServer().setAddress("redis://123.57.162.179:6379");
        redisson = Redisson.create(config);
    }

    @Test
    void testobject1() throws InterruptedException {
        RBlockingDeque deque = redisson.getBlockingDeque("myqueue");
        deque.add("1111");
        deque.poll();
        deque.pollFirstFromAny(3, TimeUnit.SECONDS);

    }

    @Test
    void testscript(){
        RBucket<String> bucket = redisson.getBucket("foo");
        bucket.set("bar");

        RScript script = redisson.getScript(StringCodec.INSTANCE);

        // execute script in read only mode
        String result = script.eval(RScript.Mode.READ_ONLY,
                "return redis.call('get', 'foo')",
                RScript.ReturnType.VALUE);



        // execute the same script stored in Redis lua script cache

        // load lua script into Redis cache to all redis master instances
        String sha1 = script.scriptLoad("return redis.call('get', 'foo')");

        // call lua script by sha digest
        result = redisson.getScript().evalSha(RScript.Mode.READ_ONLY,
                sha1, RScript.ReturnType.VALUE, Collections.emptyList());


        redisson.shutdown();
    }

}
