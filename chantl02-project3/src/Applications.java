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

import java.util.*;             // needed for the JOptionPane class

import javax.swing.JDialog;
import javax.swing.JOptionPane; // needed for the Scanner class

/*
 * The Applications class will control the program's logic.
 * It communicates with the user regarding the choices the
 * user makes
 */
public class Applications {
    /**
     * 
     * @param args      Entered values
     */
    public static void main(String[] args) {
        // variables declaration
        Account acc = null;
        ATM atm = null;
        boolean client = true, transactionRequired;
        String title, message;
        /*
         * due to the JOptionPane dialogue boxes sometimes appearing
         * behind all of your windows, you will need to declare a
         * JDialog and setAlwaysOnTop to true
         */
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);

        while (client) {
            transactionRequired = true;

            title = "Client Window";
            message = "Would you like to open an account?" +
                        "\nThe minimum deposit is 100 dollars." +
                        "\nIf you have an account, please click Cancel.";
            int accOpen = JOptionPane.showConfirmDialog(dialog,
                                                        message, title,
                                                        JOptionPane.YES_NO_CANCEL_OPTION);

            if (accOpen == JOptionPane.YES_OPTION) {
                message = "Please enter the amount to deposit." +
                            "\nPlease take note that a PIN code " +
                            "will be issued for you";
                int deposit = Integer.parseInt(JOptionPane.showInputDialog(dialog, 
                                                                            message, title,
                                                                            JOptionPane.WARNING_MESSAGE));
                
                acc = new Account(deposit);

                atm = new ATM(acc);
            }
        } // end of while (client)

    } // end of main()
} // end of Applications