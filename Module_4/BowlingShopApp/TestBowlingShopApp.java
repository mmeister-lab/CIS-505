/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package BowlingShopApp;
import java.util.Queue;
import java.util.Scanner;

public class TestBowlingShopApp{
    static void displayMenu(){
 
        System.out.println("MENU OPTIONS");
        System.out.println("  1.  <b> Bowling Balls");
        System.out.println("  2.  <a> Bowling Bags");
        System.out.println("  3.  <s> Bowling Shoes");
        System.out.println("  4.  <x> To exit");
        System.out.println();
        System.out.print("Please choose an option:  ");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  
        String menuChoice = "";
       do {
            displayMenu();
            menuChoice = input.next();
            GenericQueue<Product> products = new GenericQueue<>();
            products = ProductDB.getProducts(menuChoice);    
            while(products.size() > 0){
              //System.out.println(products.dequeue());
              
               System.out.printf(products.dequeue());
               
                    //System.out.println(products.toString());
            }

          }while (menuChoice.compareToIgnoreCase("x")!=0);
}
}