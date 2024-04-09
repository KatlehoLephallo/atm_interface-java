package atm;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    ATM_Machine machine = new ATM_Machine();

    public static void main(String[] args) {
        Main main = new Main();
        main.userInterface();
    }

    public void userInterface(){
        String option;
        String amount;

        System.out.println("Welcome to The Martinelli Bank!");
        while (true){
            System.out.println("please select from the following: \n- (B) Check Balance \n- (W) Withdrawal \n- (D Deposit \n- (Q) Quit");
            System.out.print("Enter option: ");
            option = scanner.nextLine();

            if (option.equalsIgnoreCase("b")){
                showBalance(machine);
            }
            else if (option.equalsIgnoreCase("d")){
                System.out.print("How much do you want to deposit: ");
                amount = scanner.nextLine();
                processDeposit(amount, machine);
            }
            else if (option.equalsIgnoreCase("w")){
                System.out.print("How much do you want to withdraw: ");
                amount = scanner.nextLine();
                processWithdrawal(amount, machine);
            }
            else if (option.equalsIgnoreCase("q")) {
                System.out.println("Thank you...");
                break;
            }
        }


    }

    public void showBalance(ATM_Machine machine){
        System.out.println("Balance: R"+ machine.checkBalance());
        holdTab();
    }

    public void processDeposit(String amount, ATM_Machine machine) {
        if (convertToInt(amount) == null) {
            System.out.println("You didn't enter a valid value");
        } else {
            machine.deposit(Integer.parseInt(amount));
            System.out.println(">    Transaction complete!");
        }
        holdTab();
    }

    public void processWithdrawal(String amount, ATM_Machine machine) {
        if (convertToInt(amount) == null) {
            System.out.println("You didn't enter a valid value");
        } else if (machine.checkBalance() < convertToInt(amount)) {
            System.out.println("You don't have sufficient funds");
        } else {
            machine.withdraw(Integer.parseInt(amount));
            System.out.println(">    Transaction complete!");
        }
        holdTab();
    }

    private Integer convertToInt(String input){

        try {
            int number = Integer.valueOf(input);
            return number;
        }catch (NumberFormatException e){
            return null;
        }
    }

    private void holdTab(){
        String hold;
        while (true){
            System.out.println("press enter to go back to menu");
            hold = scanner.nextLine();
            break;
        }
    }

}

