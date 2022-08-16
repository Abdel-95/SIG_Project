package packages.view;

import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import static javax.swing.JOptionPane.showMessageDialog;

import java.io.Console;

import packages.controller.SIGController;
import packages.model.InvoiceHeader;

public class SIGView extends JFrame {
    // Variables declaration - do not modify                     
    private static javax.swing.JButton loadFileButton;
    private static javax.swing.JButton saveFileButton;
    private static javax.swing.JButton createInvoiceButton;
    private static javax.swing.JButton deleteInvoiceButton;
    private static javax.swing.JButton saveInvoiceButton;
    private static javax.swing.JButton cancelButton;
    private static javax.swing.JButton addInvoiceItemButton;
    private static javax.swing.JButton deleteInvoiceItemButton;
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

    private SIGController sigController;

    public SIGView(SIGController sigController) {
        this.sigController = sigController;
    }
    
    public void startFrame() {
        JFrame frame = new JFrame("SIG");
        initComponents(frame);
        frame.pack();
        frame.setVisible(true);
    }

    private void initComponents(JFrame frame) {
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
        deleteInvoiceItemButton = new javax.swing.JButton();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jTable1.setModel(sigController.getInvoiceTable());
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new InvoiceHeader());
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setViewportView(jTable2);
        // sigController.oldInvoiceChanged(sigController.getInvoiceTable().getInvoices().get(0));

        jTable1.setRowSelectionAllowed(true);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel model = jTable1.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                selectedInvoiceRowChanged();
            }
        });;

        jTable2.setRowSelectionAllowed(true);
        

        invoicesTableLabel.setText("Invoices Table:");

        invoiceNumberTitleLabel.setText("Invoice Number:");

        // InvoiceHeader selectedInvoice = sigController.getInvoiceTable().getInvoices().get(0);
        // jTable2.setModel(selectedInvoice);
        // invoiceNoLabel.setText(Integer.toString(selectedInvoice.getNo()));
        // invoiceTotalLabel.setText(Integer.toString(selectedInvoice.getTotal()));
        // invoiceCustomerNameTextField.setText(selectedInvoice.getCustomer());
        // invoiceDateTextField.setText(selectedInvoice.getDate());
        // jTable1.setRowSelectionInterval(selectedInvoice.getNo() - 1, selectedInvoice.getNo() - 1);


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

        deleteInvoiceItemButton.setText("Delete Invoice Item");
        deleteInvoiceItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvoiceItemButtonActionPerformed();
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
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(createInvoiceButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteInvoiceButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(saveFileButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(invoiceNumberTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(invoiceNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(invoiceTotalTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(invoiceTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(customerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(invoiceCustomerNameTextField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(invoiceDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(invoiceDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(59, 59, 59))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(invoiceItemsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(saveInvoiceButton)
                        .addGap(28, 28, 28)
                        .addComponent(cancelButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addInvoiceItemButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteInvoiceItemButton)
                        .addGap(87, 87, 87))))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addInvoiceItemButton)
                    .addComponent(deleteInvoiceItemButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createInvoiceButton)
                    .addComponent(deleteInvoiceButton)
                    .addComponent(saveInvoiceButton)
                    .addComponent(cancelButton))
                .addGap(37, 37, 37))
        );


    }

    protected void deleteInvoiceItemButtonActionPerformed() {
        if(jTable2.getSelectedRow() != -1) {
            InvoiceHeader selectedInvoice = sigController.getInvoiceTable().getInvoices().get(jTable1.getSelectedRow() != -1 ? jTable1.getSelectedRow() : 0);
            int index = jTable2.getSelectedRow();
            sigController.deleteInvoiceItemActionPerformed(selectedInvoice.getNo(), index);
            jTable2.setModel(selectedInvoice);
            ((AbstractTableModel) jTable2.getModel()).fireTableDataChanged();
        }
    }

    protected void selectedInvoiceRowChanged() {
        int index = jTable1.getSelectedRow() != -1 ? jTable1.getSelectedRow() : 0;
        if (index <= sigController.getInvoiceTable().getInvoices().size() - 1) {
            InvoiceHeader selectedInvoice = sigController.getInvoiceTable().getInvoices().get(index);
            jTable2.setModel(selectedInvoice);
            ((AbstractTableModel) jTable2.getModel()).fireTableDataChanged();
            invoiceNoLabel.setText(Integer.toString(selectedInvoice.getNo()));
            invoiceTotalLabel.setText(Integer.toString(selectedInvoice.getTotal()));
            invoiceCustomerNameTextField.setText(selectedInvoice.getCustomer());
            invoiceDateTextField.setText(selectedInvoice.getDate());
            sigController.oldInvoiceChanged(selectedInvoice);
        }
    }

    protected void addInvoiceItemButtonActionPerformed() {
        if(sigController.getInvoiceTable().getInvoices().size() == 0) return;
        InvoiceHeader selectedInvoice = sigController.getInvoiceTable().getInvoices().get(jTable1.getSelectedRow() != -1 ? jTable1.getSelectedRow() : 0);
        sigController.addInvoiceItemActionPerformed(selectedInvoice);
        jTable2.setModel(selectedInvoice);
        ((AbstractTableModel) jTable2.getModel()).fireTableDataChanged();
    }

    protected void cancelButtonActionPerformed() {
        if(sigController.getInvoiceTable().getInvoices().size() == 0) return;
        sigController.cancelActionPerformed(jTable1.getSelectedRow() != -1 ? jTable1.getSelectedRow() : 0);
        jTable2.setModel(sigController.getInvoiceTable().getInvoices().get(jTable1.getSelectedRow() != -1 ? jTable1.getSelectedRow() : 0));
        ((AbstractTableModel) jTable2.getModel()).fireTableDataChanged();
        invoiceNoLabel.setText(Integer.toString(sigController.getOldInvoice().getNo()));
        invoiceTotalLabel.setText(Integer.toString(sigController.getOldInvoice().getTotal()));
        invoiceCustomerNameTextField.setText(sigController.getOldInvoice().getCustomer());
        invoiceDateTextField.setText(sigController.getOldInvoice().getDate());
    }

    protected void saveInvoiceButtonActionPerformed() {
        if(sigController.getInvoiceTable().getInvoices().size() == 0) return;
        int index = jTable1.getSelectedRow() != -1 ? jTable1.getSelectedRow() : 0;
        if (!invoiceDateTextField.getText().matches("([0-9]{2})-([0-9]{2})-([0-9]{4})")) {
            showMessageDialog(null, "Date must be in the format: dd-mm-yyyy.");
            return;
        }
        try {
            jTable2.getCellEditor().stopCellEditing();
        } catch (Exception e) {}

        InvoiceHeader selectedInvoice = sigController.getInvoiceTable().getInvoices().get(index);
        sigController.saveInvoiceActionPerformed(selectedInvoice, invoiceCustomerNameTextField.getText(), invoiceDateTextField.getText());
        
        invoiceTotalLabel.setText(Integer.toString(selectedInvoice.getTotal()));
        jTable1.setModel(sigController.getInvoiceTable());
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
        jTable1.setRowSelectionInterval(index, index);
        sigController.oldInvoiceChanged(selectedInvoice);
    }

    protected void deleteInvoiceButtonActionPerformed() {
        if (sigController.getInvoiceTable().getInvoices().size() == 1) {
            showMessageDialog(null, "You can't delete this invoice. The invoices table must contain at least one invoice.");
            return;
        }
        int indexToDelete = jTable1.getSelectedRow() != -1 ? jTable1.getSelectedRow() : 0;
        if (indexToDelete <= sigController.getInvoiceTable().getInvoices().size() - 1) {
            InvoiceHeader selectedInvoice = sigController.getInvoiceTable().getInvoices().get(indexToDelete);
            sigController.deleteInvoiceActionPerformed(selectedInvoice);
            jTable1.setModel(sigController.getInvoiceTable());
            ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
            int indexToSelect = indexToDelete> 0 ? indexToDelete - 1 : 0;
            if (indexToSelect <= sigController.getInvoiceTable().getInvoices().size() - 1) {
                jTable1.setRowSelectionInterval(indexToSelect, indexToSelect);
            }
        }

    }

    protected void createInvoiceButtonActionPerformed() {
        sigController.createInvoiceActionPerformed();
        jTable1.setModel(sigController.getInvoiceTable());
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
        // selectedInvoiceRowChanged will be changed. 
        jTable1.setRowSelectionInterval(sigController.getInvoiceTable().getInvoices().size() - 1, sigController.getInvoiceTable().getInvoices().size() - 1);
    }

    protected void saveFileButtonActionPerformed() {
        cancelButtonActionPerformed();
        sigController.saveFileActionPerformed();
    }

    protected void loadFileButtonActionPerformed() {
        try {
            sigController.loadInvoices();
            jTable1.setModel(sigController.getInvoiceTable());
            ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
            jTable1.setRowSelectionInterval(0, 0);
            selectedInvoiceRowChanged();
        } catch(Exception e) {}
        
    } 

    public void showInvalidFileMessage() {
        showMessageDialog(null, "File is not found");
    }

    public void showSpecificMessage(String msg) {
        showMessageDialog(null, msg.startsWith("Please") ? msg : "Wrong file format");
    }
}
