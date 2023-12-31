/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.gui;

import com.sun.xml.internal.bind.IDResolver;
import gestion_hamdi.TwilloSMS;
import gestion_hamdi.reservation;
import gestion_hamdi.Restaurant;
import gestion_hamdi.servicesreservation;
import gestion_hamdi.servicesrestaurant;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Hamdi
 */
public class ReservationController implements Initializable {
 @FXML
    private  DatePicker date;
     @FXML
    private ComboBox<String> hourres;

    @FXML
    private ComboBox<String> minuteres;
    @FXML
 private ListView<Restaurant> restaurantres;
           @FXML
    private TextField idres;
    
     private ObservableList<Restaurant> restaurantlist = FXCollections.observableArrayList();
                @FXML
    private ListView<reservation> listres;
    
     private ObservableList<reservation> reservationlist = FXCollections.observableArrayList();
     
  private Restaurant selectedrestaurants;
    public void setSelectedRestaurant(Restaurant selectedRestaurant) {
        this.selectedrestaurants = selectedRestaurant;
    }
    
     /* Initializes the controller class.
     */
  
    
      
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
             loadInitialDataFromDatabase();
                restaurantres.setCellFactory(param -> new ListCell<Restaurant>() {//added19
        @Override
        protected void updateItem(Restaurant item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                setText("Nom: " + item.getNom() + ", Location: " + item.getlocation());
            }
        }
    });

        restaurantres.setItems(restaurantlist);
                  loadInitialDataFromDatabase();
                   listres.setCellFactory(param -> new ListCell<reservation>() {
        @Override
        protected void updateItem(reservation item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                setText(
                         " | Date: " + item.getDatereser() +
                         " | Time: " + item.getTimereser() +
                         " | Restaurant Name: " + item.getRestau().getNom() +
                         " | Restaurant Location: " + item.getRestau().getlocation());
            }
        }
    });

        listres.setItems(reservationlist);
        // TODO
       
         for (int i = 0; i <= 24; i++) {
            String hour = String.format("%02d", i);
            hourres.getItems().add(hour);
        }

        // Populate the minute ComboBox with different minute values (e.g., 00 to 59).
        for (int i = 0; i <= 59; i++) {
            String minute = String.format("%02d", i);
            minuteres.getItems().add(minute);
        }
        System.out.println(selectedrestaurants);
    }
   
          private void loadInitialDataFromDatabase() {
          servicesrestaurant ps = new servicesrestaurant();
    List<Restaurant> initialrestaurant = ps.affihcer();
    
    // Populate circuitList with the initial data from the database
    restaurantlist.clear();
    restaurantlist.addAll(initialrestaurant);
       
          servicesreservation res = new servicesreservation();
    List<reservation> initialresList = res.affihcer();
    
    // Populate circuitList with the initial data from the database
    reservationlist.clear();
    reservationlist.addAll(initialresList);
    
}
          
       
    @FXML
    public void addres (ActionEvent event) {
     
            LocalDate selectedDate = date.getValue();
            System.out.println("Selected Date: " + selectedDate);
     
    
            String selectedHour = hourres.getValue();
        String selectedMinutes = minuteres.getValue();
           String selectedTime = selectedHour + ":" + selectedMinutes;
        System.out.println(selectedTime);
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                if (selectedDate == null || selectedHour == null || selectedMinutes == null ) {
            // Show an alert with the custom message
            showAlert("incomplete data ");
            return; // Exit the method to prevent further execution
        }

        
            // Parse the string into a LocalTime
            LocalTime localTime = LocalTime.parse(selectedTime, formatter);
        
         Restaurant selectedrestaurant = restaurantres.getSelectionModel().getSelectedItem();
        
         
         servicesreservation res = new servicesreservation();
          reservation r = new reservation(1, selectedDate, localTime, selectedrestaurant);
          res.ajouter(r);
            List<reservation> updatedCircuits = res.affihcer();
            // Update circuitList with the new data
    reservationlist.clear();
    reservationlist.addAll(updatedCircuits);

    // Set the ListView items to circuitList to reflect the updated data
    listres.setItems(reservationlist);
          /* String toPhoneNumber = "+21692548524"; // Replace with recipient's phone number
        String messageBody = "Your reservation has been confirmed. Thank you for choosing our restaurant.";
        TwilloSMS.sendSMS(toPhoneNumber, messageBody);*/
     
          

        // Combine the hour and minutes into a time variable.
     
}
            public void modres (ActionEvent event){
                  listres.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {//added 19
            if (event.getClickCount() == 2) { // Double-click event
                reservation selectedReservation = listres.getSelectionModel().getSelectedItem();
                if (selectedReservation != null) {
                    // Populate the fields with the selected restaurant's data
                    int id = selectedReservation.getId();
                            // Define the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Format the LocalDate as a string
        String formattedDate = selectedReservation.getDatereser().format(formatter);
                  
        DateTimeFormatter formattert = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Format the LocalTime as a string
        String formattedTime = selectedReservation.getTimereser().format(formattert);
                 String[] parts = formattedTime.split(":"); // Split the string using ":"
              String hour = parts[0]; // "22"
              String minute = parts[1]; // "00"
      
                      
                    
                    // Now set the individual fields with the retrieved data
                    idres.setText(String.valueOf(id));
                    date.setValue(selectedReservation.getDatereser());
                    hourres.setValue(hour);
                    minuteres.setValue(minute);
                          
                }
            }   }
    });
            LocalDate selectedDate = date.getValue();
            System.out.println("Selected Date: " + selectedDate);
     
    
            String selectedHour = hourres.getValue();
        String selectedMinutes = minuteres.getValue();
           String selectedTime = selectedHour + ":" + selectedMinutes;
        System.out.println(selectedTime);
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                      if (selectedDate == null || selectedHour == null || selectedMinutes == null ) {
            // Show an alert with the custom message
            showAlert("incomplete data ");
            return; // Exit the method to prevent further execution
        }

        
            // Parse the string into a LocalTime
            LocalTime localTime = LocalTime.parse(selectedTime, formatter);
             int id = Integer.parseInt( idres.getText());
        
         Restaurant selectedrestaurant = restaurantres.getSelectionModel().getSelectedItem();
         servicesreservation res = new servicesreservation();
          reservation r = new reservation(id, selectedDate, localTime, selectedrestaurant);
          res.modifier(r);
                     List<reservation> updatedCircuits = res.affihcer();
            // Update circuitList with the new data
    reservationlist.clear();
    reservationlist.addAll(updatedCircuits);

    // Set the ListView items to circuitList to reflect the updated data
    listres.setItems(reservationlist);
          
             

}
    public void suppres (ActionEvent event) {
 reservation selectedres = listres.getSelectionModel().getSelectedItem();

    // Check if an item is selected
    if (selectedres == null) {
        System.out.println("No item selected for deletion.");
               
            // Show an alert with the custom message
            showAlert("select a reservation ");
          
        
        return;
    }

    // Remove the selected item from the database
    servicesreservation res = new servicesreservation();
    res.supprimer(selectedres);
     reservationlist.remove(selectedres);
                    List<reservation> updatedCircuits = res.affihcer();
            // Update circuitList with the new data
    reservationlist.clear();
    reservationlist.addAll(updatedCircuits);

    // Set the ListView items to circuitList to reflect the updated data
    listres.setItems(reservationlist);


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
private void showAlert(String message) {
    Alert alert = new Alert(AlertType.WARNING);
    alert.setTitle("Warning");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}}
   
        
    
    


