/* Nicole Marchant
 * Project 3
 * 2/20/2024
 * Javafx application that calculates trip cost.
 */
package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
 
public class Project3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
    	TripCost tripCost = new TripCost();
    	
        primaryStage.setTitle("Trip Cost Estimator");
        GridPane bigGrid = new GridPane();
        bigGrid.setHgap(5);
        bigGrid.setVgap(5);
        
        Label distanceLabel = new Label("  Distance:");
        bigGrid.add(distanceLabel, 0, 0);
        
        TextField distanceDialog = new TextField();
        distanceDialog.setAlignment(Pos.CENTER_RIGHT);
        bigGrid.add(distanceDialog, 1, 0);
        
        ComboBox<String> distanceBox = new ComboBox<String>();
        distanceBox.getItems().addAll("miles", "kilometers");
        distanceBox.getSelectionModel().selectFirst();
        bigGrid.add(distanceBox, 2, 0);

        Label gasCostLabel = new Label("  Gasoline Cost:");
        bigGrid.add(gasCostLabel, 0, 1);
        
        TextField gasCostDialog = new TextField();
        gasCostDialog.setAlignment(Pos.CENTER_RIGHT);
        bigGrid.add(gasCostDialog, 1, 1);
        
        ComboBox<String> gasCostBox = new ComboBox<String>();
        gasCostBox.getItems().addAll("dollars/gal", "dollars/liter");
        gasCostBox.getSelectionModel().selectFirst();
        bigGrid.add(gasCostBox, 2, 1);
        
        Label gasMileageLabel = new Label("  Gas Mileage");
        bigGrid.add(gasMileageLabel, 0, 2);
        
        TextField gasMileageDialog = new TextField();
        gasMileageDialog.setAlignment(Pos.CENTER_RIGHT);
        bigGrid.add(gasMileageDialog, 1, 2);
        
        ComboBox<String> gasMileageBox = new ComboBox<String>();
        gasMileageBox.getItems().addAll("miles/gal", "kilometers/liter");
        gasMileageBox.getSelectionModel().selectFirst();
        bigGrid.add(gasMileageBox, 2, 2);
        
        Label daysLabel = new Label("  Number of Days:");
        bigGrid.add(daysLabel, 0, 3);
        
        TextField daysDialog = new TextField();
        daysDialog.setAlignment(Pos.CENTER_RIGHT);
        bigGrid.add(daysDialog, 1, 3);
        
        Label hotelCostLabel = new Label("  Hotel Cost");
        bigGrid.add(hotelCostLabel, 0, 4);
        
        TextField hotelCostDialog = new TextField();
        hotelCostDialog.setAlignment(Pos.CENTER_RIGHT);
        bigGrid.add(hotelCostDialog, 1, 4);
        
        Label foodCostLabel = new Label("  Food Cost");
        bigGrid.add(foodCostLabel, 0, 5);
        
        TextField foodCostDialog = new TextField();
        foodCostDialog.setAlignment(Pos.CENTER_RIGHT);
        bigGrid.add(foodCostDialog, 1, 5);
        
        Label attractionsLabel = new Label("  Attractions");
        bigGrid.add(attractionsLabel, 0, 6);
        
        TextField attractionsDialog = new TextField();
        attractionsDialog.setAlignment(Pos.CENTER_RIGHT);
        bigGrid.add(attractionsDialog, 1, 6);
        
        Pane calculateSpacer = new Pane();
        bigGrid.add(calculateSpacer, 0, 7);
        
        Button calculate = new Button();
        calculate.setText("Calculate");
        bigGrid.add(calculate, 1, 7);
        
        Label totalCostLabel = new Label("Total Trip Cost:");
        bigGrid.add(totalCostLabel, 0, 8);
        
        TextField totalCostDialog = new TextField();
        totalCostDialog.setEditable(false);
        totalCostDialog.setAlignment(Pos.CENTER_RIGHT);
        bigGrid.add(totalCostDialog, 1, 8);
        
        calculate.setOnAction(new EventHandler<ActionEvent>() { 
        	@Override
        	public void handle(ActionEvent event) {
        		try {
        			tripCost.setTripCost(Double.parseDouble(gasCostDialog.getText()),
        								 Double.parseDouble(distanceDialog.getText()),
        								 Double.parseDouble(gasMileageDialog.getText()),
        								 Double.parseDouble(attractionsDialog.getText()),
        								 Double.parseDouble(hotelCostDialog.getText()),
        								 Double.parseDouble(foodCostDialog.getText()),
        								 Integer.parseInt(daysDialog.getText()));
        			totalCostDialog.setText(tripCost.toString());
        		} catch (Exception e) {
        			totalCostDialog.setText("Error");
        		}
        	}
        });
        
        // 00 Distance: 01 distance input 02 distance combo
        // 10 gas cost: 11 gas input 12 cost comb
        //StackPane root = new StackPane();
        primaryStage.setScene(new Scene(bigGrid, 400, 300));
        primaryStage.show();
    }
}