package algorithm.datastuctures.trie;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String str) {
        if (str == null) return;
        TrieNode cur = root;
        cur.pass += 1;
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (cur.nexts[ch - 'a'] == null) {
                cur.nexts[ch - 'a'] = new TrieNode();
            }
            cur = cur.nexts[ch - 'a'];
            cur.pass += 1;
        }
        cur.end += 1;
    }

    private TrieNode search(String str) {
        TrieNode cur = root;
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            cur = cur.nexts[ch - 'a'];
            if (cur == null) return null;
        }
        return cur;
    }

    public int countWords(String str) {
        TrieNode endNode = search(str);
        return endNode == null ? 0 : endNode.end;
    }

    public int countPrefix(String str) {
        TrieNode endNode = search(str);
        return endNode == null ? 0 : endNode.pass;
    }

    public boolean contains(String str) {
        return countWords(str) > 0;
    }

    public void remove(String str) {
        if (!contains(str)) return;
        TrieNode cur = root;
        cur.pass -= 1;
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            TrieNode next = cur.nexts[ch - 'a'];
            next.pass -= 1;
            if (next.pass <= 0) {
                cur.nexts[ch - 'a'] = null;
                return;
            }
            cur = next;
        }
        cur.end -= 1;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        System.out.println(trie.contains("abc"));
        trie.remove("abc");
        System.out.println(trie.contains("abc"));
        trie.insert("abc");
        trie.insert("abcd");
        trie.insert("abcde");
        System.out.println(trie.countPrefix("abc"));
    }

}
