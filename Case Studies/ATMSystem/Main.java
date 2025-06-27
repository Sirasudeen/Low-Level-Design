package ATMSystem;

import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", "1234", 1000.00);
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Welcome to the ATM! =====");
        System.out.print("Please enter your PIN: ");
        String pin = scanner.nextLine();

        if (atm.login(account, pin)) {
            boolean running = true;
            while (running) {
                System.out.println("\n--- ATM Menu ---");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. View Transaction History");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch(choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 4:
                        atm.printTransactionHistory();
                        break;
                    case 5:
                        running = false;
                        atm.logout();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
        scanner.close();
    }
}
