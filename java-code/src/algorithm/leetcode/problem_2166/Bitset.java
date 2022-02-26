package algorithm.leetcode.problem_2166;

public class Bitset {
    public int size;
    public long[] bits;
    public int oneCount;

    public Bitset(int size) {
        this.size = size;
        int len = size / 64 + (size % 64 == 0 ? 0 : 1);
        this.bits = new long[len];
        this.oneCount = 0;
    }

    public int[] find(int idx) {
        int p1 = idx / 64;
        int p2 = idx % 64;
        return new int[]{p1, 63 - p2};
    }

    public void fix(int idx) {
        int[] p = find(idx);
        long tar = 1L << p[1];
        if ((this.bits[p[0]] & tar) == 0) {
            this.oneCount += 1;
            this.bits[p[0]] |= tar;
        }
    }

    public void unfix(int idx) {
        int[] p = find(idx);
        long tar = 1L << p[1];
        if ((this.bits[p[0]] & tar) != 0) {
            this.oneCount -= 1;
            this.bits[p[0]] &= ~tar;
        }
    }

    public void flip() {
        for (int i = 0; i < this.bits.length; i++) {
            this.bits[i] = ~this.bits[i];
        }
        this.oneCount = this.size - this.oneCount;
    }

    public boolean all() {
        return this.oneCount == this.size;
    }

    public boolean one() {
        return this.oneCount > 0;
    }

    public int count() {
        return this.oneCount;
    }

    public String toString() {
        int[] p = find(this.size - 1);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i <= p[0]; i++) {
            StringBuilder temp = new StringBuilder();
            long num = this.bits[i];
            for (int j = 0; j < 64; j++) {
                temp.insert(0, (num & 1) == 1 ? '1' : '0');
                num = num >> 1;
            }
            ans.append(temp);
        }
        return ans.substring(0, this.size);
    }
}
