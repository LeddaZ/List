import List.List;
import List.OrderedList;

import java.io.IOException;

/**
 * Example class to show the usage of List and OrderedList
 * @author Leonardo Ledda (LeddaZ)
 */
public class ListExample {

    public static void main(String[] args) throws IOException {
        List l = new List("Example");
        OrderedList ol = new OrderedList("OrderedExample");

        l.add("test");
        l.add("hi");
        ol.add("hello world");
        ol.add("this is a test");
        ol.add("example");
        l.add("123");
        l.save();
        ol.save();
        l.clear();
        l.display();
        ol.displayCompact();
    }

}
