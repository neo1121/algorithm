package algorithm.leetcode.problem_2043;

public class Bank {
    private final long[] balance;

    public Bank(long[] balance) {
        this.balance = balance.clone();
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > this.balance.length || account2 > this.balance.length) {
            return false;
        }
        synchronized (this) {
            if (this.balance[account1 - 1] < money) {
                return false;
            }
            this.balance[account1 - 1] -= money;
            this.balance[account2 - 1] += money;
        }
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account > this.balance.length) {
            return false;
        }
        synchronized (this) {
            this.balance[account - 1] += money;
        }
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > this.balance.length) {
            return false;
        }
        synchronized (this) {
            if (this.balance[account - 1] < money) {
                return false;
            }
            this.balance[account - 1] -= money;
        }
        return true;
    }
}
