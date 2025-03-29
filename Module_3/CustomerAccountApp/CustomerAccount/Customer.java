/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package CustomerAccount;
public class Customer{

private String name;
private String address;
private String city;
private String zip;

public Customer(){
        this.name = "Tony Stark";
        this.address = "10880 Malibu Point";
        this. city = "Malibu";
        this.zip = "90265";
}

public  Customer(String name, String address, String city, String zip){
        this.name = name;
        this.address = address;
        this. city = city;
        this.zip = zip;
}
/*Overriding toString() method of String class*/
 @Override
 public String toString() {
        return("--Customer Details--"+"\n"+"Name:  "+name+"\n"+"Address:  "+address+"\n"+"City:  "+city+"\n"+"Zip:  "+zip+"\n");}
      
}
