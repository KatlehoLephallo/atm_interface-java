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
            System.out.println("please select from the following: \n- (C) CheckBalance \n- (W) Withdrawal \n- (D Deposit \n- (Q) Quit");
            System.out.print("Enter option: ");
            option = scanner.nextLine();
            if (option.equalsIgnoreCase("c")){
                System.out.println("Balance: "+ machine.checkBalance());
                holdTab();
            }
            else if (option.equalsIgnoreCase("d")){
                System.out.print("How much do you want to deposit: ");
                amount = scanner.nextLine();
                if (convertToInt(amount) == null){
                    System.out.println("you didn't enter a valid value");
                }else {
                    machine.deposit(Integer.parseInt(amount));
                    System.out.println(">    Transaction complete!");
                }
                holdTab();
            }
            else if (option.equalsIgnoreCase("w")){
                System.out.print("How much do you want to withdraw: ");
                amount = scanner.nextLine();
                if (convertToInt(amount) == null){
                    System.out.println("you didn't enter a valid value");
                }
                else if (machine.checkBalance() < convertToInt(amount)) {
                    System.out.println("You don't have sufficient funds");
                } else {
                    machine.withdraw(Integer.parseInt(amount));
                    System.out.println(">    Transaction complete!");
                }
                holdTab();
            }
            else if (option.equalsIgnoreCase("q")) {
                System.out.println("Thank you...");
                break;
            }
        }


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
            System.out.println("press enter to continue");
            hold = scanner.nextLine();
            if (hold == null){
                break;
            }else
                break;
        }
    }

}

