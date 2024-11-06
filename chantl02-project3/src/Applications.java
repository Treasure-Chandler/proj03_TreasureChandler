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
 * The Applications class will control the program's logic.
 * It communicates with the user regarding the choices the
 * user makes
 */
import javax.swing.*;   // Needed for the JOptionPane class

public class Applications {
    /**
     * 
     * @param args      Entered values
     */
    public static void main(String[] args) {
        // Variables declaration
        Account acc = null;
        ATM atm = null;
        boolean client = true, transactionRequired;
        String title, message;
        /*
         * Due to the JOptionPane dialogue boxes sometimes appearing
         * behind all of your windows, you will need to declare a
         * JDialog and setAlwaysOnTop to true
         */
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);

        // The outer loop, while the user requires service
        while (client) {
            transactionRequired = true;

            // Figure 1:
            title = "Client Window";
            message = "Would you like to open an account?" +
                        "\nThe minimum deposit is 100 dollars." +
                        "\nIf you do not have an account, please click Cancel.";
            int accOpen = JOptionPane.showConfirmDialog(dialog, message, title,
                                                        JOptionPane.YES_NO_CANCEL_OPTION);

            if (accOpen == JOptionPane.YES_OPTION) {
                /*
                 * If the user clicks yes, figure 2; this dialog popup solicits the
                 * deposit amount
                 */
                message = "Please enter the amount to deposit." +
                            "\nPlease take note that a PIN code " +
                            "will be issued for you:";
                int deposit = Integer.parseInt(JOptionPane.showInputDialog(dialog, message, title,
                                                                            JOptionPane.WARNING_MESSAGE));
                
                /*
                 * Instantiates the acc reference, with Account() taking the deposit as
                 * the parameter
                 */
                acc = new Account(deposit);

                /*
                 * Instantiates the atm reference, with ATM() taking the account reference
                 * as the parameter
                 */
                atm = new ATM(acc);
            } else if (accOpen == JOptionPane.NO_OPTION) {
                /*
                 * If the user clicks no, the program will be terminated
                 * 
                 * Figure 14:
                 */
                System.out.println("The process will terminate." +
                                    "\nThank you, goodbye!");
                System.exit(0);
            } else if (acc == null) {
                /*
                 * If the user does not have an account, then the client is assigned false
                 * 
                 * Figure 15:
                 */
                title = "Client Window";
                message = "Sorry, you do not have an account." +
                            "\nThe program will terminate, and " +
                            "it will need to be restarted.";
                JOptionPane.showMessageDialog(dialog, message, title, JOptionPane.ERROR_MESSAGE);
                client = false;
                System.exit(0);
            } else {
                /*
                 * Otherwise, the atm reference is instantiated, with ATM() taking the acc
                 * reference as the parameter
                 */
                atm = new ATM(acc);
            }

            // The inner loop, while the transaction is ongoing
            while (transactionRequired) {
                // Figure 4:
                title = "Client Window";
                message = "Click Yes to make a transaction." +
                            "\nClick No to exit the current process.";
                int transactionPick = JOptionPane.showConfirmDialog(dialog, message, title,
                                                                    JOptionPane.YES_NO_OPTION);

                if (transactionPick == JOptionPane.NO_OPTION) {
                    /*
                     * If the user clicks no, transactionRequired is assigned falsem and
                     * terminate the program.
                     */
                    transactionRequired = false;
                    System.out.println("The process will terminate." +
                                        "\nThank you, goodbye!");
                    System.exit(0);
                } else {
                    // Otherwise, atm calls transaction()
                    atm.transaction();
                }
            } // End of while (transactionRequired)
        } // End of while (client)
    } // End of main()
} // End of Applications