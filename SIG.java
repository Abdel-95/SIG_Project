import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;

import invoices.*;

class SIG {
    // Variables declaration - do not modify                     
    private static javax.swing.JButton loadFileButton;
    private static javax.swing.JButton saveFileButton;
    private static javax.swing.JButton createInvoiceButton;
    private static javax.swing.JButton deleteInvoiceButton;
    private static javax.swing.JButton saveInvoiceButton;
    private static javax.swing.JButton cancelButton;
    private static javax.swing.JButton addInvoiceItemButton;
    private static javax.swing.JLabel invoicesTableLabel;
    private static javax.swing.JLabel invoiceNumberTitleLabel;
    private static javax.swing.JLabel invoiceNoLabel;
    private static javax.swing.JLabel invoiceDateLabel;
    private static javax.swing.JLabel customerNameLabel;
    private static javax.swing.JLabel invoiceItemsLabel;
    private static javax.swing.JLabel invoiceTotalTitleLabel;
    private static javax.swing.JLabel invoiceTotalLabel;
    private static javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable jTable1;
    private static javax.swing.JTable jTable2;
    private static javax.swing.JTextField invoiceDateTextField;
    private static javax.swing.JTextField invoiceCustomerNameTextField;
    // End of variables declaration

    private static Invoice oldInvoice;
    private static InvoiceTable invoiceTable = new InvoiceTable();


    public static void main(String args[]) {
        loadInvoices();
        loadInvoicesItems();

        JFrame frame = new JFrame("SIG");
        initComponents(frame);
        frame.pack();
        frame.setVisible(true);
    }

    private static void initComponents(JFrame frame) {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        invoicesTableLabel = new javax.swing.JLabel();
        invoiceNumberTitleLabel = new javax.swing.JLabel();
        invoiceNoLabel = new javax.swing.JLabel();
        invoiceDateTextField = new javax.swing.JTextField();
        invoiceDateLabel = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        invoiceCustomerNameTextField = new javax.swing.JTextField();
        invoiceItemsLabel = new javax.swing.JLabel();
        invoiceTotalTitleLabel = new javax.swing.JLabel();
        invoiceTotalLabel = new javax.swing.JLabel();
        loadFileButton = new javax.swing.JButton();
        saveFileButton = new javax.swing.JButton();
        createInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton = new javax.swing.JButton();
        saveInvoiceButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        addInvoiceItemButton = new javax.swing.JButton();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jTable1.setModel(invoiceTable);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(invoiceTable.invoices.get(0));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setViewportView(jTable2);
        oldInvoice = new Invoice(invoiceTable.invoices.get(0));

        jTable1.setRowSelectionAllowed(true);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel model = jTable1.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                selectedInvoiceRowChanged();
            }
        });;

        invoicesTableLabel.setText("Invoices Table:");

        invoiceNumberTitleLabel.setText("Invoice Number:");

        Invoice selectedInvoice = invoiceTable.invoices.get(0);
        jTable2.setModel(selectedInvoice);
        invoiceNoLabel.setText(Integer.toString(selectedInvoice.no));
        invoiceTotalLabel.setText(Integer.toString(selectedInvoice.total));
        invoiceCustomerNameTextField.setText(selectedInvoice.customer);
        invoiceDateTextField.setText(selectedInvoice.date);
        jTable1.setRowSelectionInterval(selectedInvoice.no - 1, selectedInvoice.no - 1);


        invoiceDateLabel.setText("Invoice Date:");

        customerNameLabel.setText("Customer Name:");



        invoiceItemsLabel.setText("Invoice Items:");

        invoiceTotalTitleLabel.setText("Invoice Total:");


        loadFileButton.setText("Load File");
        loadFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileButtonActionPerformed();
            }
        });

        saveFileButton.setText("Save File");
        saveFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileButtonActionPerformed();
            }
        });

        createInvoiceButton.setText("Create New Invoice");
        createInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvoiceButtonActionPerformed();
            }
        });

        deleteInvoiceButton.setText("Delete Invoice");
        deleteInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvoiceButtonActionPerformed();
            }
        });

        saveInvoiceButton.setText("Save");
        saveInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveInvoiceButtonActionPerformed();
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed();
            }
        });

        addInvoiceItemButton.setText("Add Invoice Item");
        addInvoiceItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInvoiceItemButtonActionPerformed();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadFileButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoicesTableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createInvoiceButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteInvoiceButton))))
                    .addComponent(saveFileButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(invoiceNumberTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(invoiceNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(invoiceItemsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(invoiceTotalTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(invoiceTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(customerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(invoiceCustomerNameTextField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(invoiceDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(invoiceDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(59, 59, 59))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(saveInvoiceButton)
                        .addGap(28, 28, 28)
                        .addComponent(cancelButton)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addInvoiceItemButton)
                .addGap(179, 179, 179))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceNumberTitleLabel)
                    .addComponent(invoiceNoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadFileButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceDateLabel)
                    .addComponent(invoiceDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveFileButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(invoicesTableLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerNameLabel)
                            .addComponent(invoiceCustomerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceTotalTitleLabel)
                            .addComponent(invoiceTotalLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(invoiceItemsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addInvoiceItemButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createInvoiceButton)
                    .addComponent(deleteInvoiceButton)
                    .addComponent(saveInvoiceButton)
                    .addComponent(cancelButton))
                .addGap(37, 37, 37))
        );


    }

    protected static void selectedInvoiceRowChanged() {
        int index = jTable1.getSelectedRow() != -1 ? jTable1.getSelectedRow() : 0;
        if (index <= invoiceTable.invoices.size() - 1) {
            Invoice selectedInvoice = invoiceTable.invoices.get(index);
            jTable2.setModel(selectedInvoice);
            ((AbstractTableModel) jTable2.getModel()).fireTableDataChanged();
            invoiceNoLabel.setText(Integer.toString(selectedInvoice.no));
            invoiceTotalLabel.setText(Integer.toString(selectedInvoice.total));
            invoiceCustomerNameTextField.setText(selectedInvoice.customer);
            invoiceDateTextField.setText(selectedInvoice.date);
            oldInvoice = new Invoice(selectedInvoice);
        }
    }

    protected static void addInvoiceItemButtonActionPerformed() {
        Invoice selectedInvoice = invoiceTable.invoices.get(jTable1.getSelectedRow() != -1 ? jTable1.getSelectedRow() : 0);
        invoiceTable.addItemToSpecificInvoice(selectedInvoice.no, "", 0, 0);
        jTable2.setModel(selectedInvoice);
        ((AbstractTableModel) jTable2.getModel()).fireTableDataChanged();
    }

    protected static void cancelButtonActionPerformed() {
        invoiceTable.invoices.set(jTable1.getSelectedRow() != -1 ? jTable1.getSelectedRow() : 0, new Invoice(oldInvoice));
        jTable2.setModel(invoiceTable.invoices.get(jTable1.getSelectedRow() != -1 ? jTable1.getSelectedRow() : 0));
        ((AbstractTableModel) jTable2.getModel()).fireTableDataChanged();
        invoiceNoLabel.setText(Integer.toString(oldInvoice.no));
        invoiceTotalLabel.setText(Integer.toString(oldInvoice.total));
        invoiceCustomerNameTextField.setText(oldInvoice.customer);
        invoiceDateTextField.setText(oldInvoice.date);
    }

    protected static void saveInvoiceButtonActionPerformed() {
        int index = jTable1.getSelectedRow() != -1 ? jTable1.getSelectedRow() : 0;
        if (!invoiceDateTextField.getText().matches("([0-9]{2})-([0-9]{2})-([0-9]{4})")) {
            showMessageDialog(null, "Date must be in the format: dd-mm-yyyy.");
            return;
        }
        try {
            jTable2.getCellEditor().stopCellEditing();
        } catch (Exception e) {}

        Invoice selectedInvoice = invoiceTable.invoices.get(index);
        selectedInvoice.customer = invoiceCustomerNameTextField.getText();
        selectedInvoice.date = invoiceDateTextField.getText();
        selectedInvoice.calculateTotal();
        invoiceTotalLabel.setText(Integer.toString(selectedInvoice.total));
        jTable1.setModel(invoiceTable);
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
        jTable1.setRowSelectionInterval(index, index);
        oldInvoice = new Invoice(selectedInvoice);
    }

    protected static void deleteInvoiceButtonActionPerformed() {
        if (invoiceTable.invoices.size() == 1) {
            showMessageDialog(null, "You can't delete this invoice. The invoices table must contain at least one invoice.");
            return;
        }
        int indexToDelete = jTable1.getSelectedRow() != -1 ? jTable1.getSelectedRow() : 0;
        if (indexToDelete <= invoiceTable.invoices.size() - 1) {
            Invoice selectedInvoice = invoiceTable.invoices.get(indexToDelete);
            invoiceTable.deleteInvoice(selectedInvoice.no);
            jTable1.setModel(invoiceTable);
            ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
            int indexToSelect = indexToDelete> 0 ? indexToDelete - 1 : 0;
            if (indexToSelect <= invoiceTable.invoices.size() - 1) {
                jTable1.setRowSelectionInterval(indexToSelect, indexToSelect);
            }
        }

    }

    protected static void createInvoiceButtonActionPerformed() {
        ArrayList <InvoiceItem> invoiceItems = new ArrayList <> ();
        invoiceItems.add(new InvoiceItem(1, "", 0, 0, 0));
        String date = java.time.LocalDate.now().toString();
        String[] dateSplitted = date.split("-");
        String formattedDate = dateSplitted[2] + "-" + dateSplitted[1] + "-" + dateSplitted[0];
        invoiceTable.createInvoice(-1, formattedDate, "", 0, invoiceItems);
        jTable1.setModel(invoiceTable);
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
        // selectedInvoiceRowChanged will be changed. 
        jTable1.setRowSelectionInterval(invoiceTable.invoices.size() - 1, invoiceTable.invoices.size() - 1);
    }

    protected static void saveFileButtonActionPerformed() {
        cancelButtonActionPerformed();
        try {
            FileWriter fw = new FileWriter("i_o_files/InvoiceHeader.csv");
            FileWriter fw1 = new FileWriter("i_o_files/InvoiceLine.csv");
            for (int i = 0; i < invoiceTable.invoices.size(); i++) {
                Invoice invoice = invoiceTable.invoices.get(i);
                fw.write(invoice.no + "," + invoice.date + "," + invoice.customer + "\n");
                for (int j = 0; j < invoice.invoiceItems.size(); j++) {
                    InvoiceItem invoiceItem = invoice.invoiceItems.get(j);
                    fw1.write(invoice.no + "," + invoiceItem.itemName + "," + invoiceItem.itemPrice + "," + invoiceItem.count + "\n");
                }
            }
            fw.close();
            fw1.close();
        } catch (FileNotFoundException e) {
            showMessageDialog(null, "File is not found");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    protected static void loadFileButtonActionPerformed() {
        invoiceTable = new InvoiceTable();
        loadInvoices();
        loadInvoicesItems();
        jTable1.setModel(invoiceTable);
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
        jTable1.setRowSelectionInterval(0, 0);
        selectedInvoiceRowChanged();
    }

    static void loadInvoices() {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("i_o_files/InvoiceHeader.csv"));
            while ((line = br.readLine()) != null) {
                String[] invoice = line.split(",");
                invoiceTable.createInvoice(Integer.parseInt(invoice[0]), invoice[1], invoice[2], 0, new ArrayList <InvoiceItem> ());
            }
            br.close();
        } catch (FileNotFoundException e) {
            showMessageDialog(null, "File is not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void loadInvoicesItems() {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("i_o_files/InvoiceLine.csv"));
            while ((line = br.readLine()) != null) {
                String[] invoiceItem = line.split(",");
                invoiceTable.addItemToSpecificInvoice(Integer.parseInt(invoiceItem[0]), invoiceItem[1], Integer.parseInt(invoiceItem[2]), Integer.parseInt(invoiceItem[3]));
            }
            br.close();
        } catch (FileNotFoundException e) {
            showMessageDialog(null, "File is not found");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}