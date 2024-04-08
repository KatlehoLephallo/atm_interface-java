package atm;

public class ATM_Machine implements Bank{
    BankAccount account = new BankAccount();
    @Override
    public int checkBalance() {
        return account.getBalance();
    }

    @Override
    public void deposit(int amount) {
        account.setBalance(account.getBalance()+amount);
    }

    @Override
    public void withdraw(int amount) {
        if (account.getBalance() > amount) {
            account.setBalance(account.getBalance() - amount);
        }
    }
}
