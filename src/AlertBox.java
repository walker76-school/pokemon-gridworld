import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;

/**
 * A class to display various popup boxes
 */
public abstract class AlertBox {
	
	private static String retString;
	private static boolean retBoolean;
	
	/**
	 * displays a popup with a title, message and custom text for a button
	 * @param title the title to be displayed on the popup
	 * @param message the message to be displayed on the popup
	 * @param button the message to be displayed on the popup's button
	 */
    public static void display(String title, String message, String button) {
        final Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button(button);
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            		window.close();
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout, 250, 100);
        window.setScene(scene);
        window.showAndWait();
    }
    
    /**
     * displays a popup with a custom message and button
     * @param message the message to be displayed on the popup
     * @param button the message to be displayed on the popup's button
     */
    public static void displayNoTitle(String message, String button) {
        final Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button(button);
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            		window.close();
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout, 500, 100);
        window.setScene(scene);
        window.showAndWait();
    }
    
    /**
     * displays a window for the user to enter in a string
     * @param message the message to be displayed on the popup
     * @param button the message to be displayed on the popup's button
     * @return the string that the user entered
     */
    public static String displayChoice(String message, String button) {
        final Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);
        
        final TextField input = new TextField();
        
        Label label = new Label();
        label.setText(message);
        label.setTextAlignment(TextAlignment.CENTER);
        
        Button closeButton = new Button(button);
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            		retString = input.getText();
            		window.close();
            }
        });
        
               

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, input, closeButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10,20,10,20));
        
        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout, 250, 100);
        window.setScene(scene);
        window.showAndWait();
        return retString;
    }
    
    /**
     * displays a popup for the user to confirm a choice
     * @param message the message to be displayed in the popup
     * @return true or false based on the user's confirmation
     */
    public static boolean confirm(String message) {
        final Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(300);
        
        
        Label label = new Label();
        label.setText(message);
        
        Button noButton = new Button("No");
        noButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	retBoolean = false;
            	window.close();
            }
        });
        Button yesButton = new Button("Yes");
        yesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	retBoolean = true;
            	window.close();
            }
        });
        
        HBox buttons = new HBox();
        buttons.getChildren().addAll(yesButton, noButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, buttons);
        layout.setAlignment(Pos.CENTER);
        
        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout, 300, 100);
        window.setScene(scene);
        window.showAndWait();
        return retBoolean;
    }

}