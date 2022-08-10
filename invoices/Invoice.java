package invoices;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class Invoice extends AbstractTableModel {
    public int no;
    public String date;
    public String customer;
    public int total;
    public ArrayList <InvoiceItem> invoiceItems;

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

    Invoice(int no, String date, String customer, int total, ArrayList <InvoiceItem> invoiceItems) {
        this.no = no;
        this.date = date;
        this.customer = customer;
        this.total = total;
        this.invoiceItems = invoiceItems;
    }

    public Invoice(Invoice inv) {
        this.no = inv.no;
        this.date = inv.date;
        this.customer = inv.customer;
        this.total = inv.total;
        this.invoiceItems = new ArrayList <InvoiceItem> (inv.invoiceItems);
    }

    public void addInvoiceItem(String itemName, int itemPrice, int count, int itemTotal) {
        InvoiceItem newInvoiceItem = new InvoiceItem(invoiceItems.size() + 1, itemName, itemPrice, count, itemTotal);
        invoiceItems.add(newInvoiceItem);
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
        InvoiceItem row = invoiceItems.get(rowIndex);
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
        InvoiceItem row = invoiceItems.get(rowIndex);
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