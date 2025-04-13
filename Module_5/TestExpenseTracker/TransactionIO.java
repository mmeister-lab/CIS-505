/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package TestExpenseTracker;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;


public class TransactionIO {
    private static final String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);
   // static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    static Scanner sc = new Scanner(file);
    
    
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException{
        PrintWriter output = null;

        if(file.exists()){
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        }
        else{
            output = new PrintWriter(FILE_NAME);
        }

        for (Transaction tran : transactions)
        {
            output.print(tran.getDate() + ",");
            output.print(tran.getDescription() + ",");
            output.println(tran.getAmount());
        }
        output.close();
    }


    public static ArrayList<Transaction> findAll() throws IOException {
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