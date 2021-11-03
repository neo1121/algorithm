package algorithm.leetcode.problem_208;

public class Trie {
    static class TrieNode {
        int pass;
        int end;
        TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() < 1) return;
        TrieNode cur = root;
        cur.pass += 1;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (cur.nexts[ch - 'a'] == null) {
                cur.nexts[ch - 'a'] = new TrieNode();
            }
            cur = cur.nexts[ch - 'a'];
            cur.pass += 1;
        }
        cur.end += 1;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = root;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (cur.nexts[ch - 'a'] == null) return false;
            cur = cur.nexts[ch - 'a'];
        }
        return cur.end > 0;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        char[] chars = prefix.toCharArray();
        for (char ch : chars) {
            if (cur.nexts[ch - 'a'] == null) return false;
            cur = cur.nexts[ch - 'a'];
        }
        return true;
    }
}
