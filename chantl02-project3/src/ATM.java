/*
* Treasure Chandler
* CS 16000-01 – 02/03, Fall Semester 2024)
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

import java.util.*;     // needed for the Scanner class
import javax.swing.*;   // needed for the JOptionPane class

public class ATM {
    // variables declaration
    Account acc;
    Scanner keyboard;
    String message, userWithdraw;
    int userPin, withdrawAmount;

    // takes an account type parameter to initialize the acc field
    public ATM(Account iAcc) {
        this.acc = iAcc;
    } // end of ATM()

    public void transaction() {
        // figure 5:
        message = "Please enter W or w to withdraw." +
                    "\nEnter D or d to deposit.";
        userWithdraw = JOptionPane.showInputDialog(null, message);

        /*
         * if the user's input is W or w, it will solicit and read the pin
         * code from the console
         */
        if (userWithdraw == "W" || userWithdraw == "w") {
            // figure 6:
            System.out.println("Please enter your PIN code here:");
            userPin = keyboard.nextInt();

            // checks for if the inputted pin equals the account pin
            if (userPin == acc.getPin()) {
                // figure 7:
                message = "Please enter the amount you want to withdraw:";
                withdrawAmount = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                                                message));

                // calls withdraw() using withdrawAmount for the parameter
                acc.withdraw(withdrawAmount);

                // calls showBalance()
                acc.showBalance();
            } else {
                /*
                 * otherwise, the transaction is aborted and the program ends
                 * 
                 * figure 9:
                 */
                System.out.println("Wrong PIN; transaction aborted.");
                System.exit(0);
            }
        }
    } // end of transaction()
} // end of ATM
