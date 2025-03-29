/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package CustomerAccount;
import java.util.Scanner;
public class TestCustomerAccountApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int customerID;
        System.out.println("Welcome to the Customer Account App");
        System.out.println();
        System.out.print("Enter a customer ID:");
        System.out.println("  ex: 1007, 1008, 1009>:  ");
        customerID = input.nextInt();
        String accountAction;
        Customer currentCustomer = CustomerDB.getCustomer(customerID);
        Account currentAccount = new Account();
        String loopContinue = "y";
        do{  
            Account.displayMenu();
            accountAction = input.next();
            System.out.println();
            double amt;
            
            if(accountAction.compareToIgnoreCase("b")==0){
                System.out.print("Account balance: ");
                System.out.printf("$%-6.2f",currentAccount.getBalance());
                System.out.println();
            }
            else if(accountAction.compareToIgnoreCase("w")==0){
                System.out.print("Enter withdraw amount: ");
                amt = input.nextDouble();
                currentAccount.withdraw(amt);
            }
            else if(accountAction.compareToIgnoreCase("d")==0){
                System.out.print("Enter deposit amount: ");
                amt = input.nextDouble();
                currentAccount.deposit(amt);
            }
            else{
                System.out.println("Error: Invalid Option.");
            }
            System.out.println();
            System.out.print("Continue? (y/n):  ");
        loopContinue = input.next();
       }while (loopContinue.compareToIgnoreCase("y")==0);
       System.out.println();
       System.out.println(currentCustomer.toString());
       System.out.print("Balance as of "+ currentAccount.getTransactionDate()+" is ");
       System.out.printf("$%-6.2f",currentAccount.getBalance());
       System.out.println();
       System.out.println();
       System.out.println("End of line...");
       input.close();
    }
}
