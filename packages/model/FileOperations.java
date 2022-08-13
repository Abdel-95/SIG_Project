package packages.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileOperations {
    public ArrayList<InvoiceHeader> readFile() throws IOException {
        ArrayList<InvoiceHeader> invoices =  new ArrayList<>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("i_o_files/InvoiceHeader.csv"));
            while ((line = br.readLine()) != null) {
                String[] invoice = line.split(",");
                InvoiceHeader newInvoice = new InvoiceHeader(Integer.parseInt(invoice[0]), invoice[1], invoice[2], 0, new ArrayList <InvoiceLine> ());
                invoices.add(newInvoice);
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw(e);
        } 
        catch (IOException e) {
            throw(e);
        }
        line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("i_o_files/InvoiceLine.csv"));
            while ((line = br.readLine()) != null) {
                String[] invoiceItem = line.split(",");
                InvoiceHeader invoice = invoices.stream().filter(item -> item.no == Integer.parseInt(invoiceItem[0])).findFirst().orElse(null);
                if (invoice != null) {
                    invoice.addInvoiceItem(invoiceItem[1], Integer.parseInt(invoiceItem[2]), Integer.parseInt(invoiceItem[3]), Integer.parseInt(invoiceItem[2]) * Integer.parseInt(invoiceItem[3]));
                    invoice.total += (Integer.parseInt(invoiceItem[2]) * Integer.parseInt(invoiceItem[3]));
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw(e);
        } 
        catch (IOException e) {
            throw(e);
        }
        return invoices;
    }

    public void writeFile(ArrayList<InvoiceHeader> invoices) throws IOException{
        try {
            FileWriter fw = new FileWriter("i_o_files/InvoiceHeader.csv");
            FileWriter fw1 = new FileWriter("i_o_files/InvoiceLine.csv");
            for (int i = 0; i < invoices.size(); i++) {
                InvoiceHeader invoice = invoices.get(i);
                fw.write(invoice.no + "," + invoice.date + "," + invoice.customer + "\n");
                for (int j = 0; j < invoice.invoiceItems.size(); j++) {
                    InvoiceLine invoiceItem = invoice.invoiceItems.get(j);
                    fw1.write(invoice.no + "," + invoiceItem.itemName + "," + invoiceItem.itemPrice + "," + invoiceItem.count + "\n");
                }
            }
            fw.close();
            fw1.close();
        } catch (FileNotFoundException e) {
            throw(e);
        } catch (IOException e1) {
            throw(e1);
        }   
    }
}
