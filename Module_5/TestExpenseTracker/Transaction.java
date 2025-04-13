/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
/* W3 Schools. (n.d.). Java Date and Time. Refsnes Data. 
Retrieved March 27, 2025, from https://www.w3schools.com/java/java_date.asp */
package TestExpenseTracker;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class Transaction {
private String date;
private String description;
private double amount;

Transaction(){
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    String formattedDate = myDateObj.format(myFormatObj);
    this.date = formattedDate;
    description = "";
    amount = 0;
}

Transaction(String description, double amount){
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    String formattedDate = myDateObj.format(myFormatObj);
    this.date = formattedDate;
    this.description = description;
    this.amount = amount;
}

public String getDate() {
    return date;
}


public void setDate(String date) {
    this.date = date;
}



public String getDescription() {
    return description;
}


public void setDescription(String description) {
    this.description = description;
}


public double getAmount() {
    return amount;
}



public void setAmount(double amount) {
    this.amount = amount;
}


@Override
public String toString() {
    return String.format("MONTHLY EXPENSES%s%nDate:  %s%nDescription:  %s%nAmount:  $%,6.2f", date, description, amount);
}


}
