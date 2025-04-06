/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package BowlingShopApp;

public class Bag extends Product {

    private String type;

    public Bag() {
        type = "";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
       
        return super.toString() + "\nType:  " + getType() + "\n";
    }
    
}
