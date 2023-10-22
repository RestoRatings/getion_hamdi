/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Hamdi
 */
public class newfxmain extends Application {
    
    private Scene ajouterScene;
    private Scene modifierScene;
    private Scene managementScene;

    @Override
    public void start(Stage primaryStage) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("restaurant management.fxml"));
            Parent root = loader.load();
             managementScene = new Scene(root);

            RestaurantManagementController controller = loader.getController();
            controller.setPrimaryStage(primaryStage);

            primaryStage.setScene(managementScene);
            primaryStage.setTitle("Restaurant Management");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
       