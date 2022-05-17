package data_structures;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    private static Trie trie = null;

    @BeforeAll
    public static void  init(){
        trie = new Trie();
        trie.add("google");
        trie.add("google2");
        trie.add("googgg2");
    }

    @Test
    void add() {
        trie.add("csssd");
    }

    @Test
    void contains() {
        assertTrue(trie.contains("google"));
    }

    @Test
    void prefixContains() {
        assertTrue(trie.prefixContains("goo"));
    }

    @Test
    void match() {
        assertTrue(trie.match("google"));
    }

    @Test
    void commonPrefixSearch() {
        List<String> res = trie.commonPrefixSearch("goo");
        List<String> exp = new ArrayList<>();
        exp.add("googgg2");
        exp.add("google");
        exp.add("google2");
        assertEquals(exp,res);
    }
}