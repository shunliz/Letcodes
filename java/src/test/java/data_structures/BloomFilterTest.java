package data_structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {
    private BloomFilter filter = new BloomFilter();


    @Test
    void addValue() {
        filter.addValue("1111");
        filter.addValue("22222");
    }

    @Test
    void contains() {
        assertFalse(filter.contains("3333"));
    }
}