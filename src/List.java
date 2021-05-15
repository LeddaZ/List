import java.io.*;
import java.util.*;

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
     * Copy constructor. Duplicates a list.
     * @param otherList the list to duplicate
     */
    public List(List otherList) {
        this.name = otherList.name;
        this.filename = otherList.filename;
        this.items = otherList.items;
    }

    /**
     * Adds an item to the list and sorts the list alphabetically to reorder
     * the items.
     * @param itemName the name of the item
     */
    public void add(String itemName) {
        this.items.add(itemName);
        this.sort();
    }

    /**
     * Removes an item from the list.
     * @param pos the item's position (1..n)
     */
    public void remove(int pos) {
        this.items.remove(pos - 1);
    }

    /**
     * Saves the list to a text file with the name specified in the constructor.
     * If the file already exists, the list will be appended to the existing
     * contents.
     * @throws IOException throws an exception if the file is not found
     */
    public void save() throws IOException {
        FileWriter fw = new FileWriter(this.filename, true);
        fw.write(this.name + "\n");
        for (String item : this.items)
            fw.write(item + "\n");
        fw.close();
    }

    /**
     * Saves the list to the specified absolute file path (must be an existing file).
     * If the file already exists, the list will be appended to the existing
     * contents.
     * @param filePath the absolute file path
     * @throws IOException throws an exception if the file is not found
     */
    public void saveAs(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);
        fw.write(this.name + "\n");
        for (String item : this.items)
            fw.write(item + "\n");
        fw.close();
    }

    /**
     * Clears the list, including the text file.
     * @throws IOException throws an exception if the file is not found
     */
    public void clear() throws IOException {
        for(int i = 0; i < this.items.size(); i++) {
            this.remove(i+1);
        }
        FileWriter f = new FileWriter(this.filename);
        f.flush();
        f.close();
    }

    /**
     * Reads a text file line by line and imports it into a list.
     * @param filePath the absolute file path
     * @throws FileNotFoundException throws an exception if the file is not found
     */
    public void importFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextLine()) {
            this.add(scanner.nextLine());
        }
        scanner.close();
    }

    /**
     * Displays all items in the list in one line.
     */
    public void displayCompact() {
        System.out.println(this.items.toString());
    }

    /**
     * Displays all items in the list one per line.
     */
    public void display() {
        for(int i = 0; i < this.items.size(); i++) {
            System.out.println(i+1 + ". " + this.items.get(i));
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
        this.items.sort(String.CASE_INSENSITIVE_ORDER);
    }

}
