package packages.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class InvoiceTable extends AbstractTableModel {
    ArrayList <InvoiceHeader> invoices;

    private final String[] columnNames = new String[] {
        "No.",
        "Date",
        "Customer",
        "Total"
    };
    private final Class[] columnClass = new Class[] {
        Integer.class, String.class, String.class, Integer.class
    };

    public InvoiceTable() {
        invoices = new ArrayList <InvoiceHeader> ();
    }

    public InvoiceTable(InvoiceTable invoiceTable) {
        this.invoices = new ArrayList <InvoiceHeader> ();
        for (int i = 0; i < invoiceTable.invoices.size(); i++) {
            this.invoices.add(new InvoiceHeader(invoiceTable.invoices.get(i)));
        }
    }

    public void setInvoices(ArrayList<InvoiceHeader> invoices) {
        this.invoices = new ArrayList<>(invoices);
    }

    public ArrayList<InvoiceHeader> getInvoices() {
        return invoices;
    }

    public void createInvoice(int no, String date, String customer, int total, ArrayList <InvoiceLine> arrayList) {
        int invoiceNo = no != -1 ? no : invoices.get(invoices.size() - 1).no + 1;
        InvoiceHeader newInvoice = new InvoiceHeader(invoiceNo, date, customer, total, arrayList);
        invoices.add(newInvoice);
    }

    public void addItemToSpecificInvoice(int invoiceNo, String itemName, int itemPrice, int count) {
        InvoiceHeader invoice = invoices.stream().filter(item -> item.no == invoiceNo).findFirst().orElse(null);
        if (invoice != null) {
            invoice.addInvoiceItem(itemName, itemPrice, count, itemPrice * count);
            invoice.total += (itemPrice * count);
        }

    }

    public void updateInvoice(int no, String date, String customer, int total, ArrayList <InvoiceLine> invoiceItems) {
        InvoiceHeader invoice = invoices.stream().filter(item -> item.no == no).findFirst().orElse(null);
        if (invoice != null) {
            int index = invoices.indexOf(invoice);
            InvoiceHeader newInvoice = new InvoiceHeader(no, date, customer, total, invoiceItems);
            invoices.set(index, newInvoice);
        }
    }

    public void deleteInvoice(int no) {
        InvoiceHeader invoice = invoices.stream().filter(item -> item.no == no).findFirst().orElse(null);
        if (invoice != null) {
            invoices.remove(invoice);
        }
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
        return invoices.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader row = invoices.get(rowIndex);
        if (0 == columnIndex) {
            return row.no;
        } else if (1 == columnIndex) {
            return row.date;
        } else if (2 == columnIndex) {
            return row.customer;
        } else if (3 == columnIndex) {
            return row.total;
        }
        return null;
    }
}