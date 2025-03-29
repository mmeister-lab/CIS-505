/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package CustomerAccount;

public class CustomerDB{

    public static Customer getCustomer (Integer id)
    {
     
        if(id == 1007){
            
            return new Customer("Jennifer Patterson","8422 Grover Ave.","Bellevue","68123");
        }
        else if(id == 1008)
        {
            return new Customer("Bill Smith","100 Memory Lane","Sioux City","51106");

        }
        else if(id == 1009)
        {
            return new Customer("Juli Jones","6th Ave.","Ponca","69760");
        }
        else{
            return new Customer();}

    }



}
