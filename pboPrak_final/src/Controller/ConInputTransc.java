package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import View.InputTransc; import Model.ModelMain;

public class ConInputTransc {
    InputTransc inputTransc;
    ModelMain model;
    String selectedProductId;
    String cartList[][];
    int currentIndex = 0;
    int totalPayment = 0;

    public ConInputTransc(InputTransc inputTransc, ModelMain model) {
        this.inputTransc = inputTransc;
        this.model = model;
        cartList = new String[10][4];

        String dataProduct[][] = model.readProduct(); 
        inputTransc.table1.setModel((new JTable(dataProduct, inputTransc.columnName1)).getModel());

        inputTransc.table1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int row = inputTransc.table1.getSelectedRow();

                String selectedData = inputTransc.table1.getValueAt(row,0).toString();
                String selectedProduct = inputTransc.table1.getValueAt(row,1).toString();
                String selectedPrice = inputTransc.table1.getValueAt(row,3).toString();
                setSelectedProductId(selectedData);
                String orderQuant = inputQuantity();
                int totpay = Integer.parseInt(orderQuant) * Integer.parseInt(selectedPrice);
                insertToCart(selectedData, selectedProduct, orderQuant, Integer.toString(totpay));

                inputTransc.table2.setModel((new JTable(readCart(), inputTransc.columnName2)).getModel());
                inputTransc.totPriceNumber.setText(Integer.toString(totalPayment));
            }

        });

        inputTransc.btnCheckout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String inputCustomerName = JOptionPane.showInputDialog(null, "Please type your name:");
                model.insertTransc(inputCustomerName, totalPayment);
                inputTransc.dispose();
            }
            
        });

    }

    String inputQuantity() {
        String inputQuant = JOptionPane.showInputDialog(null, "Input Quantity");
        return inputQuant;
    }

    void insertToCart(String prod_id, String prod_name, String quant, String totPay) {
        if(cartList[0][0] == null) {
            cartList[0][0] = prod_id;
            cartList[0][1] = prod_name;
            cartList[0][2] = quant;
            cartList[0][3] = totPay;
            totalPayment += Integer.parseInt(totPay);
            currentIndex++;
        }
        else {
            cartList[currentIndex][0] = prod_id;
            cartList[currentIndex][1] = prod_name;
            cartList[currentIndex][2] = quant;
            cartList[currentIndex][3] = totPay;
            totalPayment += Integer.parseInt(totPay);
            currentIndex++;
        }
    }

    String[][] readCart() {
        int i = 0;

        String data[][] = new String[10][4]; 

        while(i < 10) {
            data[i][0] = cartList[i][0];
            data[i][1] = cartList[i][1];
            data[i][2] = cartList[i][2];
            data[i][3] = cartList[i][3];
            i++;
        }
        return data;
    }

    public void setSelectedProductId(String selectedProductId) {
        this.selectedProductId = selectedProductId;
    }

    public String getSelectedProductId() {
        return selectedProductId;
    }
}
