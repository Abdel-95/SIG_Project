package packages.model;


public class InvoiceLine {
    int no;
    String itemName;
    int itemPrice;
    int count;
    int itemTotal;

    public InvoiceLine(int no, String itemName, int itemPrice, int count, int itemTotal) {
        this.no = no;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
        this.itemTotal = itemTotal;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getCount() {
        return count;
    }
}