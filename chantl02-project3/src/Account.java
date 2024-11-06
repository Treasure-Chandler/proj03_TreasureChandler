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
 * The Account class represents the user's bank account. It
 * contains all the data and operations necessary for
 * transactions
 */
import java.util.Random;    // Needed for the Random class
import javax.swing.*;       // Needed for the JOptionPane class

public class Account {
    // Variables declaration
    private double balance;
    private int pin;
    Random rand = new Random();
    String title, message;

    /**
     * Assigns a pin in the format of a random four digit
     * number
     */
    public void createPin() {
        pin = 1000 + rand.nextInt(9000);
    } // End of createPin()

    /**
     * Simply gets the account pin
     * @return      Returns the pin
     */
    public int getPin() {
        return pin;
    } // End of getPin()

    /**
     * Takes accBalance and assigns the balance to it
     * @param accBalance        Account balance
     */
    public void setBalance(double accBalance) {
        this.balance = accBalance;
    } // End of setBalance()

    /**
     * Will display the current balance after certain events
     */
    public void showBalance() {
        // Figures 8/13:
        title = "Balance";
        message = "The current balance is\n" +
                    String.format("$%.2f", balance);
        JOptionPane.showMessageDialog(null, message);
    } // End of showBalance()

    /**
     * Takes a parameter for the deposit value and
     * updates the balance
     * @param uDeposit      User deposit
     */
    public void deposit(double uDeposit) {
        this.balance = this.balance + uDeposit;
    } // End of deposit()

    /**
     * Takes a parameter for the withdrawn amount, updates the
     * balance, and if the parameter is greater than the balance,
     * it will print (in the console) that the required amount
     * exceeds the balance
     * @param uWithdraw     User withdraw
     */
    public void withdraw(double uWithdraw) {
        this.balance = this.balance - uWithdraw;

        // figure 16:
        if (uWithdraw > this.balance) {
            System.out.print("The required amount exceeds the balance."
                                + "\nYou will now recieve your balance:");
        }
    } // End of withdraw()

    /*
     * Takes a paramater to initialize the balance, calls 
     * createPin(), and then displays the actual pin
     */
    public Account(double iDeposit) {
        this.balance = iDeposit;
        createPin();

        // figure 3:
        message = "Take note of your PIN:\n" +
                    String.format("%4d", getPin());
        JOptionPane.showMessageDialog(null, message);
    } // End of Account()

    /**
     * Simply gets the account balance
     * @return      Returns the account balance
     */
    public double getBalance() {
        return balance;
    } // End of getBalance()
} // End of Account