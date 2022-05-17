package data_structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 实现Trie树
 */
public class Trie {

    /**
     * 根节点，不存储数据
     */
    private Node root;

    public Trie() {
        root = new Node(false);
    }

    /**
     * 添加单词
     */
    public void add(String word) {
        Node cur = root;
        char[] array = word.toCharArray();

        for (char c : array) {
            Map<Character, Node> children = cur.children;
            children.putIfAbsent(c, new Node(false));
            cur = children.get(c);
        }
        cur.word = true;
    }

    /**
     * 是否包含单词
     */
    public boolean contains(String word) {
        return contains(word, true);
    }

    /**
     * 是否包含前缀
     */
    public boolean prefixContains(String prefix) {
        return contains(prefix, false);
    }

    /**
     * 是否匹配单词，支持.匹配任意字符
     */
    public boolean match(String word) {
        return match(root, word, 0);
    }

    /**
     * 查询所有以prefix为前缀的单词列表
     */
    public List<String> commonPrefixSearch(String prefix) {
        Node cur = root;
        List<String> res = new ArrayList<>();
        char[] array = prefix.toCharArray();
        for (char c : array) {
            Node node = cur.children.get(c);
            if (node == null) {
                return res;
            }
            cur = node;
        }
        commonPrefixSearch(res, new ArrayList<>(), cur);
        return res.stream()
                .map(x -> prefix + x)
                .collect(Collectors.toList());
    }


    private void commonPrefixSearch(List<String> res, List<Character> list, Node root) {
        if (root.word) {
            char[] arr = new char[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            res.add(new String(arr));
        }
        //递归加回溯实现
        for (Entry<Character, Node> entry : root.children.entrySet()) {
            list.add(entry.getKey());
            commonPrefixSearch(res, list, entry.getValue());
            list.remove(list.size() - 1);
        }
    }

    private boolean match(Node root, String word, int index) {
        if (index == word.length()) {
            return root.word;
        }
        char c = word.charAt(index);
        if (c != '.') {
            Node node = root.children.get(c);
            return node != null && match(node, word, index + 1);
        } else {
            //递归加回溯实现
            for (Entry<Character, Node> entry : root.children.entrySet()) {
                if (match(entry.getValue(), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean contains(String prefix, boolean word) {
        Node cur = root;
        char[] array = prefix.toCharArray();
        for (char c : array) {
            Node node = cur.children.get(c);
            if (node == null) {
                return false;
            }
            cur = node;
        }
        if (word) {
            return cur.word;
        } else {
            return true;
        }
    }

    private static class Node {

        /**
         * 表示当前节点是否是单词
         */
        boolean word;
        /**
         * 孩子节点列表
         */
        Map<Character, Node> children;

        Node(boolean word) {
            this.word = word;
            children = new TreeMap<>();
        }
    }

}

