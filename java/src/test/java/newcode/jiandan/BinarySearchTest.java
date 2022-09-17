package newcode.jiandan;

import newcode.jiandan.BinarySearch;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private static BinarySearch test;

    @BeforeAll
    public static void init(){
        test = new BinarySearch();
    }
    @Test
    void search() {
        int[] arr={-1,0,3,4,6,10,13,14};
        assertEquals(6, test.search(arr,13));
    }

    @Test
    void search2() {
        int[] arr={};
        assertEquals(-1, test.search(arr,3));
    }

    @Test
    void search3() {
        int[] arr={-1,0,3,4,6,10,13,14};
        assertEquals(-1, test.search(arr,2));
    }

    @Test
    void search4() {
        int[] arr={-1,1};
        assertEquals(0, test.search(arr,-1));
    }
}