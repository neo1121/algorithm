package problem_2043

import "sync"

var mutex sync.Mutex

type Bank struct {
	balance []int64
	number  int
}

func Constructor(balance []int64) Bank {
	return Bank{balance, len(balance)}
}

func (this *Bank) Transfer(account1 int, account2 int, money int64) bool {
	if account1 > this.number || account2 > this.number {
		return false
	}
	mutex.Lock()
	defer mutex.Unlock()
	if this.balance[account1-1] < money {
		return false
	}
	this.balance[account1-1] -= money
	this.balance[account2-1] += money
	return true
}

func (this *Bank) Deposit(account int, money int64) bool {
	if account > this.number {
		return false
	}
	mutex.Lock()
	defer mutex.Unlock()
	this.balance[account-1] += money
	return true
}

func (this *Bank) Withdraw(account int, money int64) bool {
	if account > this.number {
		return false
	}
	mutex.Lock()
	defer mutex.Unlock()
	if this.balance[account-1] < money {
		return false
	}
	this.balance[account-1] -= money
	return true
}
