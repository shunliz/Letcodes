package letcode.zhongdeng.Q146;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 这个可不写
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

class LRUCache2 {
    private int capacity;
    private int size = 0;
    private DoubleLinkNode head, tail;
    private Map<Integer, DoubleLinkNode> cache = new HashMap<Integer, DoubleLinkNode>();
    public LRUCache2(int capacity){
        head = new DoubleLinkNode();
        tail = new DoubleLinkNode();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        DoubleLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DoubleLinkNode newNode = new DoubleLinkNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DoubleLinkNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void removeNode(DoubleLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    private void moveToHead(DoubleLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DoubleLinkNode removeTail() {
        DoubleLinkNode res = tail.prev;
        removeNode(res);
        return res;
    }


    public void addToHead(DoubleLinkNode node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void addToTail(DoubleLinkNode node){
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    static class DoubleLinkNode {
        private int key;
        private int value;
        private DoubleLinkNode prev;
        private DoubleLinkNode next;

        public DoubleLinkNode() {}

        public DoubleLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}