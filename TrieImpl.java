package app;

import java.util.HashMap;

class TrieNode {
    Character c;
    Boolean isLeaf = false;
    HashMap<Character, TrieNode> children = new HashMap<>();
    public TrieNode() {}
    public TrieNode(Character c) {
        this.c = c;
    }
}

public class Trie {
    private TrieNode root = new TrieNode();

    public void insertWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode cur = this.root;
        for (char c : word.toCharArray()) {
            // .containsKey method of Map is good, but when you are going to call .get after calling
            // the .containsKey, and if you don't care about difference between absent and null values,
            // it will be a bit faster (and cleaner) not to use contains at all.
            TrieNode next = cur.children.get(c);
            if (next == null) {
                next = new TrieNode();
                cur.children.put(c, next);
            }
            cur = next;
        }
        cur.isLeaf = true;
    }

    public boolean searchWord(String word) {
        TrieNode node = getNodeByPath(word);
        return node != null && node.isLeaf;
    }

    // Boolean can contain 3 values: true, false and null.
    // When you are not going to use null, it is usually better to use boolean instead.
    public boolean searchPrefix(String word) {
        TrieNode node = getNodeByPath(word);
        return node != null && node.children.size() > 0;
    }

    // You have had the same code with the same meaning in 2 methods.
    // It is usually better to move duplicate code to separate method.
    private TrieNode getNodeByPath(String word) {
        TrieNode cur = this.root;
        for (char c : word.toCharArray()) {
            cur = cur.children.get(c);
            if (cur == null) {
                return null;
            }
        }
        return cur;
    }
}