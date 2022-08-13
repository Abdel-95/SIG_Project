import java.io.IOException;
import java.util.ArrayList;

import packages.controller.SIGController;
import packages.model.FileOperations;
import packages.model.InvoiceHeader;
import packages.model.InvoiceLine;

class SIGMain {
    public static void main(String args[]) {
        SIGController sigController = new SIGController();
        // Load the invoices from the file and store it in the invoice table model.
        sigController.loadInvoices();
        // Create the frame with its components using the view and initialize it with the invoice table data stored.
        sigController.startFrame();
        // The required test function.
        test();
    }

    public static void test() {
        FileOperations fo = new FileOperations();
        try {
            ArrayList<InvoiceHeader> invoices = fo.readFile();
            for(int i=0; i < invoices.size(); i++) {
                InvoiceHeader invoice = invoices.get(i);
                System.out.println(invoice.getNo());
                System.out.println("{");
                String[] date = invoice.getDate().split("-");
                System.out.println(date[0] + "/" + date[1] + "/" + date[2] + ", " + invoice.getCustomer());
                for(int j = 0; j < invoice.getInvoiceItems().size(); j++) {
                    InvoiceLine invoiceItem = invoice.getInvoiceItems().get(j);
                    System.out.println(invoiceItem.getItemName() + ", " + invoiceItem.getItemPrice() + ", " + invoiceItem.getCount());
                }
                System.out.println("}");
                System.out.println("");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
