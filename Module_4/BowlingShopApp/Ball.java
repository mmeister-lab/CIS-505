/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package BowlingShopApp;

public class Ball extends Product{

    private String color;

    public Ball() {
        color = "";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
      // return super.getPrice();
       return super.toString() + "\n Color:  " + getColor();
    }
    
    
    
}
