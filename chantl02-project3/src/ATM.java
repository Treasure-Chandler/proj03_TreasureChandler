/*
 * Treasure Chandler
 * CS 16000-01 – 02/03, Fall Semester 2024
 * Project 3: At the ATM Machine
 *
 * Description:
 * The purpose of this class is to implement a computer
 * model for bank account transactinons at an ATM machine.
 * This following functions this class will program is
 * to open a new account, use an existing account that is
 * previously opened, and abort the process.
 */

/*
 * The ATM class represents the ATM machine. It communicates to
 * the user when a transaction is carried out. In order to execute
 * the transactions, the class must have access to the Account
 * class methods
 */

import java.util.*;     // Needed for the Scanner class
import javax.swing.*;   // Needed for the JOptionPane class

public class ATM {
    // Variables declaration
    Account acc;
    String title, message, userDorW;
    int userPin, withdrawAmount, depositAmount, depositTotal;
    Scanner keyboard = new Scanner(System.in);

    // Takes an account type parameter to initialize the acc field
    public ATM(Account iAcc) {
        this.acc = iAcc;
    } // End of ATM()

    /**
     * Simply executes all of the necessary methods and operations
     * for the user to deposit/withdraw money to/from their account
     */
    public void transaction() {
        // Figure 5:
        message = "Please enter W or w to withdraw." +
                    "\nEnter D or d to deposit.";
        userDorW = JOptionPane.showInputDialog(null, message);

        /*
         * Safety check: if the user clicks cancel, the program
         * will terminate. Otherwise, the program will continue
         */
        if (userDorW == null) {
            System.out.println("The process will terminate." +
                        "\nThank you, goodbye!");
            System.exit(0);
        } else {
            /*
             * If the user's input is W or w, it will solicit and read the pin
             * code from the console
             */
            if (userDorW.equals("W") || userDorW.equals("w")) {
                // Figure 6:
                System.out.println("Please enter your PIN code here:");
                userPin = keyboard.nextInt();

                // Checks for if the inputted pin equals the account pin
                if (userPin == acc.getPin()) {
                    // Figure 7:
                    message = "Please enter the amount you want to withdraw:";
                    withdrawAmount = Integer.parseInt(JOptionPane.showInputDialog(null,
                            message));

                    // Calls withdraw() using withdrawAmount for the parameter
                    acc.withdraw(withdrawAmount);

                    // Calls showBalance()
                    acc.showBalance();
                } else {
                    /*
                     * Otherwise, the transaction is aborted and the program ends
                     * 
                     * Figure 9:
                     */
                    System.out.println("Wrong PIN; transaction aborted.");
                    System.exit(0);
                }
            }

            /*
             * If the user's input is D or d, it will then explain to the user
             * what dollar bills are accepted
             */
            if (userDorW.equals("D") || userDorW.equals("d")) {
                // Figure 11:
                title = "Accepted Bills";
                message = "We accept the following dollar bills:" +
                        "\n1, 5, 10, 20, 50, 100" +
                        "\nPlease insert the bill in the console." +
                        "\nEnter any other number to stop depositing.";
                JOptionPane.showMessageDialog(null, message);

                // Figure 12:
                System.out.println("Enter the bills here:");

                // This while loop reads the bills
                while (true) {
                    depositAmount = keyboard.nextInt();

                    // Validates the billing input
                    if (depositAmount == 1 || depositAmount == 5 ||
                            depositAmount == 10 || depositAmount == 20 ||
                            depositAmount == 50 || depositAmount == 100) {
                        // Sums up the valid bills
                        depositTotal += depositAmount;
                    } else {
                        /*
                         * The loop will break if the input is not an
                         * admissible bill
                         */
                        break;
                    }
                } // End of while (true)

                // Calls deposit()
                acc.deposit(depositTotal);

                // Calls showBalance()
                acc.showBalance();
            }
        }
    } // End of transaction()
} // End of ATM