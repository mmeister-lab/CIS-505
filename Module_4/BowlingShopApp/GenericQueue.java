/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package BowlingShopApp;
import java.util.LinkedList;

public class GenericQueue<E> {
    private LinkedList<E> list = new LinkedList<E>();

    public void enqueue(E item)
    {
        list.addFirst(item);
    }

    public E dequeue()
    {
        return list.removeFirst();
    }
    public int size()
    {
        return list.size();

    }
}
