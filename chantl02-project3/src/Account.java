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
 * The Account class represents the user's bank account. It
 * contains all the data and operations necessary for
 * transactions
 */
public class Account {
    // Variables declaration
    private double balance;
    private int pin;

    /**
     * Simply gets the pin
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

    /*
     * takes a paramater to initialize the balance, along with
     * calling createPin()
     */
    public Account(double iDeposit) {
        this.balance = iDeposit;
        createPin();
    } // end of Account()

    /**
     * Simply gets the account balance
     * @return      Returns the account balance
     */
    public double getBalance() {
        return balance;

    } // end of getBalance()
} // end of Account