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
          /*   try {
            root = FXMLLoader.load(getClass().
                    getResource("modifierrestau.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("modifier restau");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


        try {
            root = FXMLLoader.load(getClass().
                    getResource("ajouterrestau.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Ajouter restau");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
      /*  try {
            // Load and display the "ajouterrestau.fxml" scene in a new window
            Parent ajouterRoot = FXMLLoader.load(getClass().getResource("ajouterrestau.fxml"));
            Scene ajouterScene = new Scene(ajouterRoot);
            Stage ajouterStage = new Stage();
            ajouterStage.setTitle("Ajouter restau");
            ajouterStage.setScene(ajouterScene);
            ajouterStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            // Load and display the "modifierrestau.fxml" scene in another new window
            Parent modifierRoot = FXMLLoader.load(getClass().getResource("modifierrestau.fxml"));
            Scene modifierScene = new Scene(modifierRoot);
            Stage modifierStage = new Stage();
            modifierStage.setTitle("Modifier restau");
            modifierStage.setScene(modifierScene);
            modifierStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }*/

