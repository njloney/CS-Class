


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	Label label;
	TextField TF;
	HBox HB1;
	HBox HB2;
	
	//student Task #4:
	DataManager BH = new DataManager();
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		b1 = new Button("Hello");
		b2 = new Button("Howdy");
		b3 = new Button("Chinese");
		b4 = new Button("Clear");
		b5 = new Button("Exit");
		label = new Label("Feedback");
		TF = new TextField();
		HB1 = new HBox();
		HB2 = new HBox();
		
		//student Task #4:
		b1.setOnAction(new ButtonHandler());
		b2.setOnAction(new ButtonHandler());
		b3.setOnAction(new ButtonHandler());
		b4.setOnAction(new ButtonHandler());
		b5.setOnAction(new ButtonHandler());
		
		HB1.setMargin(b1, getInsets());
		HB1.setMargin(b2, getInsets());
		HB1.setMargin(b3, getInsets());
		HB1.setMargin(b4, getInsets());
		HB1.setMargin(b5, getInsets());
		HB2.setMargin(TF, getInsets());
		HB2.setMargin(label, getInsets());
		
		HB1.setAlignment(Pos.CENTER);
		HB2.setAlignment(Pos.CENTER);
		//student Task #3:
		HB1.getChildren().addAll(b1,b2,b3,b4,b5);
		HB2.getChildren().addAll(label,TF);
		getChildren().addAll(HB1,HB2);
		
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent event) {
			Button button = (Button)event.getTarget();
			if(button == b1) {
				TF.setText(BH.getHello());
			} else if (button == b2) {
				TF.setText(BH.getHowdy());
			} else if (button == b3) {
				TF.setText(BH.getChinese());
			} else if (button == b4) {
				TF.setText("");
			} else if (button == b5) {
				Platform.exit();
				System.exit(0);
			}
			
		}
		
	}
}
	
