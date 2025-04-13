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
    static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    static Scanner sc = new Scanner(file);
    
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
 try{
        while(sc.hasNext()){
            transactions.add(sc.nextLine()); //The method add(Transaction) in the type ArrayList<Transaction> is not applicable for the arguments (String)   
        }}
        catch(IOException ioe){
            System.out.println("IOException has been thrown. - 2");
        }
  
        return transactions;
    
    }

}
s