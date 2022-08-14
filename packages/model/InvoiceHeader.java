package packages.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class InvoiceHeader extends AbstractTableModel {
    int no;
    String date;
    String customer;
    int total;
    ArrayList <InvoiceLine> invoiceItems;


    private final String[] columnNames = new String[] {
        "No.",
        "Item Name",
        "Item Price",
        "Count",
        "Item Total"
    };
    private final Class[] columnClass = new Class[] {
        Integer.class, String.class, Integer.class, Integer.class, Integer.class
    };

    InvoiceHeader(int no, String date, String customer, int total, ArrayList <InvoiceLine> invoiceItems) {
        this.no = no;
        this.date = date;
        this.customer = customer;
        this.total = total;
        this.invoiceItems = invoiceItems;
    }

    public InvoiceHeader(InvoiceHeader inv) {
        this.no = inv.no;
        this.date = inv.date;
        this.customer = inv.customer;
        this.total = inv.total;
        this.invoiceItems = new ArrayList <InvoiceLine> (inv.invoiceItems);
    }

    public InvoiceHeader() {
        invoiceItems = new ArrayList<>();
    }

    public int getNo() {
        return no;
    }

    public String getDate() {
        return date;
    }

    public String getCustomer() {
        return customer;
    }

    public int getTotal() {
        return total;
    }

    public ArrayList<InvoiceLine> getInvoiceItems() {
        return invoiceItems;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void addInvoiceItem(int invNo,String itemName, int itemPrice, int count, int itemTotal) {
        InvoiceLine newInvoiceItem = new InvoiceLine(invNo, itemName, itemPrice, count, itemTotal);
        invoiceItems.add(newInvoiceItem);
    }


    public void deleteInvoiceItem(int index) {
        InvoiceLine invoiceItem = invoiceItems.get(index);
        invoiceItems.remove(invoiceItem);
        total -= (invoiceItem.itemPrice * invoiceItem.count);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class <?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public int getRowCount() {
        return invoiceItems.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine row = invoiceItems.get(rowIndex);
        if (0 == columnIndex) {
            return row.no;
        } else if (1 == columnIndex) {
            return row.itemName;
        } else if (2 == columnIndex) {
            return row.itemPrice;
        } else if (3 == columnIndex) {
            return row.count;
        } else if (4 == columnIndex) {
            return row.itemTotal;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        InvoiceLine row = invoiceItems.get(rowIndex);
        if (0 == columnIndex) {
            row.no = ((Integer) aValue);
        } else if (1 == columnIndex) {
            row.itemName = ((String) aValue);
        } else if (2 == columnIndex) {
            row.itemPrice = ((Integer) aValue);
        } else if (3 == columnIndex) {
            row.count = ((Integer) aValue);
        } else if (4 == columnIndex) {
            row.itemTotal = ((Integer) aValue);
        }
    }

    public void calculateTotal() {
        total = 0;
        for (int i = 0; i < invoiceItems.size(); i++) {
            total += invoiceItems.get(i).count * invoiceItems.get(i).itemPrice;
        }
    }
}