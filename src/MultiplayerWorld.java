import java.util.ArrayList;
import info.gridworld.actor.ActorWorld;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * World to run a multiplayer battle
 * @author Andrew
 *
 */
public class MultiplayerWorld extends ActorWorld
{
	private static Player player1;
	private static Player player2;
	
	/**
	 * creates a MultiplayerWorld for two players to select their names and Pokemon as well as the Moves for the selected Pokemon. Afterwards
	 * a battle between the two players will begin
	 */
    public MultiplayerWorld() 
    {
    	String name = AlertBox.displayChoice("What's the name of player 1?", "OK");
		boolean nameBoolean = AlertBox.confirm("So it's " + name + "?");
		while(nameBoolean == false)
		{
			AlertBox.displayNoTitle("Oh I must've misheard.", "OK");
			name = AlertBox.displayChoice("What's the name of player 1?", "OK");
			nameBoolean = AlertBox.confirm("So it's " + name + "?");
		}
    	player1 = new Player(name);
    	
    	String name2 = AlertBox.displayChoice("What's the name of player 2?", "OK");
		boolean nameBoolean2 = AlertBox.confirm("So it's " + name2 + "?");
		while(nameBoolean2 == false)
		{
			AlertBox.displayNoTitle("Oh I must've misheard.", "OK");
			name2 = AlertBox.displayChoice("What's the name of player 2?", "OK");
			nameBoolean2 = AlertBox.confirm("So it's " + name2 + "?");
		}
    	player2 = new Player(name2);
    	
    	
    	for(int i  = 0; i < 6; i++)
    	{
    		pickPokemon(player1);
    		for(int j = 0; j < 4; j++)
    			pickMoves(player1.getParty()[i]);
    	}
    		
    	for(int i  = 0; i < 6; i++)
    	{
    		pickPokemon(player1);
    		for(int j = 0; j < 4; j++)
    			pickMoves(player1.getParty()[i]);
    	}
    	
    	Multiplayer.battle(player1, player2);
    }	
    
    private void pickPokemon(final Player player)
    {
    	final Stage dexStage = new Stage();
    	dexStage.setTitle("PokeDex");
    	dexStage.initModality(Modality.APPLICATION_MODAL);
    	dexStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	        public void handle(WindowEvent ev) {
	                ev.consume();
	        }
	    });
    	
    	GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        grid.setHgap(5);
        grid.setVgap(5);
        
        Pokemon[] pokemon = player.getPokeDex().getEntries();
        int index = 0;
        for (int r = 1; r < 100; r++) {
            for (int c = 0; c < 6; c++) {
            	if(index < pokemon.length)
            	{
            		Button button = new Button(pokemon[index].toString() + "\nAttack: " + pokemon[index].getAttack() + "\nDefense: " + pokemon[index].getDefense());
            		button.setMaxSize(150,150);
            		final Pokemon p = pokemon[index];
            		button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                        	AlertBox.displayNoTitle("You picked " + p.getName(), "OK");
    	            		player.catchPokemon(p);
    	            		dexStage.close();
                        }
                    });
            		grid.add(button, c, r);
            		index++;
            	}
                
            }
        }
		
        ScrollPane pcLayout = new ScrollPane(grid);
        Scene pcScene = new Scene(pcLayout, 750, 500);
        dexStage.setScene(pcScene);
        dexStage.showAndWait();         
    }
    
    private void pickMoves(final Pokemon poke)
    {
    	final Stage moveStage = new Stage();
    	moveStage.setTitle("PokeDex");
    	moveStage.initModality(Modality.APPLICATION_MODAL);
    	moveStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	        public void handle(WindowEvent ev) {
	                ev.consume();
	        }
	    });
    	
    	GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        grid.setHgap(5);
        grid.setVgap(5);
        
        ArrayList<Move> moves = Move.getAllMoves();
        int index = 0;
        for (int r = 1; r < 100; r++) {
            for (int c = 0; c < 4; c++) {
            	if(index < moves.size())
            	{
            		Button button = new Button(moves.get(index).toString());
            		button.setMaxSize(150,150);
            		final Move m = moves.get(index);
            		button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                        	boolean confirm = AlertBox.confirm("Are you sure you want " + poke.getName() + " to learn " + m.getMoveName() + "?");
        	            	if(confirm)
        	            	{
        	            		poke.learnMove(m);
        	            		moveStage.close();
        	            	}
                        }
                    });
            		
            		if(m.getType().equals(Type.BUG))
            			button.setStyle("-fx-background-color: #A8B820; -fx-text-fill: black;");
            		if(m.getType().equals(Type.DARK))
            			button.setStyle("-fx-background-color: #705848; -fx-text-fill: white;");
            		if(m.getType().equals(Type.DRAGON))
            			button.setStyle("-fx-background-color: #7038F8; -fx-text-fill: white;");
            		if(m.getType().equals(Type.ELECTRIC))
            			button.setStyle("-fx-background-color: #F8D030; -fx-text-fill: black;");
            		if(m.getType().equals(Type.FIGHTING))
            			button.setStyle("-fx-background-color: #C03028; -fx-text-fill: white;");
            		if(m.getType().equals(Type.FIRE))
            			button.setStyle("-fx-background-color: #F08030; -fx-text-fill: white;");
            		if(m.getType().equals(Type.FLYING))
            			button.setStyle("-fx-background-color: #A890F0; -fx-text-fill: white;");
            		if(m.getType().equals(Type.GHOST))
            			button.setStyle("-fx-background-color: #705898; -fx-text-fill: white;");
            		if(m.getType().equals(Type.GRASS))
            			button.setStyle("-fx-background-color: #78C850; -fx-text-fill: white;");
            		if(m.getType().equals(Type.GROUND))
            			button.setStyle("-fx-background-color: #E0C068; -fx-text-fill: white;");
            		if(m.getType().equals(Type.ICE))
            			button.setStyle("-fx-background-color: #98D8D8; -fx-text-fill: white;");
            		if(m.getType().equals(Type.NORMAL))
            			button.setStyle("-fx-background-color: #A8A878; -fx-text-fill: black;");
            		if(m.getType().equals(Type.POISON))
            			button.setStyle("-fx-background-color: #A040A0; -fx-text-fill: white;");
            		if(m.getType().equals(Type.PSYCHIC))
            			button.setStyle("-fx-background-color: #F85888; -fx-text-fill: white;");
            		if(m.getType().equals(Type.ROCK))
            			button.setStyle("-fx-background-color: #B8A038; -fx-text-fill: white;");
            		if(m.getType().equals(Type.STEEL))
            			button.setStyle("-fx-background-color: #B8B8D0; -fx-text-fill: white;");
            		if(m.getType().equals(Type.WATER))
            			button.setStyle("-fx-background-color: #6890F0; -fx-text-fill: white;");
            		grid.add(button, c, r);
            		index++;
            	}
                
            }
        }
		
        ScrollPane pcLayout = new ScrollPane(grid);
        Scene pcScene = new Scene(pcLayout, 650, 500);
        moveStage.setScene(pcScene);
        moveStage.showAndWait();        
    }
}