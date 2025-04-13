/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package TestExpenseTracker;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;


public class TransactionIO {
    private static final String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);
 
    TransactionIO(){
    }
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
            output.print(tran.getDate() + " ");
            output.print(tran.getDescription() + " ");
            output.println(tran.getAmount());
        }
        output.close();
    }
    public static ArrayList<Transaction> findAll() throws IOException{
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
       // Scanner sc = new Scanner(file);
       // output = new PrintWriter(new FileOutputStream(new File(FILE_NAME)));
       
        {
        //while(sc.hasNext()){
        //    transactions.add(sc.nextLine());
      //  }
   
        return transactions;
    
    }

}
