package packages.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import packages.model.FileOperations;
import packages.model.InvoiceHeader;
import packages.model.InvoiceLine;
import packages.model.InvoiceTable;
import packages.view.SIGView;

public class SIGController {
    private static InvoiceTable invoiceTable = new InvoiceTable();
    private FileOperations fileOperations = new FileOperations();
    private SIGView sigView = new SIGView(this);

    private static InvoiceHeader oldInvoice;

 
    public InvoiceTable getInvoiceTable() {
        return invoiceTable;
    }

    public InvoiceHeader getOldInvoice() {
        return oldInvoice;
    }

    public void loadEmptyTables() {
        invoiceTable = new InvoiceTable();
    }

    public void loadInvoices() {
        invoiceTable = new InvoiceTable();
        try {
            invoiceTable.setInvoices(fileOperations.readFile());
        } catch (FileNotFoundException e) {
            sigView.showInvalidFileMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }

    public void startFrame() {
        sigView.startFrame();
    }

    public void oldInvoiceChanged(InvoiceHeader newInvoice) {
        oldInvoice = new InvoiceHeader(newInvoice);
    }

    public void addInvoiceItemActionPerformed(InvoiceHeader selectedInvoice) {
        invoiceTable.addItemToSpecificInvoice(selectedInvoice.getNo(), "", 0, 0);
    }

    public void cancelActionPerformed(int selectedInvoiceIndex) {
        invoiceTable.getInvoices().set(selectedInvoiceIndex, new InvoiceHeader(oldInvoice));
    }
    
    public void saveInvoiceActionPerformed(InvoiceHeader selectedInvoice, String customerName, String date) {
        selectedInvoice.setCustomer(customerName);
        selectedInvoice.setDate(date);
        selectedInvoice.calculateTotal();
    }

    public void deleteInvoiceActionPerformed(InvoiceHeader selectedInvoice) {
        invoiceTable.deleteInvoice(selectedInvoice.getNo());
    }

    
    public void createInvoiceActionPerformed() {
        ArrayList <InvoiceLine> invoiceItems = new ArrayList <> ();
        String date = java.time.LocalDate.now().toString();
        String[] dateSplitted = date.split("-");
        String formattedDate = dateSplitted[2] + "-" + dateSplitted[1] + "-" + dateSplitted[0];
        invoiceTable.createInvoice(-1, formattedDate, "", 0, invoiceItems);
    }

    public void saveFileActionPerformed() { 
        try {
            fileOperations.writeFile(invoiceTable.getInvoices());
        } catch (FileNotFoundException e) {
            sigView.showInvalidFileMessage();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void deleteInvoiceItemActionPerformed(int invoiceNo, int index) {
        invoiceTable.deleteItemFromSpecificInvoice(invoiceNo, index);
    }
}
