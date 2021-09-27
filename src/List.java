import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creates a list.
 * @author LeddaZ
 */
public class List {

    // Environment variables
    private final String name;
    private final String filename;
    private ArrayList<String> items;
    private int saveCount;
    private final boolean isOrdered;

    /**
     * Constructor method. Initializes a new list with a name and a filename
     * (list name followed by .txt).
     * @param listName The list's name
     * @param isOrdered Specifies if the list will be alphabetically ordered or
     *                  not.
     */
    public List(String listName, boolean isOrdered) {
        this.name = listName;
        this.filename = listName + ".txt";
        this.items = new ArrayList<>();
        this.saveCount = 0;
        this.isOrdered = isOrdered;
    }

    /**
     * Copy constructor. Duplicates a list.
     * @param otherList The list to duplicate
     */
    public List(List otherList) {
        this.name = otherList.getName();
        this.filename = otherList.filename;
        this.items = otherList.items;
        this.saveCount = 0;
        this.isOrdered = otherList.isOrdered;
    }

    /**
     * Adds an item to the list and, if necessary, sorts the list alphabetically
     * to reorder the items.
     * @param itemName The name of the item
     */
    public void add(String itemName) {
        this.items.add(itemName);
        if(this.isOrdered)
            this.sort();
    }

    /**
     * Removes an item from the list.
     * @param pos The item's position (1...n)
     */
    public void remove(int pos) {
        this.items.remove(pos - 1);
    }

    /**
     * Saves the list to a text file with the name specified in the constructor.
     * If the file already exists, the list will be appended to the existing
     * contents. The list's title will also be saved if the list is being saved
     * for the first time.
     * @throws IOException Throws an exception if the file is not found
     */
    public void save() throws IOException {
        FileWriter fw = new FileWriter(this.filename, true);
        if(this.saveCount == 0)
            fw.write(this.getName() + "\n");
        for (String item : this.items)
            fw.write(item + "\n");
        fw.close();
        this.saveCount++;
    }

    /**
     * Saves the list to the specified absolute file path (must be an existing file).
     * If the file already exists, the list will be appended to the existing
     * contents.
     * @param filePath The absolute file path
     * @throws IOException Throws an exception if the file is not found
     */
    public void saveAs(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);
        fw.write(this.getName() + "\n");
        for (String item : this.items)
            fw.write(item + "\n");
        fw.close();
    }

    /**
     * Clears the list, including the text file.
     * @throws IOException Throws an exception if the file is not found
     */
    public void clear() throws IOException {
        for(int i = 0; i < this.items.size(); i++) {
            this.remove(i+1);
        }
        FileWriter f = new FileWriter(this.filename);
        f.flush();
        f.close();
        this.saveCount = 0;
    }

    /**
     * Reads a text file line by line and imports it into a list.
     * @param filePath The absolute file path
     * @throws FileNotFoundException Throws an exception if the file is not found
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
        System.out.println(this.getName() + ": " + this.items.toString());
    }

    /**
     * Displays all items in the list one per line.
     */
    public void display() {
        System.out.println(this.getName());
        for(int i = 0; i < this.items.size(); i++) {
            System.out.println(i+1 + ". " + this.items.get(i));
        }
    }

    /**
     * Returns the list's name
     * @return The list's name
     */
    public String getName() {
        return this.name;
    }

    private void sort() {
        this.items.sort(String.CASE_INSENSITIVE_ORDER);
    }

}
