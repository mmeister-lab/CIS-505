/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package ExpenseTracker;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;


public class TransactionIO {
/*aA class named TransactionIO for reading and writing transactions to a text file.*/
    private static final String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);
    
    /*Method to insert date, description, and amount in file from ArrayList passed from
     * TestExpenseTracker.java class*/
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException{
        PrintWriter output = null;

        if (file.exists()) {
            output = new PrintWriter(new FileOutputStream(file, true));
        }
        else{
            output = new PrintWriter(FILE_NAME);
        }
        /*Iterates through a collection called transactions, where each element in the collection 
        is of type Transaction. Inside the loop, tran is a variable that will hold the 
        current Transaction object being processed in each iteration.*/
        for (Transaction tran : transactions)
        {
            output.print(tran.getDate() + "\n");
            output.print(tran.getDescription() + "\n");
            output.println(tran.getAmount() + "\n");
        }
        output.close();
    }

    /*Method to read file into ArrayList for TestExpenseTracker display of transactions 
    and monthly total.*/
    public static ArrayList<Transaction> findAll() throws IOException {
        /*Create new instance of transactions ArrayList to contain data from file.*/
        ArrayList<Transaction> transactions = new ArrayList<>();
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
           String date = input.next();
           String description = input.next();
           double amount = input.nextDouble();
           Transaction t = new Transaction(description, amount);
           t.setDate(date);
           transactions.add(t);
        }

        input.close();
        return transactions;
    }

}