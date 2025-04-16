/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package ExpenseTracker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {
    /*Menu method*/
    public static String menu(){
        return "Welcome to the Expense Tracker\n\nMENU OPTIONS\n  1. View Transaction\n  2. Add Transactions\n  3. View Expenses\n\nPlease choose an option:  ";
    }
    public static void main(String[] args) {
        int input;
        String continueMenu = "y";
        /*Scanner class is used to get user input, and it is found in the java.util package.
        If static, a Unresolved compilation problem error will result*/
        Scanner sc = new Scanner(System.in);   


        /*Loop that allows program to run until user enters "n'"*/
        while (!continueMenu.equalsIgnoreCase("n")){
            /*ValidatorIO static method to validate the users input as int.*/
            input = ValidatorIO.getInt(sc,menu());
             /* New instance of ArrayList. Creating the instance at the class level cause duplication of entries. */ 
             ArrayList<Transaction> transactions = new ArrayList<>();     
            /*Display transactions*/
            if(input == 1){
                try {
                    System.out.println("\nMONTHLY EXPENSES\n");
                    transactions = TransactionIO.findAll();
                    for (Transaction transaction : transactions)
                {
    
                    System.out.println(transaction);
                }

                } catch (IOException e) {
                    /*Outputs the stack trace of an exception to the standard error stream.*/
                    e.printStackTrace();
                }
            }
            /*Enter transactions*/
            else if(input == 2)
            {
                String c = "y";
                /*loop that allows user to enter as many transactions as they wish */
                while (c.equalsIgnoreCase("y"))
                {
                    /*ValidatorIO static method to validate the users input is string.*/
                    String description = ValidatorIO.getString(sc, "\n Enter the description:  ");
                    /*ValidatorIO static method to validate the users input is a double.*/
                    double amount = ValidatorIO.getDouble(sc,"  Enter the amount:  ");

                    /*Call to create instance of Transaction constructor passing description 
                     * and amount.
                     */
                    Transaction transaction = new Transaction(description, amount);

                    /*Add description and amount to array.*/
                    transactions.add(transaction);
                    /*ValidatorIO static method to validate the users input is string.*/
                    c = ValidatorIO.getString(sc, "\n   Add another transaction? (y/n):  ");
                }

                try{
                    /*Call method to write array values to file.*/
                    TransactionIO.bulkInsert(transactions);
                }
                catch (IOException e)
                {
                    System.out.println("\n  Exception:  " + e.getMessage());
                }
            }
            /*Calculate total monthly expenses.*/
            else if(input == 3){
                
                try {
                    transactions = TransactionIO.findAll();
                    double monthlyExpense = 0.0;
                    /*Iterate over the list to get a running total of the transaction amounts. */
                    for (Transaction transaction : transactions)
                    {
                        monthlyExpense += transaction.getAmount();
                    }
                    /*Format output to screen of monthly expense total */
                    String expenseFormat = String.format("%nTotalExpenses:  $%,6.2f",monthlyExpense);
                    /*Print formatted string */
                    System.out.println(expenseFormat);
                } catch (IOException e) {
                    /*Outputs the stack trace of an exception to the standard error stream.*/
                    e.printStackTrace();
                }
            }
            /*ValidatorIO static methods to validate the users input is a string.*/
            continueMenu = ValidatorIO.getString(sc, "\nContinue? (y/n): ");
        }
        sc.close();
        System.out.print("Program terminated by the user...");
    }
}
