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
 * The Account class represents the user's bank accout. It
 * contains all the data and operations necessary for
 * transactions
 */
public class Account {
    // Variables declaration
    double balance;
    int pin;

    /**
     * Simply returns the pin
     * @param accPin        Account pin
     * @return              Returns the pin
     */
    public static int getPin(int accPin) {
        return accPin;

    } // end of getPin()

    /**
     * Assigns a pin in the format of a random four digit
     * number
     */
    public static void createPin() {

        
    } // end of createPin()

    /**
     * Takes accBalance and assigns the balance to it
     * @param accBalance            Account balance
     */
    public static void setBalance(double accBalance) {


    } // end of setBalance()

    /**
     * Will display the current balance after certain events
     */
    public static void showBalance() {

    } // end of showBalance()

    /**
     * Takes a parameter for the withdrawn amount, updates the
     * balance, and if the parameter is greater than the balance,
     * it will print (in the console) that the required amount
     * exceeds the balance
     */
    public static void withdraw() {


    } // end of withdraw()

    Account acc = new Account();

    /**
     * Simply returns the account balance
     * @param accBalance       Account balance
     * @return                  Returns the account balance
     */
    public static double getBalance(double accBalance) {
        return accBalance;

    } // end of getBalance()
} // end of Account