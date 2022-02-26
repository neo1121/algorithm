package algorithm.datastuctures.trie;

import java.util.HashSet;

public class TrieNode {
    int pass;
    int end;
    TrieNode[] nexts;

    public TrieNode() {
        this.pass = 0;
        this.end = 0;
        this.nexts = new TrieNode[26];
    }
}
