class Bank {
    long[] bal = null;
    int sz = 0;
    public Bank(long[] balance) {
        bal = balance;
        sz = balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1 > sz || account2 > sz || account1 < 1 || account2 < 1 || bal[account1-1] < money) return false;

        bal[account1-1] -= money;
        bal[account2-1] += money;

        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account > sz || account < 1) return false;
        
        bal[account-1] += money;

        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account > sz || account < 1 || bal[account-1] < money) return false;
        
        bal[account-1] -= money;

        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */