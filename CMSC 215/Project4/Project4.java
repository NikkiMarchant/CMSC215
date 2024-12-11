/* Nicole Marchant
 * Project 4
 * 3/5/2024
 * Compares two Time objects
 */
package application;

import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Project4 extends Application {
	public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		pane.getChildren().addAll();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5);
		pane.setVgap(5);
		
		Pane emptySpacer = new Pane();
		pane.add(emptySpacer, 0, 0);
		
		Label startTime = new Label("Start Time");
		pane.add(startTime, 1, 0);
		GridPane.setHalignment(startTime, HPos.CENTER);
		
		Label endTime = new Label("End Time");
		pane.add(endTime, 2, 0);
		GridPane.setHalignment(endTime, HPos.CENTER);
		
		Label timeInterval1 = new Label("Time Interval 1");
		pane.add(timeInterval1, 0,1);
		
		TextField intervalStart1 = new TextField();
		pane.add(intervalStart1, 1,1);
		intervalStart1.setAlignment(Pos.CENTER);
		intervalStart1.setMaxWidth(550);
		
		TextField intervalEnd1 = new TextField();
		pane.add(intervalEnd1, 2,1);
		intervalEnd1.setAlignment(Pos.CENTER);
		intervalEnd1.setMaxWidth(550);
		
		Label timeInterval2 = new Label("Time Interval 2");
		pane.add(timeInterval2, 0,2);
		
		TextField intervalStart2 = new TextField();
		pane.add(intervalStart2, 1,2);
		intervalStart2.setAlignment(Pos.CENTER);
		
		TextField intervalEnd2 = new TextField();
		pane.add(intervalEnd2, 2,2);
		intervalEnd2.setAlignment(Pos.CENTER);
		
		Button CompareIntervals = new Button();
		CompareIntervals.setText("Compare Intervals");
		pane.add(CompareIntervals, 0, 3);
		GridPane.setColumnSpan(CompareIntervals ,3);
		CompareIntervals.setMaxSize(500, 500);
		
		Label timeCheck = new Label("Time to Check");
		pane.add(timeCheck, 0,4);
		
		TextField checkTime = new TextField();
		pane.add(checkTime, 1, 4);
		GridPane.setColumnSpan(checkTime ,2);
		checkTime.setAlignment(Pos.CENTER);
		
		Button CheckTime = new Button();
		CheckTime.setText("Check Time");
		pane.add(CheckTime, 0, 5);
		GridPane.setColumnSpan(CheckTime,3);
		CheckTime.setMaxSize(500, 500);
		
		TextField intervalsOverlap = new TextField();
		pane.add(intervalsOverlap, 0,6);
		intervalsOverlap.setEditable(false);
		intervalsOverlap.setAlignment(Pos.BOTTOM_LEFT);
		GridPane.setColumnSpan(intervalsOverlap ,3);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Time Interval Checker");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		CompareIntervals.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent t) {
				
				String intervalStr = new String("");
				
				Time timeS1 = new Time(intervalStart1.getText());
				Time timeE1 = new Time(intervalEnd1.getText());
				Interval<Time> interval1 = new Interval<Time>(timeS1, timeE1);
				
				Time timeS2 = new Time(intervalStart2.getText());
				Time timeE2 = new Time(intervalEnd2.getText());
				Interval<Time> interval2 = new Interval<Time>(timeS2, timeE2);
				
				if(interval1.subinterval(interval2)) {
					intervalStr = "Interval 2 is a sub-interval of interval 1";
				}
				else if(interval2.subinterval(interval1)) {
					intervalStr = "Interval 1 is a sub-interval of interval 2";
				}
				else if(interval1.overlaps(interval2) || interval2.overlaps(interval1)) {
					intervalStr = "The intervals overlap";
				}
				else {
					intervalStr = "The intervals are disjoint";
				}
				
				intervalsOverlap.setText(intervalStr);
				return;
			}
		});
		
		CheckTime.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent t) {
				String intervalStr = new String("");
				
				Time timeS1 = new Time(intervalStart1.getText());
				Time timeE1 = new Time(intervalEnd1.getText());
				Interval<Time> interval1 = new Interval<Time>(timeS1, timeE1);
				
				Time timeS2 = new Time(intervalStart2.getText());
				Time timeE2 = new Time(intervalEnd2.getText());
				Interval<Time> interval2 = new Interval<Time>(timeS2, timeE2);
				
				Time timeC1 = new Time(checkTime.getText());
				
				boolean int1Check = false;
				boolean int2Check = false;
				// compare to interval1
				if(interval1.within(timeC1)) {
					int1Check = true;
				}
				if(interval2.within(timeC1)) {
					int2Check = true;
				}
				
				if(int1Check && int2Check) {
					intervalStr = String.format("Both intervals contain the time %s", timeC1);
				}
				else if(int1Check) {
					intervalStr = String.format("Only interval 1 contains the time %s", timeC1);
				}
				else if(int2Check) {
					intervalStr = String.format("Only interval 2 contains the time %s", timeC1);
				}
				else {
					intervalStr = String.format("Neither interval contains the time %s", timeC1);
				}
				
				intervalsOverlap.setText(intervalStr);
				return;
			}
		});
	}		
}
