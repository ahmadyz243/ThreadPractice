public class CheckingAccount {

    public CheckingAccount(int initialBalance) {
        balance = initialBalance;
    }

    private int balance;

    public boolean withdraw(int amount) {

        try {
            Thread.sleep((int) (Math.random() * 200));
            if (amount <= balance) {
                balance -= amount;
                return true;
            }
        } catch (InterruptedException e) {
        }
        return false;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

