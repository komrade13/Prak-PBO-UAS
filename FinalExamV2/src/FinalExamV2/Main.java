/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalExamV2;

/**
 *
 * @author User
 */
public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MovieView view = new MovieView();
        MovieModel model = new MovieModel();
        MovieController controller = new MovieController(model, view);
    }
    
}
