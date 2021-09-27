package List;

public class OrderedList extends List {

    /**
     * Constructor method. Initializes a new ordered list with a name and+
     * a filename (list name followed by .txt).
     * @param listName The list's name
     */
    public OrderedList(String listName) {
        super(listName);
    }

    /**
     * Adds an item to the list and sorts it alphabetically to reorder
     * the items.
     * @param itemName The name of the item
     */
    @Override
    public void add(String itemName) {
        super.add(itemName);
        sort();
    }

    /**
     * Sorts items in the list alphabetically.
     */
    public void sort() {
        this.getItems().sort(String.CASE_INSENSITIVE_ORDER);
    }

}
