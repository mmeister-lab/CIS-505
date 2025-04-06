/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package BowlingShopApp;

public class Product {
    private String code;
    private String description; 
    private double price;

    public Product() {
        code = "";
        description = "";
        price = 0;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
       
        return String.format("Product Code:  %s%nDescription:  %s%nPrice:  $%,6.2f", code, description, price);
    }


}
