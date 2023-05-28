package letcode.zhongdeng.Q146;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void get() {
        LRUCache lru = new LRUCache(3);
        lru.put(1,1);
        lru.put(2,2);
        int res1 = lru.get(1);
        lru.put(3,3);
        int res2 = lru.get(2);
        lru.put(4,4);
        lru.put(3,5);
        int res3 = lru.get(1);
        int res4 = lru.get(3);
        int res5 = lru.get(4);
        assertEquals(1, res1);
        assertEquals(-1, res2);
        assertEquals(-1, res3);
        assertEquals(3, res4);
        assertEquals(4, res5);
    }

    @Test
    void put() {
        LRUCache2 lru = new LRUCache2(2);
        lru.addToHead(new LRUCache2.DoubleLinkNode(1,1));
        lru.addToHead(new LRUCache2.DoubleLinkNode(2,2));

        LRUCache2 lru2 = new LRUCache2(2);
        lru2.addToTail(new LRUCache2.DoubleLinkNode(1,1));
        lru2.addToTail(new LRUCache2.DoubleLinkNode(2,2));
    }
}