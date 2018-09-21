import java.awt.Color;
import java.util.Optional;
import info.gridworld.actor.Actor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * Elite Four Drake who holds a pokemon party to battle
 * @author Andrew
 */
public abstract class Drake extends Actor
{
	private static Pokemon[] party;
	private static Player player;
	private static Pokemon[] playerParty;
	private static MediaPlayer mp;
	
	/**
	 * Does battle with Elite Four Drake
	 * @param p the player to do battle with
	 */
	public static void doBattle(Player p)
	{
		Pokemon[] temp = {new Pokemon("Drake's Shelgon"), new Pokemon("Drake's Altaria"), new Pokemon("Drake's Kingdra"), new Pokemon("Drake's Flygon"), new Pokemon("Drake's Salamance")};		
		party = temp;	
		
		player = p;
		playerParty = player.getParty();
		
		String path = GameRunner.class.getResource("/EliteFourIntro.mp3").toString();
        Media media = new Media(path);
        mp = new MediaPlayer(media);
        mp.play();
        
		AlertBox.display("Uh Oh!", "Elite Four Drake would like to battle!", "Let's Go!");

    	mp.stop();
		path = GameRunner.class.getResource("/EliteFour.mp3").toString();
        media = new Media(path);
        mp = new MediaPlayer(media);
        mp.play();
        
		for(int i = 0; i < party.length; i++)
		{
			Battle.trainerBattle(player, party[i]);
			if(player.hasValidPokemon() == false)
			{
				mp.stop();
				AlertBox.displayNoTitle("You have lost to Elite Four Drake. Click OK to end your game!", "OK");
				break;
			}
			
			else
			{				
				if(i == 5)
				{
					AlertBox.displayNoTitle("You beat Elite Four Drake!", "OK");
					mp.stop();
					path = GameRunner.class.getResource("/DefeatEliteFour.mp3").toString();
			        media = new Media(path);
			        mp = new MediaPlayer(media);
			        mp.play();		        
			        
				}
				if(i < party.length - 1)
				{
					Alert newPokemonAlert = new Alert(AlertType.CONFIRMATION);
					newPokemonAlert.setTitle("Confirmation Dialog");
					newPokemonAlert.setHeaderText("Elite Four Drake is about to send out " + party[i+1].getName());
					newPokemonAlert.setContentText("Would you like to switch Pokemon?");

					Optional<ButtonType> result = newPokemonAlert.showAndWait();
					if (result.get() == ButtonType.OK)
						switchPokemon();
					else 
						newPokemonAlert.close();
				}
			}	
		}
	}	
	
	/**
	 * Sets the screen to switch Pokemon
	 */
	private static void switchPokemon()
	{
		final Stage primaryStage = new Stage();
		primaryStage.setTitle("Switch");
		
		Button goBackButtonSwitch = new Button();
        goBackButtonSwitch.setText("Go Back");
        goBackButtonSwitch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	primaryStage.close();
            }
        });
		
        Button switch1Button = new Button();
        if(playerParty[0] != null)
        	switch1Button.setText(playerParty[0].toString());
        else
        	switch1Button.setText("Null");
        switch1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                player.setFirst(0);
                primaryStage.close();
            }
        });
        
        Button switch2Button = new Button();
        if(playerParty[1] != null)
        	switch2Button.setText(playerParty[1].toString());
        else
        	switch2Button.setText("Null");
        switch2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                player.setFirst(1);
                primaryStage.close();
            }
        });
        
        Button switch3Button = new Button();
        if(playerParty[2] != null)
        	switch3Button.setText(playerParty[2].toString());
        else
        	switch3Button.setText("Null");
        switch3Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                player.setFirst(2);
                primaryStage.close();
            }
        });
        
        Button switch4Button = new Button();
        if(playerParty[3] != null)
        	switch4Button.setText(playerParty[3].toString());
        else
        	switch4Button.setText("Null");
        switch4Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                player.setFirst(3);
                primaryStage.close();
            }
        });
        
        Button switch5Button = new Button();
        if(playerParty[4] != null)
        	switch5Button.setText(playerParty[4].toString());
        else
        	switch5Button.setText("Null");
        switch5Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                player.setFirst(4);
                primaryStage.close();
            }
        });
        
        Button switch6Button = new Button();
        if(playerParty[5] != null)
        	switch6Button.setText(playerParty[5].toString());
        else
        	switch6Button.setText("Null");
        switch6Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                player.setFirst(5);
                primaryStage.close();
            }
        });
        
        for(int i = 0; i < playerParty.length; i++)
        	if(playerParty[i] == null || playerParty[i].getCurrentHealth() <= 0)
        		if(i == 0)
        			switch1Button.setDisable(true);
        		else if(i == 1)
        			switch2Button.setDisable(true);
        		else if(i == 2)
        			switch3Button.setDisable(true);
        		else if(i == 3)
        			switch4Button.setDisable(true);
        		else if(i == 4)
        			switch5Button.setDisable(true);
        		else
        			switch6Button.setDisable(true);
        	

        HBox switchLayoutBack = new HBox();
        switchLayoutBack.getChildren().addAll(goBackButtonSwitch);
        switchLayoutBack.setAlignment(Pos.TOP_LEFT);
        
        HBox switchLayoutContent = new HBox();
        switchLayoutContent.getChildren().addAll(switch1Button, switch2Button, switch3Button, switch4Button, switch5Button, switch6Button);
        switchLayoutContent.setAlignment(Pos.CENTER);
        
         HBox switchLayout = new HBox();
         
        switchLayout.getChildren().addAll(switchLayoutBack, switchLayoutContent);
        Scene switchScene = new Scene(switchLayout, 800,200);
        primaryStage.setScene(switchScene);
        primaryStage.showAndWait();
	}
	
	/**
	 * Returns null for the color so the gif isn't distorted
	 */
	public Color getColor()
	{
		return null;
	}
}
