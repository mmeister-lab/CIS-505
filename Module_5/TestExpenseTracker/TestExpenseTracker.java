/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package TestExpenseTracker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {

    public static void main(String[] args) {
        String menu = "Welcome to the Expense Tracker\n\nMENU OPTIONS\n  1. View Transaction\n  2. Add Transactions\n  3. View Expenses\n\nPlease choose an option:  ";
        int input;
        String continueMenu = "y";
        Scanner sc = new Scanner(System.in);   
        Scanner mn = new Scanner(System.in);     
        ArrayList<Transaction> transactions = new ArrayList<>();     

        while (!continueMenu.equalsIgnoreCase("n")){
        input = ValidatorIO.getInt(sc,menu);
    
        if(input == 1){
            try {
                transactions = TransactionIO.findAll();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       else if(input == 2)
       {
            String c = "y";
     
            while (c.equalsIgnoreCase("y"))
            {
                String description = ValidatorIO.getString(sc, "\n Enter the description:  ");
                double amount = ValidatorIO.getDouble(sc,"  Enter the amount:  ");

                Transaction transaction = new Transaction(description, amount);

                transactions.add(transaction);
                
                c = ValidatorIO.getString(sc, "\n   Add another transaction? (y/n):  ");
            }

            try{
                TransactionIO.bulkInsert(transactions);
            }
            catch (IOException e)
            {
                System.out.println("\n  Exception:  " + e.getMessage());
            }

        }
       /*else if(input == 3){
           double monthlyExpense = 0;
             transactions = TransactionIO.findAll();
            for (Transaction transaction : transactions)
            {
   
                monthlyExpense += transaction.getAmount();
            }

        }*/
        System.out.print("Continue? (y/n):  ");
        continueMenu = mn.next();
        mn.close();}
        System.out.print("Program terminated by the user...");

   }
}
