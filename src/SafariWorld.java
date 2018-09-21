import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import info.gridworld.actor.*;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Class to build a grass world and start the Safari encounters
 * @author Andrew
 *
 */
public class SafariWorld extends ActorWorld
{
	private static Player player;
	private static MediaPlayer mp;
	private static Stopwatch stop;
	
	/**
	 * creates a new SafariWorld
	 */
    public SafariWorld() 
    {
    	super(new BoundedGrid<Actor>(12,14));
    	stop = new Stopwatch();
    	boolean loadBoolean = AlertBox.confirm("Do you want to load a saved file?");
    	if(loadBoolean)
    		load();
    	else
    	{
    		String name = AlertBox.displayChoice("What's your name?", "OK");
    		boolean nameBoolean = AlertBox.confirm("So it's " + name + "?");
			while(nameBoolean == false)
			{
				AlertBox.displayNoTitle("Oh I must've misheard.", "OK");
				name = AlertBox.displayChoice("What's your name?", "OK");
				nameBoolean = AlertBox.confirm("So it's " + name + "?");
			}
    	player = new Player(name);
    	}
    	
    	
    	grassWorld();
    	add(new Location(7,6), player);  
    	
		System.setProperty("info.gridworld.gui.selection", "hide");
		System.setProperty("info.gridworld.gui.tooltips", "hide");
		System.setProperty("info.gridworld.gui.frametitle", "Pokemon");
		
		String path = GameRunner.class.getResource("/Route101.mp3").toString();
        Media media = new Media(path);
        mp = new MediaPlayer(media);
        mp.setCycleCount(MediaPlayer.INDEFINITE);
        mp.setVolume(0.1);
        mp.play();
        
		show();
    }
	
    /**
     * returns true to override the Gridworld locationClicked
     */
	@Override
    public boolean locationClicked(Location loc)
    {
    	return true;
    }

	/**
	 * Overrides the Gridworld keyPressed method. It moves the player and does other functions based on the key
	 * pressed
	 */
	@Override
	public boolean keyPressed(String description, Location loc)
    {
    	if (description.equals("UP") && getGrid().isValid(player.getLocation().getAdjacentLocation(Location.NORTH)))
    	{	
    		player.setSuffix("_back");
    		final Location move = player.getLocation().getAdjacentLocation(Location.NORTH);
    		Location replace = player.getLocation();
    		if(getGrid().get(move) instanceof Tree)
    			return true;
    		if(getGrid().get(move) instanceof Grass)
    			if(((Grass)getGrid().get(move)).getPokeBoolean())
    			{
    				mp.pause();
    				final Grass grass = (Grass)getGrid().get(move);
    				Platform.runLater(new Runnable() { 
    		            @Override
    		            public void run() {
    		            	Safari.encounter(player, grass.getPokemon()); 
    		            	mp.play();
    		            }
    		        });
    			}
    		if(player.getPokeDexCount() == 202)
    		{
    			frame.dispose();
    			AlertBox.displayNoTitle("You've caught all the Pokemon!", "OK");
    			boolean efChoice = AlertBox.confirm("Would you like to battle the Elite Four?");
    			if(efChoice)
            		new EliteFourWorld();  
    		}
    			
    		player.moveTo(player.getLocation().getAdjacentLocation(Location.NORTH));
        	add(replace, new Grass());
        	return true;    		
    	}
    	if (description.equals("LEFT") && getGrid().isValid(player.getLocation().getAdjacentLocation(Location.WEST)))
    	{	
    		player.setSuffix("_left");
    		final Location move = player.getLocation().getAdjacentLocation(Location.WEST);
    		Location replace = player.getLocation();
    		if(getGrid().get(move) instanceof Tree)
    			return true;
    		if(getGrid().get(move) instanceof Grass)
    			if(((Grass)getGrid().get(move)).getPokeBoolean())
    			{
    				mp.pause();
    				final Grass grass = (Grass)getGrid().get(move);
    				Platform.runLater(new Runnable() { 
    		            @Override
    		            public void run() {
    		            	Safari.encounter(player, grass.getPokemon()); 
    		            	mp.play();
    		            }
    		        });
    			}
    		if(player.getPokeDexCount() == 202)
    		{
    			frame.dispose();
    			AlertBox.displayNoTitle("You've caught all the Pokemon!", "OK");
    			AlertBox.displayNoTitle("It took you " + stop.format() + "!", "OK");
    			boolean efChoice = AlertBox.confirm("Would you like to battle the Elite Four?");
    			if(efChoice)
            		new EliteFourWorld();  
    		}
    		
    		player.moveTo(player.getLocation().getAdjacentLocation(Location.WEST));
        	add(replace, new Grass());
        	return true;    		
		}
    	if (description.equals("DOWN") && getGrid().isValid(player.getLocation().getAdjacentLocation(Location.SOUTH)))
    	{
    		player.setSuffix("_front");
    		final Location move = player.getLocation().getAdjacentLocation(Location.SOUTH);
    		Location replace = player.getLocation();
    		if(getGrid().get(move) instanceof Tree)
    			return true;
    		if(getGrid().get(move) instanceof Grass)
    			if(((Grass)getGrid().get(move)).getPokeBoolean())
    			{
    				mp.pause();
    				final Grass grass = (Grass)getGrid().get(move);
    				Platform.runLater(new Runnable() { 
    		            @Override
    		            public void run() {
    		            	Safari.encounter(player, grass.getPokemon());
    		            	mp.play();
    		            }
    		        });
    			}
    		if(player.getPokeDexCount() == 202)
    		{
    			frame.dispose();
    			AlertBox.displayNoTitle("You've caught all the Pokemon!", "OK");
    			boolean efChoice = AlertBox.confirm("Would you like to battle the Elite Four?");
    			if(efChoice)
            		new EliteFourWorld();  
    		}
    		
    		player.moveTo(player.getLocation().getAdjacentLocation(Location.SOUTH));
        	add(replace, new Grass());
        	return true;
    	}
    	if (description.equals("RIGHT") && getGrid().isValid(player.getLocation().getAdjacentLocation(Location.EAST)))
    	{
    		player.setSuffix("_right");
    		final Location move = player.getLocation().getAdjacentLocation(Location.EAST);
    		Location replace = player.getLocation();
    		if(getGrid().get(move) instanceof Tree)
    			return true;
    		if(getGrid().get(move) instanceof Grass)
    			if(((Grass)getGrid().get(move)).getPokeBoolean())
    			{
    				mp.pause();
    				final Grass grass = (Grass)getGrid().get(move);
    				Platform.runLater(new Runnable() { 
    		            @Override
    		            public void run() {
    		            	Safari.encounter(player, grass.getPokemon()); 
    		            	mp.play();
    		            }
    		        });
    			}
    		if(player.getPokeDexCount() == 202)
    		{
    			frame.dispose();
    			AlertBox.displayNoTitle("You've caught all the Pokemon!", "OK");
    			boolean efChoice = AlertBox.confirm("Would you like to battle the Elite Four?");
    			if(efChoice)
            		new EliteFourWorld();  
    		}
    		
    		player.moveTo(player.getLocation().getAdjacentLocation(Location.EAST));
        	add(replace, new Grass());
        	return true;
    	}
    	
    	if (description.toUpperCase().equals("P"))
    	{	
    		Platform.runLater(new Runnable() { 
	            @Override
	            public void run() {
	            	player.showPokeDex(); 
	            }
	        });
        	return true;    		
    	}
    	
    	if (description.toUpperCase().equals("S"))
    	{	
    		Platform.runLater(new Runnable() { 
	            @Override
	            public void run() {  
	            	try {save();} 
	            	catch (FileNotFoundException e) {}
	            }
	        });
        	return true;    		
    	}
    	
    	return false;
    }
    
	/**
	 * creates all of the grass and tree border when you first load the world
	 */
    public void grassWorld()
    {
    	
    	for(int row = 0; row < 12; row++)
    		for(int col = 0; col < 14; col++)
    			add(new Location(row,col), new Grass());
    	//Row 0
    	add(new Location(0,0), new Tree());
    	add(new Location(0,1), new Tree());
    	add(new Location(0,2), new Tree());
    	add(new Location(0,3), new Tree());
    	add(new Location(0,4), new Tree());
    	add(new Location(0,5), new Tree());
    	add(new Location(0,6), new Tree());
    	add(new Location(0,7), new Tree());
    	add(new Location(0,8), new Tree());
    	add(new Location(0,9), new Tree());
    	add(new Location(0,10), new Tree());
    	add(new Location(0,11), new Tree());
    	add(new Location(0,12), new Tree());
    	add(new Location(0,13), new Tree());

    	//Row 1
    	add(new Location(1,0), new Tree());
    	add(new Location(1,1), new Tree());
    	add(new Location(1,2), new Tree());
    	add(new Location(1,11), new Tree());
    	add(new Location(1,12), new Tree());
    	add(new Location(1,13), new Tree());
    	
    	//Row 2
    	add(new Location(2,0), new Tree());
    	add(new Location(2,1), new Tree());
    	add(new Location(2,12), new Tree());
    	add(new Location(2,13), new Tree());
    	
    	//Row 3
    	add(new Location(3,0), new Tree());
    	add(new Location(3,1), new Tree());
    	add(new Location(3,12), new Tree());
    	add(new Location(3,13), new Tree());
    	
    	//Row 4
    	add(new Location(4,0), new Tree());
    	add(new Location(4,1), new Tree());
    	add(new Location(4,12), new Tree());
    	add(new Location(4,13), new Tree());
    	
    	//Row 5
    	add(new Location(5,0), new Tree());
    	add(new Location(5,1), new Tree());
    	add(new Location(5,12), new Tree());
    	add(new Location(5,13), new Tree());
    	
    	//Row 6
    	add(new Location(6,0), new Tree());
    	add(new Location(6,1), new Tree());
    	add(new Location(6,12), new Tree());
    	add(new Location(6,13), new Tree());
    	
    	//Row 7
    	add(new Location(7,0), new Tree());
    	add(new Location(7,1), new Tree());
    	add(new Location(7,12), new Tree());
    	add(new Location(7,13), new Tree());
    	
    	//Row 8
    	add(new Location(8,0), new Tree());
    	add(new Location(8,1), new Tree());
    	add(new Location(8,12), new Tree());
    	add(new Location(8,13), new Tree());
    	
    	//Row 9
    	add(new Location(9,0), new Tree());
    	add(new Location(9,1), new Tree());
    	add(new Location(9,12), new Tree());
    	add(new Location(9,13), new Tree());
    	
    	//Row 10
    	add(new Location(10,0), new Tree());
    	add(new Location(10,1), new Tree());
    	add(new Location(10,2), new Tree());
    	add(new Location(10,11), new Tree());
    	add(new Location(10,12), new Tree());
    	add(new Location(10,13), new Tree());
    	
    	//Row 11
    	add(new Location(11,0), new Tree());
    	add(new Location(11,1), new Tree());
    	add(new Location(11,2), new Tree());
    	add(new Location(11,3), new Tree());
    	add(new Location(11,4), new Tree());
    	add(new Location(11,5), new Tree());
    	add(new Location(11,6), new Tree());
    	add(new Location(11,7), new Tree());
    	add(new Location(11,8), new Tree());
    	add(new Location(11,9), new Tree());
    	add(new Location(11,10), new Tree());
    	add(new Location(11,11), new Tree());
    	add(new Location(11,12), new Tree());
    	add(new Location(11,13), new Tree());
    }
    
    /**
     * saves the game. Saves the player's name and Pokemon caught
     * @throws FileNotFoundException if no output text
     */
    public static void save() throws FileNotFoundException
    {    	
    	boolean confirm = AlertBox.confirm("Would you like to save your game?");
    	if(confirm)
    	{
    		PrintWriter write = new PrintWriter("output.txt");
			write.println(player.getName());
			for(boolean b : PokeDex.getSeen())
				write.println(b);
			write.close();
			AlertBox.displayNoTitle("Your game has been saved", "OK");
    	}    	
    }
    
    /**
     * loads in a saved file. Loads the player's name and Pokemon caught
     */
    public void load()
    {
    	boolean[] temp = new boolean[202];
    	int index = 0;
    	try
		{
			Scanner in = new Scanner(new FileReader("output.txt"));
			String name = in.nextLine();
			player = new Player(name);			
			while (in.hasNextLine())
			{
				String bool = in.nextLine();
				if(bool.equals("true"))
					temp[index] = true;
				if(bool.equals("false"))
					temp[index] = false;
				index++;
			}
			in.close();
		}
		catch(FileNotFoundException exception){}
    	player.getPokeDex().setSeen(temp);
    }
}