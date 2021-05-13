import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Creates an alphabetically ordered list.
 * @author LeddaZ
 */
public class List {

    // Environment variables
    private String name;
    private String filename;
    private ArrayList<String> items;

    /**
     * Constructor method. Initializes a new list with a name and a filename
     * (list name followed by .txt).
     * @param listName the list's name
     */
    public List(String listName) {
        this.name = listName;
        this.filename = listName + ".txt";
        this.items = new ArrayList<String>();
    }

    /**
     * Adds an item to the list and sorts the list alphabetically to reorder
     * the items.
     * @param itemName the name of the item
     */
    public void addItem(String itemName) {
        items.add(itemName);
        sort();
    }

    /**
     * Removes an item from the list.
     * @param pos the item's position (1..n)
     */
    public void removeItem(int pos) {
        items.remove(pos - 1);
    }

    /**
     * Saves the list to a text file with the name specified in the constructor.
     * If the file already exists, the list will be appended to the existing
     * contents.
     * @throws IOException throws an exception if the file is not found
     */
    public void saveList() throws IOException {
        FileWriter f = new FileWriter(this.filename, true);
        for (String item : items)
            f.write(item+"\n");
        f.close();
    }

    /**
     * Clears the list, including the text file.
     * @throws IOException throws an exception if the file is not found
     */
    public void clearList() throws IOException {
        for(int i = 0; i < this.items.size(); i++) {
            removeItem(i+1);
        }
        FileWriter f = new FileWriter(this.filename);
        f.flush();
        f.close();
    }

    /**
     * Displays all items in the list in one line.
     */
    public void displayCompactList() {
        System.out.println(items.toString());
    }

    /**
     * Displays all items in the list, one per line.
     */
    public void displayList() {
        for(int i = 0; i < items.size(); i++) {
            System.out.println(i+1 + ". " + items.get(i));
        }
    }

    /**
     * Returns the list's name
     * @return the list's name
     */
    public String getName() {
        return this.name;
    }

    private void sort() {
        items.sort(String.CASE_INSENSITIVE_ORDER);
    }

}
