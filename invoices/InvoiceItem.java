package invoices;


public class InvoiceItem {
    public int no;
    public String itemName;
    public int itemPrice;
    public int count;
    int itemTotal;

    public InvoiceItem(int no, String itemName, int itemPrice, int count, int itemTotal) {
        this.no = no;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
        this.itemTotal = itemTotal;
    }
}