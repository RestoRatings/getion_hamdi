/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.gui;

import gestion_hamdi.restaurant;
import gestion_hamdi.servicesrestaurant;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Hamdi
 */
public class RestaurantuserController implements Initializable {
              @FXML
    private ListView<restaurant> listresuser;
    
     private ObservableList<restaurant> restaurantlist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadInitialDataFromDatabase();
            listresuser.setCellFactory(param -> new ListCell<restaurant>() {//added19
        @Override
        protected void updateItem(restaurant item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                setText("Nom: " + item.getNom() + ", Location: " + item.getlocation());
            }
        }
    });

    
        listresuser.setItems(restaurantlist);
    } // TODO
        
      private void loadInitialDataFromDatabase() {
          servicesrestaurant ps = new servicesrestaurant();
    List<restaurant> initialrestaurant = ps.affihcer();
    
    // Populate circuitList with the initial data from the database
    restaurantlist.clear();
    restaurantlist.addAll(initialrestaurant);
}
        // TODO
    }    
    

