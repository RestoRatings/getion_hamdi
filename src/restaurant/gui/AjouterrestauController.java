/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.gui;

import gestion_hamdi.restaurant;
import gestion_hamdi.servicesrestaurant;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamdi
 */
public class AjouterrestauController implements Initializable {

      @FXML
    private TextField nomrestau;
    @FXML
    private TextField locationrestau;
       @FXML
    private TextField idrestaus;
            @FXML
    private ListView<restaurant> listv;
    
     private ObservableList<restaurant> restaurantlist = FXCollections.observableArrayList();
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 loadInitialDataFromDatabase();
        listv.setItems(restaurantlist);
        // TODO
    }    
      private void loadInitialDataFromDatabase() {
          servicesrestaurant ps = new servicesrestaurant();
    List<restaurant> initialrestaurant = ps.affihcer();
    
    // Populate circuitList with the initial data from the database
    restaurantlist.clear();
    restaurantlist.addAll(initialrestaurant);
}

        // TODO
        
    
     @FXML
    private void ajouterrestau(ActionEvent event) {
        String nom=nomrestau.getText();
        String location = locationrestau.getText();
         
         servicesrestaurant sp = new servicesrestaurant();
        restaurant p = new restaurant( nom,location );
        sp.ajouter(p);
         List<restaurant> updatedCircuits = sp.affihcer();
            // Update circuitList with the new data
    restaurantlist.clear();
    restaurantlist.addAll(updatedCircuits);

    // Set the ListView items to circuitList to reflect the updated data
    listv.setItems(restaurantlist);

    // Clear the TextFields after saving
    clearTextFields();
}@FXML
        private void modifierrestaus (ActionEvent event) {
   
    
    // Check if an item is selected
  
        String nom=nomrestau.getText();
        String location = locationrestau.getText();
        int id = Integer.parseInt( idrestaus.getText());
         servicesrestaurant sp = new servicesrestaurant();
        restaurant p = new restaurant( id,nom,location );
        sp.modifier(p);
            clearTextFields();
            List<restaurant> updatedCircuits = sp.affihcer();
            restaurantlist.clear();
    restaurantlist.addAll(updatedCircuits);
     // Refresh the ListView to reflect the changes
    listv.setItems(null); // Clear the items
    listv.setItems(restaurantlist); 
}
        @FXML
        private void supprimerrestau (ActionEvent event) {
 restaurant selectedrestaurant = listv.getSelectionModel().getSelectedItem();

    // Check if an item is selected
    if (selectedrestaurant == null) {
        System.out.println("No item selected for deletion.");
        return;
    }

    // Remove the selected item from the database
    servicesrestaurant sp = new servicesrestaurant();
    sp.supprimer(selectedrestaurant);

    // Remove the selected item from the ListView
    restaurantlist.remove(selectedrestaurant);

    // Clear the TextFields after deleting
    clearTextFields();
                List<restaurant> updatedCircuits = sp.affihcer();
            restaurantlist.clear();
    restaurantlist.addAll(updatedCircuits);
     // Refresh the ListView to reflect the changes
    listv.setItems(null); // Clear the items
    listv.setItems(restaurantlist); 
}
@FXML
public void goBackToManagement(ActionEvent event) {
    // Load the FXML file for the "restaurant management" scene
    FXMLLoader loader = new FXMLLoader(getClass().getResource("restaurant management.fxml"));
    try {
        Parent root = loader.load();
        Scene managementScene = new Scene(root);

        // Get the current stage
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the scene of the stage to the "restaurant management" scene
        currentStage.setScene(managementScene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private void clearTextFields() {
           idrestaus.clear();
    nomrestau.clear();
    locationrestau.clear();
   
    }
}