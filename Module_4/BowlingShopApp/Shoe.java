/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package BowlingShopApp;

public class Shoe extends Product{

    private double size;

    public Shoe() {
        size = 0;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
    
        return super.toString() + "\n Size:  " + getSize();
    }
    
    
}
