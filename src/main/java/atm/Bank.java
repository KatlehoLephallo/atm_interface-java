package atm;

public interface Bank {

    int checkBalance();
    void deposit(int amount);
    void withdraw(int amount);
}
