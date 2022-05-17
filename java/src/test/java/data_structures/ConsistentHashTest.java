package data_structures;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConsistentHashTest {

    @Test
    void remove() {
        List<String> nodes = new ArrayList<String>();
        nodes.add("192.168.1.1:server1");
        nodes.add("192.168.1.2:server2");
        nodes.add("192.168.1.3:server3");
        nodes.add("192.168.1.4:server4");
        ConsistentHash<String> consistentHash = new ConsistentHash<String>(new HashFunction(),5, nodes);

        System.out.println(consistentHash.get("request1"));
        System.out.println(consistentHash.get("request2"));
        System.out.println(consistentHash.get("request3"));
        System.out.println(consistentHash.get("request4"));
        System.out.println("#########################");
        consistentHash.remove("192.168.1.2:server2");

        System.out.println(consistentHash.get("request1"));
        System.out.println(consistentHash.get("request2"));
        System.out.println(consistentHash.get("request3"));
        System.out.println(consistentHash.get("request4"));
        System.out.println("#########################");
        consistentHash.add("192.168.1.5:server5");

        System.out.println(consistentHash.get("request1"));
        System.out.println(consistentHash.get("request2"));
        System.out.println(consistentHash.get("request3"));
        System.out.println(consistentHash.get("request4"));
        System.out.println("#########################");
    }

    @Test
    void get() {
    }
}