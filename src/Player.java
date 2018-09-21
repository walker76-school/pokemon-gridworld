import info.gridworld.actor.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.awt.Color;
import java.util.*;

/**
 * Player which has a pokemon party to battle with
 * @author Andrew
 *
 */
public class Player extends Actor
{
    private static String name;
    private static Pokemon[] party;
    private static ArrayList<Pokemon> pc;
    private static PokeDex pokeDex;
	private static int pokeDexCount;	
	private static Stage primaryStage;	
	private String suffix;
    
    /**
     * constructs a default player
     */
    public Player() 
    {
    	name = "Default";
    	pokeDexCount = 0;
    	party = new Pokemon[6];
    	pc = new ArrayList<Pokemon>();
    	pokeDex = new PokeDex();
    	suffix = "";
    }
    
    /**
     * constructs a player with a specified name
     * @param aName the name of the player
     */
    public Player(String aName) 
    {
    	name = aName;
    	pokeDexCount = 0;
    	party = new Pokemon[6];
    	pc = new ArrayList<Pokemon>();
    	pokeDex = new PokeDex();
    	suffix = "";
    }
    
    /**
     * heals all Pokemon in the player's party
     */
    public void heal()
    {
    	for(Pokemon p : party)
    		p.setCurrentHealth(Math.abs(p.getTotalHealth()));
    }
    
    /**
     * tests if the player has any Pokemon with HP above 0
     * @return if the player has any Pokemon with HP above 0
     */
    public boolean hasValidPokemon()
    {
    	for(Pokemon p : party)
    		if(p != null && p.getCurrentHealth() > 0)
    			return true;
    	return false;
    	
    }
    
    /**
     * switches the first Pokemon with the Pokemon at a specified index
     * @param index the index to switch with
     */
    public void setFirst(int index)
    {
    	if(index < party.length)
    	{
    		Pokemon temp = party[0];
    		party[0] = party[index];
    		party[index] = temp;
    	}
    }
    
    /**
     * returns the extra Pokemon a player has caught that are not in their party
     * @return the extra Pokemon a player has caught that are not in their party
     */
    public ArrayList<Pokemon> getPC()
    {
    	return pc;
    }
    
    /**
     * returns the player's party
     * @return the player's party
     */
    public Pokemon[] getParty()
    {
    	return party;
    }
    
    /**
     * returns the player's name
     * @return the player's name
     */
    public String getName()
    {
    	return name;
    }
    
    public int getPokeDexCount()
    {
    	return pokeDexCount;
    }
    
    /**
     * returns the player's PokeDex
     * @return the player's PokeDex
     */
    public PokeDex getPokeDex()
    {
    	return pokeDex;
    }
    
    /**
     * adds a Pokemon to the player's party, if the arty is full it is added to the player's PC
     * @param p the Pokemon to add to the player's party
     * @return if the Pokemon is added to the party or not
     */
    public boolean catchPokemon(Pokemon p)
    {
    	seePokemon(p);
    	for(int i = 0; i < party.length; i++)
			if(party[i] == null)
			{
				party[i] = p;
				return true;
			}		
		pc.add(0, p);
		return false;
    }
    
    /**
     * add's the Pokemon to the player's PokeDex's seen Pokemon list and raises the player's pokeDexCount if the Pokemon
     * hasn't been seen before
     * @param p the Pokemon to see
     */
    public void seePokemon(Pokemon p)
    {
    	boolean newPokemon = pokeDex.see(p);
    	if(newPokemon)
    		pokeDexCount++;
    }
    
    /**
     * adds a Pokemon to the player's PC
     * @param p the Pokemon to add to the player's PC
     */
    public void depositPokemon(Pokemon p)
    {
    	pc.add(p);
    }
    
    /**
     * shows the menu for the player which includes the PokeDex, Party, Trainer Card, Bag, and Save
     */
    public void showMenu()
    {
    	primaryStage = new Stage();
    	primaryStage.setTitle("Menu");
    	primaryStage.initModality(Modality.APPLICATION_MODAL);
    	Platform.setImplicitExit(false);
    	
    	Label title = new Label("Menu: \n\n");
    	
    	Button pokedexButton = new Button("PokeDex");
    	pokedexButton.setMaxWidth(70);
    	pokedexButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            		showPokeDex();
            }
        });
    	
    	Button pokemonButton = new Button("Pokemon");
    	pokemonButton.setMaxWidth(70);
    	pokemonButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            		showParty();
            }
        });
    	
    	Button trainerCardButton = new Button(name);
    	trainerCardButton.setMaxWidth(70);
    	trainerCardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            		showTrainerCard();
            }
        });
    	
    	Button saveButton = new Button("Save");
    	saveButton.setMaxWidth(70);
    	saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            		
            }
        });
    	
    	Button exitButton = new Button("Exit");
    	exitButton.setMaxWidth(70);
    	exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            		primaryStage.close();
            }
        });
        
        VBox menuLayout = new VBox();
        menuLayout.getChildren().addAll(title, pokedexButton, pokemonButton, trainerCardButton, saveButton, exitButton);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.setPadding(new Insets(10,20,10,20));
        
        Scene menuScene = new Scene(menuLayout, 100,200);
        primaryStage.setScene(menuScene);
        primaryStage.showAndWait();
    }
    
    /**
     * shows the Trainer Card information which includes their name and PokeDex count
     */
    private void showTrainerCard() 
    {
    	Stage trainerStage = new Stage();
    	trainerStage.setTitle("Trainer Card");
    	trainerStage.initModality(Modality.APPLICATION_MODAL);
    	
    	Label trainerLabel = new Label(toString());
    	HBox trainerLayout = new HBox();
    	trainerLayout.getChildren().add(trainerLabel);
    	trainerLayout.setPadding(new Insets(10,20,10,20));
    	
    	Scene trainerScene = new Scene(trainerLayout, 250,100);
    	trainerStage.setScene(trainerScene);
    	trainerStage.showAndWait();
	}

    /**
     * displays all seen Pokemon
     */
    public void showPokeDex() 
    {
    	final Stage dexStage = new Stage();
    	dexStage.setTitle("PokeDex");
    	dexStage.initModality(Modality.APPLICATION_MODAL);
    	
    	Button exitButtonDex = new Button("Exit");
    	exitButtonDex.setMaxWidth(70);
    	exitButtonDex.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	dexStage.close();
            }
        });
    	
		VBox pokeDexLayout = new VBox();
		pokeDexLayout.setAlignment(Pos.CENTER);
		pokeDexLayout.getChildren().add(exitButtonDex);
		pokeDexLayout.setPadding(new Insets(10,20,10,20));

    	for(final Pokemon p : pokeDex.getEntries())
		{
			if(pokeDex.checkSeen(p))
			{
				Button button = new Button(p.getID() + " " + p.getName());
				button.setMaxWidth(100);
				button.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	detailedPokeDex(p);
		            }
		        });
				pokeDexLayout.getChildren().add(button);
			}
			else
			{
				Button button = new Button(p.getID() + " Unknown");
				button.setMaxWidth(100);
				button.setDisable(true);
				pokeDexLayout.getChildren().add(button);
			}
		}
    	ScrollPane pokeDexScroll = new ScrollPane(pokeDexLayout);
    	
		Scene pokeDexScene = new Scene(pokeDexScroll, 200,250);
		dexStage.setScene(pokeDexScene);
		dexStage.showAndWait();	
	}

    /**
     * shows detailed information about a specific Pokemon
     * @param p the Pokemon who's information is displayed
     */
	protected void detailedPokeDex(Pokemon p) {
		Stage detailed = new Stage();
    	detailed.setTitle("Detail");
    	detailed.initModality(Modality.APPLICATION_MODAL);
    	
    	HBox detailLayoutTop = new HBox();
    	Label title = new Label("Detailed View: ");
    	detailLayoutTop.getChildren().addAll(title);
    	detailLayoutTop.setAlignment(Pos.CENTER);
    	detailLayoutTop.setPadding(new Insets(0,20,0,20));
    	
    	HBox detailLayoutMid = new HBox();
    	ImageView iv1 = new ImageView(p.getImage());
    	Label info = new Label("PokeDex Number: " + p.getID() + "\nName: " + p.getName());
    	detailLayoutMid.getChildren().addAll(iv1, info);
    	detailLayoutMid.setSpacing(20);
    	detailLayoutMid.setAlignment(Pos.CENTER);
    	detailLayoutMid.setPadding(new Insets(0,20,0,20));
    	
    	HBox detailLayoutBottom = new HBox();
    	Label des = new Label(p.getDescription());
    	detailLayoutBottom.getChildren().addAll(des);
    	detailLayoutBottom.setSpacing(20);
    	detailLayoutBottom.setAlignment(Pos.CENTER);
    	detailLayoutBottom.setPadding(new Insets(0,20,0,20));
    	
    	VBox detailLayout = new VBox();
    	detailLayout.getChildren().addAll(detailLayoutTop, detailLayoutMid, detailLayoutBottom);
    	detailLayout.setAlignment(Pos.CENTER);
    	detailLayout.setPadding(new Insets(0,20,0,20));
    	
    	Scene detailedScene = new Scene(detailLayout, 400,200);
    	detailed.setScene(detailedScene);
    	detailed.showAndWait();
		
	}

	/**
	 * shows the player's party
	 */
	private void showParty()
    {
    	final Stage partyStage = new Stage();
    	partyStage.setTitle("Party");
    	partyStage.initModality(Modality.APPLICATION_MODAL);
		
    	Button exitButtonParty = new Button("Exit");
    	exitButtonParty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	partyStage.close();
            }
        });
    	
		Button party1Button = new Button();
		if(party[0] != null)
			party1Button.setText(party[0].toString());
		party1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	detailedView(party[0]);
            }
        });
        
		Button party2Button = new Button();
		if(party[1] != null)
			party2Button.setText(party[1].toString());
		party2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	detailedView(party[1]);
            }
        });
        
		Button party3Button = new Button();
		if(party[2] != null)
			party3Button.setText(party[2].toString());
		party3Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	detailedView(party[2]);
            }
        });
        
		Button party4Button = new Button();
		if(party[3] != null)
			party4Button.setText(party[3].toString());
		party4Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	detailedView(party[3]);
            }
        });
        
		Button party5Button = new Button();
		if(party[4] != null)
			party5Button.setText(party[4].toString());
		party5Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	detailedView(party[4]);
            }
        });
        
		Button party6Button = new Button();
		if(party[5] != null)
			party6Button.setText(party[5].toString());
		party6Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	detailedView(party[5]);
            }
        });
		
		HBox partyLayoutContent = new HBox();
		partyLayoutContent.setAlignment(Pos.CENTER);
		
        for(int i = 0; i < party.length; i++)
        	if(party[i] != null)
        		if(i == 0)
        			partyLayoutContent.getChildren().add(party1Button);
        		else if(i == 1)
        			partyLayoutContent.getChildren().add(party2Button);
        		else if(i == 2)
        			partyLayoutContent.getChildren().add(party3Button);
        		else if(i == 3)
        			partyLayoutContent.getChildren().add(party4Button);
        		else if(i == 4)
        			partyLayoutContent.getChildren().add(party5Button);
        		else
        			partyLayoutContent.getChildren().add(party6Button);
        
        HBox exitLayout = new HBox();
        exitLayout.getChildren().add(exitButtonParty);
        exitLayout.setAlignment(Pos.CENTER);
        
        VBox partyLayout = new VBox();
        partyLayout.getChildren().addAll(exitLayout, partyLayoutContent);
        
        Scene depositScene = new Scene(partyLayout, 600,100);
        partyStage.setScene(depositScene);
        partyStage.showAndWait();
    }
    
	/**
	 * displays information about a speciifc Pokemon in the party including name, HP, and moves
	 * @param p the Pokemon who's information is being displayed
	 */
    private void detailedView(Pokemon p)
    {
    	Stage detailed = new Stage();
    	detailed.setTitle("Detail");
    	detailed.initModality(Modality.APPLICATION_MODAL);
    	
    	VBox detailLayout = new VBox();
    	
    	ImageView iv1 = new ImageView();
        iv1.setImage(p.getImage());
    	
    	Label pokemonLabel = new Label(p.toString() + "\n" + p.moveString());
    	Label title = new Label("Detailed View: ");
    	detailLayout.getChildren().addAll(title, iv1, pokemonLabel);
    	detailLayout.setAlignment(Pos.CENTER);
    	detailLayout.setPadding(new Insets(0,20,0,20));
    	
    	Scene detailedScene = new Scene(detailLayout, 200,300);
    	detailed.setScene(detailedScene);
    	detailed.showAndWait();
    }
    
    /**
     * deletes a Pokemon from the party at a specific index
     * @param index the index of the Pokemon to be deleted
     */
    public void removePartyPokemon(int index)
    {
    	party[index] = null;
    }
    
    /**
     * deletes a Pokemon from the PC at a specific index
     * @param index the index of the Pokemon to be deleted
     */
    public void removePCPokemon(int index)
    {
    	pc.remove(index);
    }
    
    /**
     * returns a string version of the Player
     * @return a string version of the Player
     */
    public String toString()
    {
    	String ret = "";
    	ret += "Name: " + name;
    	ret += "\nPokeDex: " + pokeDexCount + "/202";
    	return ret;
    }
    
    /**
	 * returns null for the color so the gif isn't distorted
	 * @return the color of the gif
	 */
    public Color getColor()
	{
		return null;
	}
    
    public void setSuffix(String suffix)
    {
    	this.suffix = suffix;
    }
    
    public String getImageSuffix()
    {
    	return suffix;
    }
}