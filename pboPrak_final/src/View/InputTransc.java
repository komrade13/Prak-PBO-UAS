package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;

public class InputTransc extends JFrame {
    JLabel windowTitle = new JLabel("Input Transaction");

    public JTable table1; JScrollPane scrollPane1; DefaultTableModel dtm1;
    public Object[] columnName1 = {"ID", "Product Name", "Category", "Price", "Stock"};

    JLabel cartLabel = new JLabel("Your Shopping Cart");

    public JTable table2; JScrollPane scrollpane2; DefaultTableModel dtm2;
    public Object[] columnName2 = {"ID", "Product Name", "Quantity", "Price"};

    JLabel totPriceLabel = new JLabel("Total Price: ");
    public JLabel totPriceNumber = new JLabel();

    JLabel checkoutLabel = new JLabel("Proceed to Checkout");
    public JButton btnCheckout = new JButton("Checkout");
    
    public InputTransc() {
        setTitle("Input Transaction");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,700);
        getContentPane().setBackground(Color.WHITE);

        add(windowTitle); windowTitle.setBounds(20, 20, 400, 40);
        windowTitle.setFont(new Font("Arial", Font.BOLD, 24));

        dtm1 = new DefaultTableModel(columnName1, 0);
        table1 = new JTable(dtm1);
        scrollPane1 = new JScrollPane(table1);
        add(scrollPane1); scrollPane1.setBounds(20, 80, 650, 200);
        table1.getColumnModel().getColumn(0).setPreferredWidth(80);
        table1.getColumnModel().getColumn(1).setPreferredWidth(300);
        table1.getColumnModel().getColumn(2).setPreferredWidth(150);
        table1.getColumnModel().getColumn(3).setPreferredWidth(100);
        table1.getColumnModel().getColumn(4).setPreferredWidth(50);

        add(cartLabel); cartLabel.setBounds(20,315, 300, 30);
        cartLabel.setFont(new Font("Arial", Font.BOLD, 18));

        dtm2 = new DefaultTableModel(columnName2, 0);
        table2 = new JTable(dtm2);
        scrollPane1 = new JScrollPane(table2);
        add(scrollPane1); scrollPane1.setBounds(20, 350, 650, 200);
        table2.getColumnModel().getColumn(0).setPreferredWidth(80);
        table2.getColumnModel().getColumn(1).setPreferredWidth(400);
        table2.getColumnModel().getColumn(2).setPreferredWidth(100);
        table2.getColumnModel().getColumn(3).setPreferredWidth(150);

        add(totPriceLabel); totPriceLabel.setBounds(20, 560, 200, 30);
        totPriceLabel.setFont(new Font("Arial", Font.BOLD, 18));

        add(totPriceNumber); totPriceNumber.setBounds(20, 605, 200, 30);
        totPriceNumber.setFont(new Font("Arial", Font.BOLD, 14));

        add(checkoutLabel); checkoutLabel.setBounds(525, 560, 200, 30);
        checkoutLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        add(btnCheckout); btnCheckout.setBounds(565, 600, 100, 30);
        btnCheckout.setBackground(new Color(35,181,222)); 
        btnCheckout.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCheckout.setForeground(Color.WHITE);
    }
}
