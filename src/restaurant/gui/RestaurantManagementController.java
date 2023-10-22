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
public class RestaurantManagementController implements Initializable {
   private Stage primaryStage;
    private Scene ajouterScene;
    private Scene modifierScene;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization code, if needed
    }

    @FXML
    public void ajoutersc(ActionEvent event) throws IOException {
      
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterrestau.fxml"));
        Parent root = loader.load();
        // Access the StartController if needed
        AjouterrestauController ajouterrestau = loader.getController();
        // Initialize data or perform other operations here
        Scene scene = new Scene(root);
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        }
        @FXML
    public void reservation (ActionEvent event) throws IOException {
      
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
       


   /* void setPrimaryStage(Stage primaryStage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
