import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Class to handle an encounter in the Safari
 * @author Andrew
 *
 */
public abstract class Safari {
	private static Stage primaryStage;
	private static Player player;
	private static Pokemon opponent;
	private static boolean canExit;	
	private static MediaPlayer mp;
	
	/**
	 * Creates a new battle between a wild pokemon and a trainer
	 * @param p the trainer to battle with
	 * @param opp the pokemon to battle against
	 */
	public static void encounter(Player p, Pokemon opp)
	{
		player = p;
		opponent = opp;
		
		primaryStage = new Stage();
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	        public void handle(WindowEvent ev) {
	            if (!canExit)
	                ev.consume();
	            else
	            	primaryStage.close();
	        }
	    });
		setMainScene();
		Platform.setImplicitExit(false);
		String path = GameRunner.class.getResource("/WildBattle.mp3").toString();
        Media media = new Media(path);
        mp = new MediaPlayer(media);
        mp.play();
		primaryStage.showAndWait();

	}	
	
	/**
	 * Creates the main option screen with Attack, Switch, Bag and Run buttons
	 */
	private static void setMainScene()
	{
		primaryStage.setTitle("Battle");
		
       	Label opponentPokemon = new Label(opponent.getName()); 
        
        ImageView iv2 = new ImageView();
        iv2.setImage(opponent.getImage());
        
        Button catchButton = new Button();
        catchButton.setText("Catch");
        catchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	catchPokemon();
            	
            }
        });
        
        
        Button runButton = new Button();
        runButton.setText("Run");
        runButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
        		    boolean run = AlertBox.confirm("Are you sure you want to run from " + opponent.getName() + "?");
	            	if (run)
	            	{
	            		mp.stop();
	            		canExit = true;
	            		primaryStage.close();
	            	}
            }
        });
        
        VBox infoLayout = new VBox();
        infoLayout.setSpacing(10);
        infoLayout.setAlignment(Pos.CENTER);
        
        if(player.getPokeDex().checkSeen(opponent))
        {
            ImageView ivC = new ImageView();
            ivC.setImage(new Image("caught.gif", true));
            
        	HBox caught = new HBox();
        	caught.getChildren().addAll(opponentPokemon, ivC);
        	caught.setSpacing(40);
        	caught.setAlignment(Pos.CENTER);
        	infoLayout.getChildren().addAll(caught, iv2);
        }
        else
        {
        	infoLayout.getChildren().addAll(opponentPokemon, iv2);
        }
        	
        	
        
        HBox buttons = new HBox();
        buttons.getChildren().addAll(catchButton, runButton);
        buttons.setSpacing(40);
        buttons.setAlignment(Pos.CENTER);
        
        VBox mainLayout = new VBox();
        mainLayout.getChildren().addAll(infoLayout, buttons);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setSpacing(40);
        
        Scene mainScene = new Scene(mainLayout, 500, 300);
        primaryStage.setScene(mainScene);
	}
		
	/**
	 * Sets the winner screen if you beat the opposing Pokemon
	 */
	private static void catchPokemon() 
	{
		int catchRate = ((int)(Math.random() * 101));
		if(catchRate >= 50 || player.getName().equals("Andrew"))
		{
			player.catchPokemon(opponent);
			primaryStage.setTitle("Congratulations!");
			
			String path = GameRunner.class.getResource("/WildBattleEnd.mp3").toString();
	        Media media = new Media(path);
	        mp.stop();
	        mp = new MediaPlayer(media);
	        mp.play();
			
			Label attackLabel = new Label("You have caught " + opponent.getName() + "!");
			
	        Button okButton = new Button();
	        okButton.setText("OK");
	        okButton.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	mp.stop();
	            	canExit = true;
	            	primaryStage.close();
	            }
	        });

	        VBox winnerLayout = new VBox();
	        winnerLayout.getChildren().addAll(attackLabel, okButton);
	        winnerLayout.setSpacing(10);
	        winnerLayout.setAlignment(Pos.CENTER);

	        Scene winnerScene = new Scene(winnerLayout, 525, 150);
	        primaryStage.setScene(winnerScene);
		}
		else
		{
			AlertBox.displayNoTitle("The PokeBall didn't work!", "OK");
			int runRate = ((int)(Math.random() * 101));
			if(runRate >= 50)
			{
				AlertBox.displayNoTitle("You scared " + opponent.getName() + " away.", "OK");
            	mp.stop();
            	canExit = true;
				primaryStage.close();
			}
				
			else
			{
				AlertBox.displayNoTitle(opponent.getName() + " is watching closely.", "OK");
				setMainScene();
			}				
		}
	}
}
