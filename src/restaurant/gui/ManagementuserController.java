/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamdi
 */
public class ManagementuserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    
    @FXML
    public void ajouteru(ActionEvent event) throws IOException {
      
        FXMLLoader loader = new FXMLLoader(getClass().getResource("restaurantuser.fxml"));
        Parent root = loader.load();
        // Access the StartController if needed
        RestaurantuserController ajouterrestau = loader.getController();
        // Initialize data or perform other operations here
        Scene scene = new Scene(root);
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        }
        @FXML
    public void reservationu (ActionEvent event) throws IOException {
      
        FXMLLoader loader = new FXMLLoader(getClass().getResource("reservation.fxml"));
        Parent root = loader.load();
        // Access the StartController if needed
        ReservationController ajouterres = loader.getController();
        // Initialize data or perform other operations here
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        }
}
