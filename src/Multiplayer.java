import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Class to handle Multiplayer battles
 * @author Andrew
 *
 */
public abstract class Multiplayer {
	private static Stage primaryStage;

	private static Player player1;
	private static Player player2;
	
	private static Pokemon current;
	private static Pokemon opponent;
	
	private static Pokemon[] party;
	private static Pokemon[] party2;
	
	private static Move[] currentMoves;
	private static Move[] opponentMoves;
	
	private static boolean canExit;
	
	private static MediaPlayer mp;
	
	/**
	 * Creates a battle with another trainer, you cannot run away
	 * @param p the trainer to battle with
	 * @param o the pokemon to battle against
	 */
	public static void battle(Player p, Player o)
	{
		player1 = p;
		player2 = o;
		
		party = player1.getParty();
		current = player1.getParty()[0];
		
		party2 = player2.getParty();
		opponent = player2.getParty()[0];
		
		currentMoves = current.getMoves();
		opponentMoves = opponent.getMoves();
		
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
		setMainScene1();
		Platform.setImplicitExit(false);
		primaryStage.showAndWait();
	}
	
	/**
	 * Creates the main option screen with Attack, Switch, Bag and Run buttons
	 */
	private static void setMainScene1()
	{
		primaryStage.setTitle("Battle");
		
       	Label opponentPokemon = new Label(opponent.getName() + "\n" + opponent.getCurrentHealth() + "/" + opponent.getTotalHealth()); 
        Label currentPokemon =  new Label(current.getName() + "\n" + current.getCurrentHealth() + "/" + current.getTotalHealth()); 
        
        ImageView iv1 = new ImageView();
        iv1.setImage(current.getImage());
        
        ImageView iv2 = new ImageView();
        iv2.setImage(opponent.getImage());
        
        Button attackButton = new Button();
        attackButton.setText("Attack");
        attackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	setAttackScreen1();
            	
            }
        });
        
        Button switchButton = new Button();
        switchButton.setText("Switch");
        switchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	setSwitchScreen1();
            	
            }
        });
        
        VBox mainLayout = new VBox();
        mainLayout.setSpacing(10);
        
        HBox mainLayoutTop = new HBox();
        mainLayoutTop.getChildren().addAll(iv1, currentPokemon, opponentPokemon, iv2);
        mainLayoutTop.setSpacing(40);
        mainLayoutTop.setAlignment(Pos.CENTER);
        
        HBox mainLayoutBottom = new HBox();
        mainLayoutBottom.getChildren().addAll(attackButton, switchButton);
        mainLayoutBottom.setAlignment(Pos.CENTER);
        mainLayoutBottom.setSpacing(40);
        
        mainLayout.getChildren().addAll(mainLayoutTop, mainLayoutBottom);
        
        Scene mainScene = new Scene(mainLayout, 500, 150);
        primaryStage.setScene(mainScene);
	}
	
	/**
	 * Sets the attack screen with buttons for every attack
	 */
	private static void setAttackScreen1()
	{
		primaryStage.setTitle("Attacks");
		Label attackLabel = new Label("What will " + current.getName() + " do next???");
        
        ImageView iv1 = new ImageView();
        iv1.setImage(current.getImage());
        
        ImageView iv2 = new ImageView();
        iv2.setImage(opponent.getImage());
        		
		Label attackOpponentPokemon = new Label(opponent.getName() + "\n" + opponent.getCurrentHealth() + "/" + opponent.getTotalHealth()); 
        Label attackCurrentPokemon =  new Label(current.getName() + "\n" + current.getCurrentHealth() + "/" + current.getTotalHealth()); 
        
        Button goBackButtonAttack = new Button();
        goBackButtonAttack.setText("Go Back");
        goBackButtonAttack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	setMainScene1();
            }
        });
		
        Button attack1Button = new Button("Attack 1");
        attack1Button.setText(currentMoves[0].toString());
        if(currentMoves[0].getMoveName().equals("No Move") || currentMoves[0].getPP() == 0)
        	attack1Button.setDisable(true);
        attack1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	doDamage1(1);
            }
        });
        
        Button attack2Button = new Button("Attack 2");
        if(currentMoves[1] != null)
        	attack2Button.setText(currentMoves[1].toString());
        if(currentMoves[1].getMoveName().equals("No Move") || currentMoves[1].getPP() == 0)
        	attack2Button.setDisable(true);
        attack2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	doDamage1(2);
            }
        });
        
        Button attack3Button = new Button("Attack 3");
        if(currentMoves[2] != null)
        	attack3Button.setText(currentMoves[2].toString());
        if(currentMoves[2].getMoveName().equals("No Move") || currentMoves[2].getPP() == 0)
        	attack3Button.setDisable(true);
        attack3Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	doDamage1(3);
            }
        });
        
        Button attack4Button = new Button("Attack 4");
        if(currentMoves[3] != null)
        	attack4Button.setText(currentMoves[3].toString());
        if(currentMoves[3].getMoveName().equals("No Move") || currentMoves[3].getPP() == 0)
        	attack4Button.setDisable(true);
        attack4Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	doDamage1(4);
            }
        });
        VBox attackLayout = new VBox();
        attackLayout.setSpacing(10);
        
        HBox attackLayoutBottom = new HBox();
        attackLayoutBottom.getChildren().addAll(attack1Button, attack2Button, attack3Button, attack4Button);
        attackLayoutBottom.setAlignment(Pos.CENTER);
        attackLayoutBottom.setSpacing(10);
        
        HBox attackLayoutMid = new HBox();
        attackLayoutMid.getChildren().addAll(attackLabel);
        attackLayoutMid.setAlignment(Pos.CENTER);
        
        HBox attackLayoutTop = new HBox();
        attackLayoutTop.getChildren().addAll(iv1, attackCurrentPokemon, attackOpponentPokemon, iv2);
        attackLayoutTop.setAlignment(Pos.CENTER);
        attackLayoutTop.setSpacing(40);
        
        HBox attackLayoutBack = new HBox();
        attackLayoutBack.getChildren().addAll(goBackButtonAttack);
        attackLayoutBack.setAlignment(Pos.TOP_LEFT);
        
        attackLayout.getChildren().addAll(attackLayoutBack, attackLayoutTop, attackLayoutMid, attackLayoutBottom);

        Scene attackScene = new Scene(attackLayout, 525, 250);
        primaryStage.setScene(attackScene);
	}
	
	/**
	 * Sets the switch screen for switching in a new Pokemon
	 */
	private static void setSwitchScreen1()
	{
		primaryStage.setTitle("Switch");
		
		Button goBackButtonSwitch = new Button();
        goBackButtonSwitch.setText("Go Back");
        goBackButtonSwitch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	setMainScene1();
            }
        });
		
        Button switch1Button = new Button();
        if(party[0] != null)
        	switch1Button.setText(party[0].toString());
        else
        	switch1Button.setText("Null");
        switch1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                current = party[0];
            	setMainScene2();
            }
        });
        
        Button switch2Button = new Button();
        if(party[1] != null)
        	switch2Button.setText(party[1].toString());
        else
        	switch2Button.setText("Null");
        switch2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                current = party[1];
            	setMainScene2();
            }
        });
        
        Button switch3Button = new Button();
        if(party[2] != null)
        	switch3Button.setText(party[2].toString());
        else
        	switch3Button.setText("Null");
        switch3Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                current = party[2];
            	setMainScene2();
            }
        });
        
        Button switch4Button = new Button();
        if(party[3] != null)
        	switch4Button.setText(party[3].toString());
        else
        	switch4Button.setText("Null");
        switch4Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                current = party[3];
            	setMainScene2();
            }
        });
        
        Button switch5Button = new Button();
        if(party[4] != null)
        	switch5Button.setText(party[4].toString());
        else
        	switch5Button.setText("Null");
        switch5Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                current = party[4];
            	setMainScene2();
            }
        });
        
        Button switch6Button = new Button();
        if(party[5] != null)
        	switch6Button.setText(party[5].toString());
        else
        	switch6Button.setText("Null");
        switch6Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                current = party[5];
            	setMainScene2();
            }
        });
        
        for(int i = 0; i < party.length; i++)
        	if(party[1] != null && (party[i].getCurrentHealth() <= 0 || party[i].getName().equals(current.getName())))
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
        
        for(int i = 0; i < party.length; i++)
        	if(party[i] != null)
        		if(i == 0)
        			switchLayoutContent.getChildren().add(switch1Button);
        		else if(i == 1)
        			switchLayoutContent.getChildren().add(switch2Button);
        		else if(i == 2)
        			switchLayoutContent.getChildren().add(switch3Button);
        		else if(i == 3)
        			switchLayoutContent.getChildren().add(switch4Button);
        		else if(i == 4)
        			switchLayoutContent.getChildren().add(switch5Button);
        		else
        			switchLayoutContent.getChildren().add(switch6Button);
        
        switchLayoutContent.setAlignment(Pos.CENTER);
        
         HBox switchLayout = new HBox();
         
        switchLayout.getChildren().addAll(switchLayoutBack, switchLayoutContent);
        Scene switchScene = new Scene(switchLayout, 800,200);
        primaryStage.setScene(switchScene);
	}
	
	/**
	 * Sets the switch screen if your Pokemon runs out of HP, cannot exit screen
	 */
	private static void setFeintScreen1()
	{
		primaryStage.setTitle("Switch");

		Button switch1Button = new Button();
        if(party[0] != null)
        	switch1Button.setText(party[0].toString());
        else
        	switch1Button.setText("Null");
        switch1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                current = party[0];
            	setMainScene2();
            }
        });
        
        Button switch2Button = new Button();
        if(party[1] != null)
        	switch2Button.setText(party[1].toString());
        else
        	switch2Button.setText("Null");
        switch2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                current = party[1];
            	setMainScene2();
            }
        });
        
        Button switch3Button = new Button();
        if(party[2] != null)
        	switch3Button.setText(party[2].toString());
        else
        	switch3Button.setText("Null");
        switch3Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                current = party[2];
            	setMainScene2();
            }
        });
        
        Button switch4Button = new Button();
        if(party[3] != null)
        	switch4Button.setText(party[3].toString());
        else
        	switch4Button.setText("Null");
        switch4Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                current = party[3];
            	setMainScene2();
            }
        });
        
        Button switch5Button = new Button();
        if(party[4] != null)
        	switch5Button.setText(party[4].toString());
        else
        	switch5Button.setText("Null");
        switch5Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                current = party[4];
            	setMainScene2();
            }
        });
        
        Button switch6Button = new Button();
        if(party[5] != null)
        	switch6Button.setText(party[5].toString());
        else
        	switch6Button.setText("Null");
        switch6Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                current = party[5];
            	setMainScene2();
            }
        });
        
        for(int i = 0; i < party.length; i++)
        	if(party[i] == null || party[i].getCurrentHealth() <= 0)
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
        
        HBox feintLayout = new HBox();
        feintLayout.getChildren().addAll(switch1Button, switch2Button, switch3Button, switch4Button, switch5Button, switch6Button);
        feintLayout.setAlignment(Pos.CENTER);

        Scene feintScene = new Scene(feintLayout, 800,200);
        primaryStage.setScene(feintScene);
	}
	
	/**
	 * Creates the main option screen with Attack, Switch, Bag and Run buttons
	 */
	private static void setMainScene2()
	{
		primaryStage.setTitle("Battle");
		
       	Label opponentPokemon = new Label(opponent.getName() + "\n" + opponent.getCurrentHealth() + "/" + opponent.getTotalHealth()); 
        Label currentPokemon =  new Label(current.getName() + "\n" + current.getCurrentHealth() + "/" + current.getTotalHealth()); 
        
        ImageView iv1 = new ImageView();
        iv1.setImage(current.getImage());
        
        ImageView iv2 = new ImageView();
        iv2.setImage(opponent.getImage());
        
        Button attackButton = new Button();
        attackButton.setText("Attack");
        attackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	setAttackScreen2();
            	
            }
        });
        
        Button switchButton = new Button();
        switchButton.setText("Switch");
        switchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	setSwitchScreen2();
            	
            }
        });
        
        VBox mainLayout = new VBox();
        mainLayout.setSpacing(10);
        
        HBox mainLayoutTop = new HBox();
        mainLayoutTop.getChildren().addAll(iv2, opponentPokemon, currentPokemon, iv1);
        mainLayoutTop.setSpacing(40);
        mainLayoutTop.setAlignment(Pos.CENTER);
        
        HBox mainLayoutBottom = new HBox();
        mainLayoutBottom.getChildren().addAll(attackButton, switchButton);
        mainLayoutBottom.setAlignment(Pos.CENTER);
        mainLayoutBottom.setSpacing(40);
        
        mainLayout.getChildren().addAll(mainLayoutTop, mainLayoutBottom);
        
        Scene mainScene = new Scene(mainLayout, 500, 150);
        primaryStage.setScene(mainScene);
	}
	
	/**
	 * Sets the attack screen with buttons for every attack
	 */
	private static void setAttackScreen2()
	{
		primaryStage.setTitle("Attacks");
		Label attackLabel = new Label("What will " + opponent.getName() + " do next???");
        
        ImageView iv1 = new ImageView();
        iv1.setImage(current.getImage());
        
        ImageView iv2 = new ImageView();
        iv2.setImage(opponent.getImage());
        		
		Label attackOpponentPokemon = new Label(opponent.getName() + "\n" + opponent.getCurrentHealth() + "/" + opponent.getTotalHealth()); 
        Label attackCurrentPokemon =  new Label(current.getName() + "\n" + current.getCurrentHealth() + "/" + current.getTotalHealth()); 
        
        Button goBackButtonAttack = new Button();
        goBackButtonAttack.setText("Go Back");
        goBackButtonAttack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	setMainScene1();
            }
        });
		
        Button attack1Button = new Button("Attack 1");
        attack1Button.setText(opponentMoves[0].toString());
        if(opponentMoves[0].getMoveName().equals("No Move") || opponentMoves[0].getPP() == 0)
        	attack1Button.setDisable(true);
        attack1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	doDamage2(1);
            }
        });
        
        Button attack2Button = new Button("Attack 2");
        if(opponentMoves[1] != null)
        	attack2Button.setText(opponentMoves[1].toString());
        if(opponentMoves[1].getMoveName().equals("No Move") || opponentMoves[1].getPP() == 0)
        	attack2Button.setDisable(true);
        attack2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	doDamage2(2);
            }
        });
        
        Button attack3Button = new Button("Attack 3");
        if(opponentMoves[2] != null)
        	attack3Button.setText(opponentMoves[2].toString());
        if(opponentMoves[2].getMoveName().equals("No Move") || opponentMoves[2].getPP() == 0)
        	attack3Button.setDisable(true);
        attack3Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	doDamage2(3);
            }
        });
        
        Button attack4Button = new Button("Attack 4");
        if(opponentMoves[3] != null)
        	attack4Button.setText(opponentMoves[3].toString());
        if(opponentMoves[3].getMoveName().equals("No Move") || opponentMoves[3].getPP() == 0)
        	attack4Button.setDisable(true);
        attack4Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	doDamage2(4);
            }
        });
        VBox attackLayout = new VBox();
        attackLayout.setSpacing(10);
        
        HBox attackLayoutBottom = new HBox();
        attackLayoutBottom.getChildren().addAll(attack1Button, attack2Button, attack3Button, attack4Button);
        attackLayoutBottom.setAlignment(Pos.CENTER);
        attackLayoutBottom.setSpacing(10);
        
        HBox attackLayoutMid = new HBox();
        attackLayoutMid.getChildren().addAll(attackLabel);
        attackLayoutMid.setAlignment(Pos.CENTER);
        
        HBox attackLayoutTop = new HBox();
        attackLayoutTop.getChildren().addAll(iv2, attackOpponentPokemon, attackCurrentPokemon, iv1);
        attackLayoutTop.setAlignment(Pos.CENTER);
        attackLayoutTop.setSpacing(40);
        
        HBox attackLayoutBack = new HBox();
        attackLayoutBack.getChildren().addAll(goBackButtonAttack);
        attackLayoutBack.setAlignment(Pos.TOP_LEFT);
        
        attackLayout.getChildren().addAll(attackLayoutBack, attackLayoutTop, attackLayoutMid, attackLayoutBottom);

        Scene attackScene = new Scene(attackLayout, 525, 250);
        primaryStage.setScene(attackScene);
	}
	
	/**
	 * Sets the switch screen for switching in a new Pokemon
	 */
	private static void setSwitchScreen2()
	{
		primaryStage.setTitle("Switch");
		
		Button goBackButtonSwitch = new Button();
        goBackButtonSwitch.setText("Go Back");
        goBackButtonSwitch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	setMainScene2();
            }
        });
		
        Button switch1Button = new Button();
        if(party2[0] != null)
        	switch1Button.setText(party2[0].toString());
        else
        	switch1Button.setText("Null");
        switch1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                opponent = party2[0];
            	setMainScene1();
            }
        });
        
        Button switch2Button = new Button();
        if(party2[1] != null)
        	switch2Button.setText(party2[1].toString());
        else
        	switch2Button.setText("Null");
        switch2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                opponent = party2[1];
            	setMainScene1();
            }
        });
        
        Button switch3Button = new Button();
        if(party2[2] != null)
        	switch3Button.setText(party2[2].toString());
        else
        	switch3Button.setText("Null");
        switch3Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	opponent = party2[2];
            	setMainScene1();
            }
        });
        
        Button switch4Button = new Button();
        if(party2[3] != null)
        	switch4Button.setText(party2[3].toString());
        else
        	switch4Button.setText("Null");
        switch4Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	opponent = party2[3];
            	setMainScene1();
            }
        });
        
        Button switch5Button = new Button();
        if(party2[4] != null)
        	switch5Button.setText(party2[4].toString());
        else
        	switch5Button.setText("Null");
        switch5Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	opponent = party2[4];
            	setMainScene1();
            }
        });
        
        Button switch6Button = new Button();
        if(party2[5] != null)
        	switch6Button.setText(party2[5].toString());
        else
        	switch6Button.setText("Null");
        switch6Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	opponent = party2[5];
            	setMainScene1();
            }
        });
        
        for(int i = 0; i < party2.length; i++)
        	if(party2[1] != null && (party2[i].getCurrentHealth() <= 0 || party2[i].getName().equals(opponent.getName())))
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
        
        for(int i = 0; i < party2.length; i++)
        	if(party2[i] != null)
        		if(i == 0)
        			switchLayoutContent.getChildren().add(switch1Button);
        		else if(i == 1)
        			switchLayoutContent.getChildren().add(switch2Button);
        		else if(i == 2)
        			switchLayoutContent.getChildren().add(switch3Button);
        		else if(i == 3)
        			switchLayoutContent.getChildren().add(switch4Button);
        		else if(i == 4)
        			switchLayoutContent.getChildren().add(switch5Button);
        		else
        			switchLayoutContent.getChildren().add(switch6Button);
        
        switchLayoutContent.setAlignment(Pos.CENTER);
        
         HBox switchLayout = new HBox();
         
        switchLayout.getChildren().addAll(switchLayoutBack, switchLayoutContent);
        Scene switchScene = new Scene(switchLayout, 800,200);
        primaryStage.setScene(switchScene);
	}
	
	/**
	 * Sets the switch screen if your Pokemon runs out of HP, cannot exit screen
	 */
	private static void setFeintScreen2()
	{
		primaryStage.setTitle("Switch");

		Button switch1Button = new Button();
        if(party2[0] != null)
        	switch1Button.setText(party2[0].toString());
        else
        	switch1Button.setText("Null");
        switch1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                opponent = party2[0];
            	setMainScene1();
            }
        });
        
        Button switch2Button = new Button();
        if(party2[1] != null)
        	switch2Button.setText(party2[1].toString());
        else
        	switch2Button.setText("Null");
        switch2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	opponent = party2[1];
            	setMainScene1();
            }
        });
        
        Button switch3Button = new Button();
        if(party2[2] != null)
        	switch3Button.setText(party2[2].toString());
        else
        	switch3Button.setText("Null");
        switch3Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	opponent = party2[2];
            	setMainScene1();
            }
        });
        
        Button switch4Button = new Button();
        if(party2[3] != null)
        	switch4Button.setText(party2[3].toString());
        else
        	switch4Button.setText("Null");
        switch4Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	opponent = party2[3];
            	setMainScene1();
            }
        });
        
        Button switch5Button = new Button();
        if(party2[4] != null)
        	switch5Button.setText(party2[4].toString());
        else
        	switch5Button.setText("Null");
        switch5Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	opponent = party2[4];
            	setMainScene1();
            }
        });
        
        Button switch6Button = new Button();
        if(party2[5] != null)
        	switch6Button.setText(party2[5].toString());
        else
        	switch6Button.setText("Null");
        switch6Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	opponent = party2[5];
            	setMainScene1();
            }
        });
        
        for(int i = 0; i < party2.length; i++)
        	if(party2[i] == null || party2[i].getCurrentHealth() <= 0)
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
        
        HBox feintLayout = new HBox();
        feintLayout.getChildren().addAll(switch1Button, switch2Button, switch3Button, switch4Button, switch5Button, switch6Button);
        feintLayout.setAlignment(Pos.CENTER);

        Scene feintScene = new Scene(feintLayout, 800,200);
        primaryStage.setScene(feintScene);
	}
	
	/**
	 * Deals damage to the opposing pokemon based on what attack you chose
	 * @param index the attack to use
	 * @precondition index < 4
	 */
	private static void doDamage1(int index)
	{
		double modifier = 1;
		if(current.getType1().equals(currentMoves[index - 1].getType()) || current.getType2().equals(currentMoves[index - 1].getType()))
			modifier *= 1.5;
		modifier *= Type.getMultiplier(currentMoves[index - 1].getType(), opponent.getType1());
		modifier *= Type.getMultiplier(currentMoves[index - 1].getType(), opponent.getType2());
		int damage = (int)((((2 * current.getLevel() + 10) /250) * (current.getAttack()/opponent.getDefense()) * currentMoves[index - 1].getPower() + 10) * modifier);
		opponent.setCurrentHealth(damage);
		currentMoves[index - 1].use();
     	if(opponent.getCurrentHealth() <= 0 && player1.hasValidPokemon() == false)
     		winnerScreen();
     	else if(current.getCurrentHealth() <= 0 && player2.hasValidPokemon())
     		setFeintScreen2();
     	else
     		setMainScene2();
	}
	
	/**
	 * Deals damage to the opposing pokemon based on what attack you chose
	 * @param index the attack to use
	 * @precondition index < 4
	 */
	private static void doDamage2(int index)
	{
		double modifier = 1;
		if(opponent.getType1().equals(opponentMoves[index - 1].getType()) || opponent.getType2().equals(opponentMoves[index - 1].getType()))
			modifier *= 1.5;
		modifier *= Type.getMultiplier(opponentMoves[index - 1].getType(), current.getType1());
		modifier *= Type.getMultiplier(opponentMoves[index - 1].getType(), current.getType2());
		int damage = (int)((((2 * opponent.getLevel() + 10) /250) * (opponent.getAttack()/current.getDefense()) * opponentMoves[index - 1].getPower() + 10) * modifier);
		current.setCurrentHealth(damage);
		opponentMoves[index - 1].use();
     	if(current.getCurrentHealth() <= 0 && player2.hasValidPokemon() == false)
     		winnerScreen();
     	else if(current.getCurrentHealth() <= 0 && player2.hasValidPokemon())
     		setFeintScreen1();
     	else
     		setMainScene1();
	}
	
	/**
	 * Sets the winner screen if you beat the opposing Pokemon
	 */
	private static void winnerScreen() {
		primaryStage.setTitle("You win!");
		
		String path = GameRunner.class.getResource("/WildBattleEnd.mp3").toString();
        Media media = new Media(path);
        mp.stop();
        mp = new MediaPlayer(media);
        mp.play();
		
		Label attackLabel = new Label("You have defeated " + opponent.getName() + "!");
		
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

        Scene attackScene = new Scene(winnerLayout, 525, 150);
        primaryStage.setScene(attackScene);
	}
}

