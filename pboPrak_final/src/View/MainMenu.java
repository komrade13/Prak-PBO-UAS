package View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class MainMenu extends JFrame {
    // JFrame window = new JFrame();

    JLabel windowTitle = new JLabel("Cashierizer");
    JLabel windowSubTitle = new JLabel("Transaction and Database Manager");

    public JButton btnTransc = new JButton("Input Transaction");
    public JButton btnView = new JButton("View Database");
    public JButton btnInput = new JButton("Input Data");
    public JButton btnHistory = new JButton("Transaction History");

    public MainMenu() {
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

        add(windowTitle); windowTitle.setBounds(120, 80, 400, 40); 
        windowTitle.setFont(new Font("Sans-Serif", Font.BOLD, 48));
        
        add(windowSubTitle); windowSubTitle.setBounds(150, 120, 400, 40);

        add(btnTransc); btnTransc.setBounds(170, 180, 160, 30); 
        btnTransc.setBackground(new Color(255,255,255)); 
        add(btnView); btnView.setBounds(170, 220, 160, 30);
        btnView.setBackground(new Color(255,255,255));
        add(btnInput); btnInput.setBounds(170, 260, 160, 30);
        btnInput.setBackground(new Color(255,255,255));
        add(btnHistory); btnHistory.setBounds(170, 300, 160, 30); 
        btnHistory.setBackground(new Color(255,255,255)); 
    }
}
