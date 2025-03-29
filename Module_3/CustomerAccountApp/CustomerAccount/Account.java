/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
/* W3 Schools. (n.d.). Java Date and Time. Refsnes Data. 
Retrieved March 27, 2025, from https://www.w3schools.com/java/java_date.asp */
package CustomerAccount;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {

    private double balance = 200.00;

    public void setBalance(double balance){
        this.balance = balance;
}

    public void deposit(double amt){
            balance = balance + amt;
    }

    public void withdraw(double amt){
        if(balance >= amt){
            balance = balance - amt;
        }
    }

    public String getTransactionDate()
    {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }
    
    public double getBalance()
    {
        return balance;
    }

    public static void displayMenu()
    {
        System.out.println("Account Menu");
        System.out.println("Enter <D/d> for deposit");
        System.out.println("Enter <W/w> for withdraw");
        System.out.println("Enter <B/b> for balance");
        System.out.print("  Enter option>:  ");

    }

}
