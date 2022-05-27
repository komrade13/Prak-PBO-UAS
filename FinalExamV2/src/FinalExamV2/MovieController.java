/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalExamV2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class MovieController {
    MovieModel modelData;
    MovieView movieView;
    public String data;
    public MovieController(MovieModel modelData, MovieView movieView){
        this.modelData = modelData;
        this.movieView = movieView;
        
        if (modelData.getDataAmount()!=0) {
            String dataMovie[][] = modelData.readData();
            movieView.tabel.setModel((new JTable(dataMovie, movieView.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Movie not found");
        }
        
         movieView.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Title = movieView.getTitle();
                double Plot = Double.parseDouble(movieView.getPlot());
                double Character = Double.parseDouble(movieView.getCharacter());
                double Acting = Double.parseDouble(movieView.getActing());
                double Score = (Plot+Character+Acting)/3;
                modelData.insertData(Title, Plot, Character, Acting, Score);
         
                String dataMovie[][] = modelData.readData();
                movieView.tabel.setModel((new JTable(dataMovie, movieView.namaKolom)).getModel());
            }
        });
         
          movieView.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String Title = movieView.getTitle();
                double Plot = Double.parseDouble(movieView.getPlot());
                double Character = Double.parseDouble(movieView.getCharacter());
                double Acting = Double.parseDouble(movieView.getActing());
                double Score = (Plot+Character+Acting)/3;
                modelData.updateData(Title, Plot, Character, Acting, Score);

                String dataMovie[][] = modelData.readData();
                movieView.tabel.setModel((new JTable(dataMovie, movieView.namaKolom)).getModel());
            }
        });
         
          movieView.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                movieView.tfTitle.setText("");
                movieView.tfPlot.setText("");
                movieView.tfCharacter.setText("");
                movieView.tfActing.setText("");
            }
        });
        
    
          movieView.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int line = movieView.tabel.getSelectedRow();
                data = movieView.tabel.getValueAt(line, 0).toString();
                String dataUpdate[] = new String[4];
                dataUpdate[0] = movieView.tabel.getValueAt(line, 0).toString();
                dataUpdate[1] = movieView.tabel.getValueAt(line, 1).toString();
                
                
                System.out.println(data);
                 
                
                
            }
           });
                  
          movieView.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int input = JOptionPane.showConfirmDialog(null,
                "Delete the movie '" + data + "'?", "Warning", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                modelData.deleteData(data);
                String dataMovie[][] = modelData.readData();
                movieView.tabel.setModel((new JTable(dataMovie, movieView.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Delete canceled");
            }
                }
        });

    }
    
}
