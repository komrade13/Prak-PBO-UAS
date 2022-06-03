package View;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewHistory extends JFrame{
    JLabel windowTitle = new JLabel("Transaction History");

    public JTable table;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object[] columnName = {"Transaction ID", "Customer Name", "Total Payment"};

    public ViewHistory() {
        dtm = new DefaultTableModel(columnName, 0);
        table = new JTable(dtm);
        scrollPane = new JScrollPane(table);
        
        setTitle("Transaction History");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        pack();
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

        add(windowTitle); windowTitle.setBounds(20, 20, 400, 40);
        windowTitle.setFont(new Font("Arial", Font.BOLD, 24));

        add(scrollPane); scrollPane.setBounds(20, 80, 650, 350);
    }
}
