/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.gui;

import gestion_hamdi.reservation;
import gestion_hamdi.servicesreservation;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author Hamdi
 */
public class ChartController implements Initializable {
      @FXML
    private PieChart chart;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             // Retrieve the list of reservations from your data source
        servicesreservation reservationService = new servicesreservation();
        List<reservation> reservations = reservationService.affihcer();

        // Create a PieChart.Data list to store the data points
        List<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        // Group reservations by location and count them
          Map<String, Long> locationCounts = reservations.stream()
                .collect(Collectors.groupingBy(reservation -> reservation.getRestau().getlocation(), Collectors.counting()));

        // Create PieChart.Data for each location and count
        locationCounts.forEach((location, count) -> {
            PieChart.Data data = new PieChart.Data(location, count);
            pieChartData.add(data);
        });

        // Add the pieChartData list to the PieChart
        chart.getData().addAll(pieChartData);
    }
        // TODO
    }    
    
