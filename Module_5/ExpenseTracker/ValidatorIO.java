/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package ExpenseTracker;
import java.util.Scanner;

public class ValidatorIO {
/*Class named ValidatorIO to validate invalid user entries.*/
    /*Verify that input from scanner is int.*/
    public static int getInt(Scanner sc, String prompt){
        int input = 0;

        boolean isValid = false;

        while (!isValid)
        {
            System.out.print(prompt);
            if(sc.hasNextInt())
            {
                input = sc.nextInt();
                isValid = true;
            }
            else{
                System.out.println("\n Error! Invalid integer value..\n");            
            }
            sc.nextLine();
        }
    return input;
}

    /*Verify that input from scanner is double.*/
    public static double getDouble(Scanner sc, String prompt){
        double input = 0;

        boolean isValid = false;

        while (!isValid)
        {
            System.out.print(prompt);
            if(sc.hasNextDouble())
            {
                input = sc.nextDouble();
                isValid = true;
            }
            else{
                System.out.println("\n Error! Invalid double value...\n");
            }
            sc.nextLine();
        }
    return input;
    }

    /*Verify that input from scanner is a String.*/
    public static String getString(Scanner sc, String prompt){
        String input = "";

        boolean isValid = false;

        while (!isValid)
        {
            System.out.print(prompt);
            if(sc.hasNext())
            {
                input = sc.next();
                isValid = true;
            }
            else{
                System.out.println("\n Error! Invalid string value..\n");            
            }
            sc.nextLine();
        }
    return input;
}

}