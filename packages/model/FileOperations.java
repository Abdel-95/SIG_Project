package packages.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FileOperations {
    public ArrayList<InvoiceHeader> readFile(boolean test) throws Exception {
        String line = "";
        ArrayList<InvoiceHeader> invoices =  new ArrayList<>();
        try {
            String choosenFile;
            if(test == true) {
                choosenFile = "i_o_files/InvoiceHeader.csv";
            } else {
                choosenFile = chooseTheFile("InvoiceHeader.csv"); 
            }
            if(choosenFile == null) return new ArrayList<InvoiceHeader>();
            BufferedReader br = new BufferedReader(new FileReader(choosenFile));
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
            String choosenFile;
            if(test == true) {
                choosenFile = "i_o_files/InvoiceLine.csv";
            } else {
                choosenFile = chooseTheFile("InvoiceLine.csv"); 
            }
            if(choosenFile == null) return new ArrayList<InvoiceHeader>();
            BufferedReader br = new BufferedReader(new FileReader((test == true ? "i_o_files/InvoiceLine.csv" : choosenFile)));
            while ((line = br.readLine()) != null) {
                String[] invoiceItem = line.split(",");
                InvoiceHeader invoice = invoices.stream().filter(item -> item.no == Integer.parseInt(invoiceItem[0])).findFirst().orElse(null);
                if (invoice != null) {
                    invoice.addInvoiceItem(Integer.parseInt(invoiceItem[0]), invoiceItem[1], Integer.parseInt(invoiceItem[2]), Integer.parseInt(invoiceItem[3]), Integer.parseInt(invoiceItem[2]) * Integer.parseInt(invoiceItem[3]));
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

    private String chooseTheFile(String name) throws Exception {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Choose the " + name + " file." , "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            if(!chooser.getSelectedFile().getName().equals(name))
                {
                    throw(new Exception("Please Choose the file with name: " + name));
                }
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    public void writeFile(ArrayList<InvoiceHeader> invoices) throws Exception{
        try {
            String choosenFile1 = chooseTheFile("InvoiceHeader.csv");
            if(choosenFile1 == null) return;
            String choosenFile2 = chooseTheFile("InvoiceLine.csv");
            if(choosenFile2 == null) return;
            FileWriter fw = new FileWriter(choosenFile1);
            FileWriter fw1 = new FileWriter(choosenFile2);
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
