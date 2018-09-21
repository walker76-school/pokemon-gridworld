import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main runner class
 * @author Andrew
 */
public class GameRunner extends Application{  
    
	/**
	 * main class which launches the JavaFX Application
	 */
	public static void main(String[] args)
    {
		Application.launch();
    }
	
	/**
	 * runs the initial start screen where a user can pick which game to play
	 * @param primaryStage the initial stage of the window
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {	
		Platform.runLater(new Runnable() { 
            @Override
            public void run() {
            	final Stage primaryStage = new Stage();
        		primaryStage.setTitle("Battle");
        		Platform.setImplicitExit(false);
        		
        		Image img = new Image("/Logo.png", true);
                ImageView iv1 = new ImageView();
                iv1.setImage(img);
                
                Button eliteFourButton = new Button();
                eliteFourButton.setText("Elite Four");
                eliteFourButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
                	@Override
                	public void handle(MouseEvent event){ 
                	    if(event.isShiftDown())
                	    {
                	    	Stage window = new Stage();
                	    	window.setTitle("Help");
                	    	
                	    	Label helpLabel = new Label();
                	    	helpLabel.setWrapText(true);
                	    	helpLabel.setText("In this mode you will select six Pokemon from a list and then select which moves to give each of your Pokemon. After that you will battle against the Elite Four who are four incredibly powerful trainers. You will have the option to save your progress between battles but not during a battle. If you can defeat all four then you will become the new Pokemon World Champion.");
                	    	
                	    	VBox helpLayout = new VBox();
                	    	helpLayout.getChildren().addAll(helpLabel);
                	    	helpLayout.setPadding(new Insets(20,20,20,20));
                	    	helpLayout.setAlignment(Pos.CENTER);
                            
                            Scene mainScene = new Scene(helpLayout, 500, 250);
                            window.setScene(mainScene);
                            window.showAndWait();
                	    	
                	    }
                	    else
                	    {
                	    	boolean yes = AlertBox.confirm("Are you sure you want to play the Elite Four?");
                        	if(yes)
                        	{
                        		primaryStage.close();
                        		new EliteFourWorld();                        		
                        	}
                	    }
                	}              
            	});
                
                Button multiplayerButton = new Button();
                multiplayerButton.setText("Multiplayer");
                multiplayerButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
                	@Override
                	public void handle(MouseEvent event){ 
                	    if(event.isShiftDown())
                	    {
                	    	Stage window = new Stage();
                	    	window.setTitle("Help");
                	    	
                	    	Label helpLabel = new Label();
                	    	helpLabel.setWrapText(true);
                	    	helpLabel.setText("In multiplayer mode you and another player will each select six Pokemon from a set list. After that each of you will select the four moves each of your Pokemon will have. These moves can be different for every Pokemon. Once everything has been selected you and your opponent will battle against each other, trading off who's turn it is.");
                	    	
                	    	VBox helpLayout = new VBox();
                	    	helpLayout.getChildren().addAll(helpLabel);
                	    	helpLayout.setPadding(new Insets(20,20,20,20));
                	    	helpLayout.setAlignment(Pos.CENTER);
                            
                            Scene mainScene = new Scene(helpLayout, 500, 250);
                            window.setScene(mainScene);
                            window.showAndWait();
                	    }
                	    else
                	    {
                	    	boolean yes = AlertBox.confirm("Are you sure you want to play Multiplayer?");
                        	if(yes)
                        	{
                        		primaryStage.close();
                        		new MultiplayerWorld();
                        	}
                	    }
                	}              
            	});
                
                Button catchAllButton = new Button();
                catchAllButton.setText("Catch 'Em All");
                catchAllButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
                	@Override
                	public void handle(MouseEvent event){ 
                	    if(event.isShiftDown())
                	    {
                	    	Stage window = new Stage();
                	    	window.setTitle("Help");
                	    	
                	    	Label helpLabel = new Label();
                	    	helpLabel.setWrapText(true);
                	    	helpLabel.setText("In this mode you will be dropped into a world full of grass. Your task is to catch every Pokemon available in the Hoenn region. There are 202 Pokemon in total. During an encounter you will be able to throw Pokeballs with a 50% success rate at catching a Pokemon. You will be able to save your progress as you go.");
                	    	
                	    	VBox helpLayout = new VBox();
                	    	helpLayout.getChildren().addAll(helpLabel);
                	    	helpLayout.setPadding(new Insets(20,20,20,20));
                	    	helpLayout.setAlignment(Pos.CENTER);
                            
                            Scene mainScene = new Scene(helpLayout, 500, 250);
                            window.setScene(mainScene);
                            window.showAndWait();
                	    }
                	    else
                	    {
                	    	boolean yes = AlertBox.confirm("Are you sure you want to play Catch 'Em All?");
                        	if(yes)
                        	{                        		
                        		primaryStage.close();
                        		new SafariWorld();
                        	}
                	    }
                	}              
            	});
                
                Label help = new Label("Shift click for more information!");
                help.setStyle("-fx-font: 12 arial;");
                
                HBox buttons = new HBox();
        		buttons.getChildren().addAll(eliteFourButton, multiplayerButton, catchAllButton);	
        		buttons.setSpacing(40);
        		buttons.setAlignment(Pos.CENTER);
                
                VBox mainLayout = new VBox();
                mainLayout.getChildren().addAll(iv1, buttons, help);               
                mainLayout.setSpacing(40);
                mainLayout.setAlignment(Pos.CENTER);
                
                Scene mainScene = new Scene(mainLayout, 500, 250);
                primaryStage.setScene(mainScene);
        		primaryStage.showAndWait();
            }
        });
	}
}