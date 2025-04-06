/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package BowlingShopApp;

public class ProductDB {

      
    public static GenericQueue<Product> getProducts(String code){
       GenericQueue<Product> cart = new GenericQueue<Product>();    
       if(code.compareToIgnoreCase("b")==0){
         
            Ball ball1 = new Ball();
            ball1.setCode("B100");
            ball1.setDescription("Black Widow 2.0");
            ball1.setPrice(144.95);
            ball1.setColor("Black and Red");
  
            Ball ball2 = new Ball();
            ball2.setCode("B500");
            ball2.setDescription("Phaze III");
            ball2.setPrice(154.99);
            ball2.setColor("Purple and Green");

            Ball ball3 = new Ball();
            ball3.setCode("B400");
            ball3.setDescription("Force Unleashed");
            ball3.setPrice(139.99);
            ball3.setColor("Red and White");

            Ball ball4 = new Ball();
            ball4.setCode("B300");
            ball4.setDescription("Proton Physix");
            ball4.setPrice(174.95);
            ball4.setColor("Pink and Purple");

            Ball ball5 = new Ball();
            ball5.setCode("B200");
            ball5.setDescription("Axiom Pearl");
            ball5.setPrice(154.95);
            ball5.setColor("Blue and Red");

            cart.enqueue(ball1);
            cart.enqueue(ball2);
            cart.enqueue(ball3);
            cart.enqueue(ball4);
            cart.enqueue(ball5);
        }
       else if(code.compareToIgnoreCase("s")==0){
         
            Shoe shoe1 = new Shoe();
            shoe1.setCode("S500");
            shoe1.setDescription("Youth Skull Green/Black");
            shoe1.setPrice(39.99);
            shoe1.setSize(3.0);

            Shoe shoe2 = new Shoe();
            shoe2.setCode("S400");
            shoe2.setDescription("Men's Tribal Path Lite Seamless Mesh");
            shoe2.setPrice(26.99);
            shoe2.setSize(8.5);

            Shoe shoe3 = new Shoe();
            shoe3.setCode("S300");
            shoe3.setDescription("Women's Path Lite Seamless Mesh");
            shoe3.setPrice(54.99);
            shoe3.setSize(6.0);

            Shoe shoe4 = new Shoe();
            shoe4.setCode("S200");
            shoe4.setDescription("Women's Rise Black/Hot Pink");
            shoe4.setPrice(39.99);
            shoe4.setSize(7.0);

            Shoe shoe5 = new Shoe();
            shoe5.setCode("S100");
            shoe2.setDescription("Men's Run Black");
            shoe5.setPrice(39.99);
            shoe5.setSize(10.5);
 
            cart.enqueue(shoe1);
            cart.enqueue(shoe2);
            cart.enqueue(shoe3);               
            cart.enqueue(shoe4);     
            cart.enqueue(shoe5);
        }
        else if(code.compareToIgnoreCase("a")==0){
         
            Bag bag1 = new Bag();
            bag1.setCode("A300");
            bag1.setDescription("Silver/Royal Blue");
            bag1.setPrice(74.99);
            bag1.setType("Triple");

            Bag bag2 = new Bag();
            bag2.setCode("A200");
            bag2.setDescription("Prime Roller Black/Royal Blue");
            bag2.setPrice(54.99);
            bag2.setType("Double");
   
            Bag bag3 = new Bag();
            bag3.setCode("A100");
            bag3.setDescription("Path Pro Deluxe");
            bag3.setPrice(34.99);
            bag3.setType("Single");
  
            cart.enqueue(bag1);
            cart.enqueue(bag2);
            cart.enqueue(bag3);   
        }
        return cart;
    }
    
}
