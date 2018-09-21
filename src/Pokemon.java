import info.gridworld.actor.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Pokemon which has stats and moves to battle other Pokemon
 * @author Andrew
 *
 */
public class Pokemon extends Actor
{
	private String name;
	private int level;
	private String type1;
	private String type2;
	private int totalHealth;
	private int currentHealth;
	private int attack;
	private int defense;
	private Move[] moveArr;
	private Stage primaryStage;
	private Image img;
	private int ID;
	private String description;
	private int baseHealth;
	private int baseAttack;
	private int baseDefense;

	/**
	 * creates a new Pokemon based on the given name
	 * @param name the name of the Pokemon
     */
	public Pokemon(String name)
	{
		level = 100;
		moveArr = new Move[4];
		
		switch(name)
		{
			case "Treecko":
				type1 = Type.GRASS;
				type2 = Type.NONE;
				img = new Image("Treecko.png", true);
				ID = 1;
				description = "";
				baseHealth = 40;
				baseAttack = 45;
				baseDefense = 35;
				break;
			case "Grovyle":
				type1 = Type.GRASS;
				type2 = Type.NONE;
				img = new Image("Grovyle.png", true);
				ID = 2;
				description = "";
				baseHealth = 50;
				baseAttack = 65;
				baseDefense = 45;
				break;
			case "Sceptile":
				type1 = Type.GRASS;
				type2 = Type.NONE;
				img = new Image("Sceptile.png", true);
				ID = 3;
				description = "";
				baseHealth = 70;
				baseAttack = 85;
				baseDefense = 65;
				break;
			case "Torchic":
				type1 = Type.FIRE;
				type2 = Type.NONE;
				img = new Image("Torchic.png", true);
				ID = 4;
				description = "";
				baseHealth = 45;
				baseAttack = 60;
				baseDefense = 40;
				break;
			case "Combusken":
				type1 = Type.FIRE;
				type2 = Type.FIGHTING;
				img = new Image("Combusken.png", true);
				ID = 5;
				description = "";
				baseHealth = 60;
				baseAttack = 85;
				baseDefense = 60;
				break;
			case "Blaziken":
				type1 = Type.FIRE;
				type2 = Type.FIGHTING;
				img = new Image("Blaziken.png", true);
				ID = 6;
				description = "";
				baseHealth = 80;
				baseAttack = 120;
				baseDefense = 70;
				break;
			case "Mudkip": 
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Mudkip.png", true);
				ID = 7;
				description = "";
				baseHealth = 50;
				baseAttack = 70;
				baseDefense = 50;
				break;
			case "Marshtomp":
				type1 = Type.WATER;
				type2 = Type.GROUND;
				img = new Image("Marshtomp.png", true);
				ID = 8;
				description = "";
				baseHealth = 70;
				baseAttack = 85;
				baseDefense = 70;
				break;
			case "Swampert":
				type1 = Type.WATER;
				type2 = Type.GROUND;
				img = new Image("Swampert.png", true);
				ID = 9;
				description = "";
				baseHealth = 100;
				baseAttack = 110;
				baseDefense = 90;
				break;
			case "Poochyena":
				type1 = Type.DARK;
				type2 = Type.NONE;
				img = new Image("Poochyena.png", true);
				ID = 10;
				description = "";
				baseHealth = 35;
				baseAttack = 55;
				baseDefense = 35;
				break;
			case "Mightyena":
				type1 = Type.DARK;
				type2 = Type.NONE;
				img = new Image("Mightyena.png", true);
				ID = 11;
				description = "";
				baseHealth = 70;
				baseAttack = 90;
				baseDefense = 70;
				break;
			case "Zigzagoon":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Zigzagoon.png", true);
				ID = 12;
				description = "";
				baseHealth = 38;
				baseAttack = 30;
				baseDefense = 41;
				break;
			case "Linoone":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Linoone.png", true);
				ID = 13;
				description = "";
				baseHealth = 78;
				baseAttack = 70;
				baseDefense = 61;
				break;
			case "Wurmple":
				type1 = Type.BUG;
				type2 = Type.NONE;
				img = new Image("Wurmple.png", true);
				ID = 14;
				description = "";
				baseHealth = 45;
				baseAttack = 45;
				baseDefense = 35;
				break;
			case "Silcoon":
				type1 = Type.BUG;
				type2 = Type.NONE;
				img = new Image("Silcoon.png", true);
				ID = 15;
				description = "";
				baseHealth = 50;
				baseAttack = 35;
				baseDefense = 55;
				break;
			case "Beautifly":
				type1 = Type.BUG;
				type2 = Type.FLYING;
				img = new Image("Beautifly.png", true);
				ID = 16;
				description = "";
				baseHealth = 60;
				baseAttack = 70;
				baseDefense = 50;
				break;
			case "Cascoon":
				type1 = Type.BUG;
				type2 = Type.NONE;
				img = new Image("Cascoon.png", true);
				ID = 17;
				description = "";
				baseHealth = 50;
				baseAttack = 35;
				baseDefense = 55;
				break;
			case "Dustox":
				type1 = Type.BUG;
				type2 = Type.POISON;
				img = new Image("Dustox.png", true);
				ID = 18;
				description = "";
				baseHealth = 60;
				baseAttack = 50;
				baseDefense = 70;
				break;
			case "Lotad":
				type1 = Type.WATER;
				type2 = Type.GRASS;
				img = new Image("Lotad.png", true);
				ID = 19;
				description = "";
				baseHealth = 40;
				baseAttack = 30;
				baseDefense = 30;
				break;
			case "Lombre":
				type1 = Type.WATER;
				type2 = Type.GRASS;
				img = new Image("Lombre.png", true);
				ID = 20;
				description = "";
				baseHealth = 60;
				baseAttack = 50;
				baseDefense = 50;
				break;
			case "Ludicolo":
				type1 = Type.WATER;
				type2 = Type.GRASS;
				img = new Image("Ludicolo.png", true);
				ID = 21;
				description = "";
				baseHealth = 80;
				baseAttack = 70;
				baseDefense = 70;
				break;
			case "Seedot":
				type1 = Type.GRASS;
				type2 = Type.NONE;
				img = new Image("Seedot.png", true);
				ID = 22;
				description = "";
				baseHealth = 40;
				baseAttack = 40;
				baseDefense = 50;
				break;
			case "Nuzleaf":
				type1 = Type.GRASS;
				type2 = Type.DARK;
				img = new Image("Nuzleaf.png", true);
				ID = 23;
				description = "";
				baseHealth = 70;
				baseAttack = 70;
				baseDefense = 40;
				break;
			case "Shiftry":
				type1 = Type.GRASS;
				type2 = Type.DARK;
				img = new Image("Shiftry.png", true);
				ID = 24;
				description = "";
				baseHealth = 90;
				baseAttack = 100;
				baseDefense = 60;
				break;
			case "Tailow":
				type1 = Type.NORMAL;
				type2 = Type.FLYING;
				img = new Image("Tailow.png", true);
				ID = 25;
				description = "";
				baseHealth = 40;
				baseAttack = 55;
				baseDefense = 30;
				break;
			case "Swellow":
				type1 = Type.NORMAL;
				type2 = Type.FLYING;
				img = new Image("Swellow.png", true);
				ID = 26;
				description = "";
				baseHealth = 60;
				baseAttack = 85;
				baseDefense = 60;
				break;
			case "Wingull":
				type1 = Type.WATER;
				type2 = Type.FLYING;
				img = new Image("Wingull.png", true);
				ID = 27;
				description = "";
				baseHealth = 40;
				baseAttack = 30;
				baseDefense = 30;
				break;
			case "Pelipper":
				type1 = Type.WATER;
				type2 = Type.FLYING;
				img = new Image("Pelipper.png", true);
				ID = 28;
				description = "";
				baseHealth = 60;
				baseAttack = 50;
				baseDefense = 100;
				break;
			case "Ralts":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Ralts.png", true);
				ID = 29;
				description = "";
				baseHealth = 28;
				baseAttack = 25;
				baseDefense = 25;
				break;
			case "Kirlia":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Kirlia.png", true);
				ID = 30;
				description = "";
				baseHealth = 38;
				baseAttack = 35;
				baseDefense = 35;
				break;
			case "Gardevoir":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Gardevoir.png", true);
				ID = 31;
				description = "";
				baseHealth = 68;
				baseAttack = 65;
				baseDefense = 65;
				break;
			case "Surskit":
				type1 = Type.BUG;
				type2 = Type.WATER;
				img = new Image("Surskit.png", true);
				ID = 32;
				description = "";
				baseHealth = 40;
				baseAttack = 30;
				baseDefense = 22;
				break;
			case "Masquerain":
				type1 = Type.BUG;
				type2 = Type.WATER;
				img = new Image("Masquerain.png", true);
				ID = 33;
				description = "";
				baseHealth = 70;
				baseAttack = 60;
				baseDefense = 62;
				break;
			case "Shroomish":
				type1 = Type.GRASS;
				type2 = Type.NONE;
				img = new Image("Shroomish.png", true);
				ID = 34;
				description = "";
				baseHealth = 60;
				baseAttack = 40;
				baseDefense = 60;
				break;
			case "Breloom":
				type1 = Type.GRASS;
				type2 = Type.FIGHTING;
				img = new Image("Breloom.png", true);
				ID = 35;
				description = "";
				baseHealth = 60;
				baseAttack = 130;
				baseDefense = 80;
				break;
			case "Slakoth":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Slakoth.png", true);
				ID = 36;
				description = "";
				baseHealth = 60;
				baseAttack = 60;
				baseDefense = 60;
				break;
			case "Vigoroth":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Vigoroth.png", true);
				ID = 37;
				description = "";
				baseHealth = 80;
				baseAttack = 80;
				baseDefense = 80;
				break;
			case "Slaking":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Slaking.png", true);
				ID = 38;
				description = "";
				baseHealth = 150;
				baseAttack = 160;
				baseDefense = 100;
				break;
			case "Abra":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Abra.png", true);
				ID = 39;
				description = "";
				baseHealth = 25;
				baseAttack = 20;
				baseDefense = 15;
				break;
			case "Kadabra":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Kadabra.png", true);
				ID = 40;
				description = "";
				baseHealth = 40;
				baseAttack = 35;
				baseDefense = 30;
				break;
			case "Alakazam":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Alakazam.png", true);
				ID = 41;
				description = "";
				baseHealth = 55;
				baseAttack = 50;
				baseDefense = 45;
				break;
			case "Nincada":
				type1 = Type.BUG;
				type2 = Type.GROUND;
				img = new Image("Nincada.png", true);
				ID = 42;
				description = "";
				baseHealth = 31;
				baseAttack = 45;
				baseDefense = 90;
				break;
			case "Ninjask":
				type1 = Type.BUG;
				type2 = Type.FLYING;
				img = new Image("Ninjask.png", true);
				ID = 43;
				description = "";
				baseHealth = 61;
				baseAttack = 90;
				baseDefense = 45;
				break;
			case "Shedinja":
				type1 = Type.BUG;
				type2 = Type.FLYING;
				img = new Image("Shedinja.png", true);
				ID = 44;
				description = "";
				baseHealth = 1;
				baseAttack = 90;
				baseDefense = 45;
				break;
			case "Whismur":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Whismur.png", true);
				ID = 45;
				description = "";
				baseHealth = 64;
				baseAttack = 51;
				baseDefense = 23;
				break;
			case "Loudred":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Loudred.png", true);
				ID = 46;
				description = "";
				baseHealth = 84;
				baseAttack = 71;
				baseDefense = 43;
				break;
			case "Exploud":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Exploud.png", true);
				ID = 47;
				description = "";
				baseHealth = 104;
				baseAttack = 91;
				baseDefense = 63;
				break;
			case "Makuhita":
				type1 = Type.FIGHTING;
				type2 = Type.NONE;
				img = new Image("Makuhita.png", true);
				ID = 48;
				description = "";
				baseHealth = 72;
				baseAttack = 60;
				baseDefense = 30;
				break;
			case "Hariyama":
				type1 = Type.FIGHTING;
				type2 = Type.NONE;
				img = new Image("Hariyama.png", true);
				ID = 49;
				description = "";
				baseHealth = 144;
				baseAttack = 120;
				baseDefense = 60;
				break;
			case "Goldeen":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Goldeen.png", true);
				ID = 50;
				description = "";
				baseHealth = 45;
				baseAttack = 67;
				baseDefense = 60;
				break;
			case "Seaking":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Seaking.png", true);
				ID = 51;
				description = "";
				break;
			case "Magikarp":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Magikarp.png", true);
				ID = 52;
				description = "";
				break;
			case "Gyrados":
				type1 = Type.WATER;
				type2 = Type.FLYING;
				img = new Image("Gyrados.png", true);
				ID = 53;
				description = "";
				break;
			case "Azurill":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Azurill.png", true);
				ID = 54;
				description = "";
				break;
			case "Marill":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Marill.png", true);
				ID = 55;
				description = "";
				break;
			case "Azumarill":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Azumarill.png", true);
				ID = 56;
				description = "";
				break;
			case "Geodude":
				type1 = Type.ROCK;
				type2 = Type.GROUND;
				img = new Image("Geodude.png", true);
				ID = 57;
				description = "";
				break;
			case "Graveler":
				type1 = Type.ROCK;
				type2 = Type.GROUND;
				img = new Image("Graveler.png", true);
				ID = 58;
				description = "";
				break;
			case "Golem":
				type1 = Type.ROCK;
				type2 = Type.GROUND;
				img = new Image("Golem.png", true);
				ID = 59;
				description = "";
				break;
			case "Nosepass":
				type1 = Type.ROCK;
				type2 = Type.NONE;
				img = new Image("Nosepass.png", true);
				ID = 60;
				description = "";
				break;
			case "Skitty":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Skitty.png", true);
				ID = 61;
				description = "";
				break;
			case "Delcatty":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Delcatty.png", true);
				ID = 62;
				description = "";
				break;
			case "Zubat":
				type1 = Type.POISON;
				type2 = Type.FLYING;
				img = new Image("Zubat.png", true);
				ID = 63;
				description = "";
				break;
			case "Golbat":
				type1 = Type.POISON;
				type2 = Type.FLYING;
				img = new Image("Golbat.png", true);
				ID = 64;
				description = "";
				break;
			case "Crobat":
				type1 = Type.POISON;
				type2 = Type.FLYING;
				img = new Image("Crobat.png", true);
				ID = 65;
				description = "";
				break;
			case "Tentacool":
				type1 = Type.WATER;
				type2 = Type.POISON;
				img = new Image("Tentacool.png", true);
				ID = 66;
				description = "";
				break;
			case "Tentacruel":
				type1 = Type.WATER;
				type2 = Type.POISON;
				img = new Image("Tentacruel.png", true);
				ID = 67;
				description = "";
				break;
			case "Sableye":
				type1 = Type.DARK;
				type2 = Type.GHOST;
				img = new Image("Sableye.png", true);
				ID = 68;
				description = "";
				break;
			case "Mawile":
				type1 = Type.STEEL;
				type2 = Type.NONE;
				img = new Image("Mawile.png", true);
				ID = 69;
				description = "";
				break;
			case "Aron":
				type1 = Type.STEEL;
				type2 = Type.ROCK;
				img = new Image("Aron.png", true);
				ID = 70;
				description = "";
				break;
			case "Lairon":
				type1 = Type.STEEL;
				type2 = Type.ROCK;
				img = new Image("Lairon.png", true);
				ID = 71;
				description = "";
				break;
			case "Aggron":
				type1 = Type.STEEL;
				type2 = Type.ROCK;
				img = new Image("Aggron.png", true);
				ID = 72;
				description = "";
				break;
			case "Machop":
				type1 = Type.FIGHTING;
				type2 = Type.NONE;
				img = new Image("Machop.png", true);
				ID = 73;
				description = "";
				break;
			case "Machoke":
				type1 = Type.FIGHTING;
				type2 = Type.NONE;
				img = new Image("Machoke.png", true);
				ID = 74;
				description = "";
				break;
			case "Machamp":
				type1 = Type.FIGHTING;
				type2 = Type.NONE;
				img = new Image("Machamp.png", true);
				ID = 75;
				description = "";
				break;
			case "Meditite":
				type1 = Type.FIGHTING;
				type2 = Type.PSYCHIC;
				img = new Image("Meditite.png", true);
				ID = 76;
				description = "";
				break;
			case "Medicham":
				type1 = Type.FIGHTING;
				type2 = Type.PSYCHIC;
				img = new Image("Medicham.png", true);
				ID = 77;
				description = "";
				break;
			case "Electrike":
				type1 = Type.ELECTRIC;
				type2 = Type.NONE;
				img = new Image("Electrike.png", true);
				ID = 78;
				description = "";
				break;
			case "Manectric":
				type1 = Type.ELECTRIC;
				type2 = Type.NONE;
				img = new Image("Manectric.png", true);
				ID = 79;
				description = "";
				break;
			case "Plusle":
				type1 = Type.ELECTRIC;
				type2 = Type.NONE;
				img = new Image("Plusle.png", true);
				ID = 80;
				description = "";
				break;
			case "Minun":
				type1 = Type.ELECTRIC;
				type2 = Type.NONE;
				img = new Image("Minun.png", true);
				ID = 81;
				description = "";
				break;
			case "Magnemite":
				type1 = Type.ELECTRIC;
				type2 = Type.STEEL;
				img = new Image("Magnemite.png", true);
				ID = 82;
				description = "";
				break;
			case "Magneton":
				type1 = Type.ELECTRIC;
				type2 = Type.STEEL;
				img = new Image("Magneton.png", true);
				ID = 83;
				description = "";
				break;
			case "Voltorb":
				type1 = Type.ELECTRIC;
				type2 = Type.NONE;
				img = new Image("Voltorb.png", true);
				ID = 84;
				description = "";
				break;
			case "Electrode":
				type1 = Type.ELECTRIC;
				type2 = Type.NONE;
				img = new Image("Electrode.png", true);
				ID = 85;
				description = "";
				break;
			case "Volbeat":
				type1 = Type.BUG;
				type2 = Type.NONE;
				img = new Image("Volbeat.png", true);
				ID = 86;
				description = "";
				break;
			case "Illumise":
				type1 = Type.BUG;
				type2 = Type.NONE;
				img = new Image("Illumise.png", true);
				ID = 87;
				description = "";
				break;
			case "Oddish":
				type1 = Type.GRASS;
				type2 = Type.POISON;
				img = new Image("Oddish.png", true);
				ID = 88;
				description = "";
				break;
			case "Gloom":
				type1 = Type.GRASS;
				type2 = Type.POISON;
				img = new Image("Gloom.png", true);
				ID = 89;
				description = "";
				break;
			case "Vileplume":
				type1 = Type.GRASS;
				type2 = Type.POISON;
				img = new Image("Vileplume.png", true);
				ID = 90;
				description = "";
				break;
			case "Bellossom":
				type1 = Type.GRASS;
				type2 = Type.NONE;
				img = new Image("Bellossom.png", true);
				ID = 91;
				description = "";
				break;
			case "Doduo":
				type1 = Type.NORMAL;
				type2 = Type.FLYING;
				img = new Image("Doduo.png", true);
				ID = 92;
				description = "";
				break;
			case "Dotrio":
				type1 = Type.NORMAL;
				type2 = Type.FLYING;
				img = new Image("Dotrio.png", true);
				ID = 93;
				description = "";
				break;
			case "Roselia":
				type1 = Type.GRASS;
				type2 = Type.POISON;
				img = new Image("Roselia.png", true);
				ID = 94;
				description = "";
				break;
			case "Gulpin":
				type1 = Type.POISON;
				type2 = Type.NONE;
				img = new Image("Gulpin.png", true);
				ID = 95;
				description = "";
				break;
			case "Swalot":
				type1 = Type.POISON;
				type2 = Type.NONE;
				img = new Image("Swalot.png", true);
				ID = 96;
				description = "";
				break;
			case "Carvanha":
				type1 = Type.WATER;
				type2 = Type.DARK;
				img = new Image("Carvanha.png", true);
				ID = 97;
				description = "";
				break;
			case "Sharpedo":
				type1 = Type.WATER;
				type2 = Type.DARK;
				img = new Image("Sharpedo.png", true);
				ID = 98;
				description = "";
				break;
			case "Wailmer":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Wailmer.png", true);
				ID = 99;
				description = "";
				break;
			case "Wailord":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Wailord.png", true);
				ID = 100;
				description = "";
				break;
			case "Numel":
				type1 = Type.FIRE;
				type2 = Type.GROUND;
				img = new Image("Numel.png", true);
				ID = 101;
				description = "";
				break;
			case "Camerupt":
				type1 = Type.FIRE;
				type2 = Type.GROUND;
				img = new Image("Camerupt.png", true);
				ID = 102;
				description = "";
				break;
			case "Slugma":
				type1 = Type.FIRE;
				type2 = Type.NONE;
				img = new Image("Slugma.png", true);
				ID = 103;
				description = "";
				break;
			case "Magcargo":
				type1 = Type.FIRE;
				type2 = Type.ROCK;
				img = new Image("Magcargo.png", true);
				ID = 104;
				description = "";
				break;
			case "Torkoal":
				type1 = Type.FIRE;
				type2 = Type.NONE;
				img = new Image("Torkoal.png", true);
				ID = 105;
				description = "";
				break;	
			case "Grimer":
				type1 = Type.POISON;
				type2 = Type.NONE;
				img = new Image("Grimer.png", true);
				ID = 106;
				description = "";
				break;	
			case "Muk":
				type1 = Type.POISON;
				type2 = Type.NONE;
				img = new Image("Muk.png", true);
				ID = 107;
				description = "";
				break;	
			case "Koffing":
				type1 = Type.POISON;
				type2 = Type.NONE;
				img = new Image("Koffing.png", true);
				ID = 108;
				description = "";
				break;	
			case "Weezing":
				type1 = Type.POISON;
				type2 = Type.NONE;
				img = new Image("Weezing.png", true);
				ID = 109;
				description = "";
				break;	
			case "Spoink":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Spoink.png", true);
				ID = 110;
				description = "";
				break;	
			case "Grumpig":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Grumpig.png", true);
				ID = 111;
				description = "";
				break;	
			case "Sandshrew":
				type1 = Type.GROUND;
				type2 = Type.NONE;
				img = new Image("Sandshrew.png", true);
				ID = 112;
				description = "";
				break;	
			case "Sandslash":
				type1 = Type.GROUND;
				type2 = Type.NONE;
				img = new Image("Sandslash.png", true);
				ID = 113;
				description = "";
				break;	
			case "Spinda":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Spinda.png", true);
				ID = 114;
				description = "";
				break;	
			case "Skarmory":
				type1 = Type.STEEL;
				type2 = Type.FLYING;
				img = new Image("Skarmory.png", true);
				ID = 115;
				description = "";
				break;	
			case "Trapinch":
				type1 = Type.GROUND;
				type2 = Type.NONE;
				img = new Image("Trapinch.png", true);
				ID = 116;
				description = "";
				break;
			case "Vibrava":
				type1 = Type.GROUND;
				type2 = Type.DRAGON;
				img = new Image("Vibrava.png", true);
				ID = 117;
				description = "";
				break;
			case "Flygon":
				type1 = Type.GROUND;
				type2 = Type.DRAGON;
				img = new Image("Flygon.png", true);
				ID = 118;
				description = "";
				break;
			case "Cacnea":
				type1 = Type.GRASS;
				type2 = Type.NONE;
				img = new Image("Cacnea.png", true);
				ID = 119;
				description = "";
				break;
			case "Cacturne":
				type1 = Type.GRASS;
				type2 = Type.DARK;
				img = new Image("Cacturne.png", true);
				ID = 120;
				description = "";
				break;
			case "Swablu":
				type1 = Type.NORMAL;
				type2 = Type.FLYING;
				img = new Image("Swablu.png", true);
				ID = 121;
				description = "";
				break;
			case "Altaria":
				type1 = Type.DRAGON;
				type2 = Type.FLYING;
				img = new Image("Altaria.png", true);
				ID = 122;
				description = "";
				break;
			case "Zangoose":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Zangoose.png", true);
				ID = 123;
				description = "";
				break;
			case "Seviper":
				type1 = Type.POISON;
				type2 = Type.NONE;
				img = new Image("Seviper.png", true);
				ID = 124;
				description = "";
				break;
			case "Lunatone":
				type1 = Type.ROCK;
				type2 = Type.PSYCHIC;
				img = new Image("Lunatone.png", true);
				ID = 125;
				description = "";
				break;
			case "Solrock":
				type1 = Type.ROCK;
				type2 = Type.PSYCHIC;
				img = new Image("Solrock.png", true);
				ID = 126;
				description = "";
				break;
			case "Barboach":
				type1 = Type.WATER;
				type2 = Type.GROUND;
				img = new Image("Barboach.png", true);
				ID = 127;
				description = "";
				break;
			case "Whiscash":
				type1 = Type.WATER;
				type2 = Type.GROUND;
				img = new Image("Whiscash.png", true);
				ID = 128;
				description = "";
				break;
			case "Corphish":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Corphish.png", true);
				ID = 129;
				description = "";
				break;
			case "Crawdaunt":
				type1 = Type.WATER;
				type2 = Type.DARK;
				img = new Image("Crawdaunt.png", true);
				ID = 130;
				description = "";
				break;
			case "Baltoy":
				type1 = Type.GROUND;
				type2 = Type.PSYCHIC;
				img = new Image("Baltoy.png", true);
				ID = 131;
				description = "";
				break;
			case "Claydol":
				type1 = Type.GROUND;
				type2 = Type.PSYCHIC;
				img = new Image("Claydol.png", true);
				ID = 132;
				description = "";
				break;
			case "Lileep":
				type1 = Type.ROCK;
				type2 = Type.GRASS;
				img = new Image("Lileep.png", true);
				ID = 133;
				description = "";
				break;
			case "Cradily":
				type1 = Type.ROCK;
				type2 = Type.GRASS;
				img = new Image("Cradily.png", true);
				ID = 134;
				description = "";
				break;
			case "Anorith":
				type1 = Type.ROCK;
				type2 = Type.BUG;
				img = new Image("Anorith.png", true);
				ID = 135;
				description = "";
				break;
			case "Armaldo":
				type1 = Type.ROCK;
				type2 = Type.BUG;
				img = new Image("Armaldo.png", true);
				ID = 136;
				description = "";
				break;
			case "Igglybuff":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Igglybuff.png", true);
				ID = 137;
				description = "";
				break;
			case "Jigglypuff":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Jigglypuff.png", true);
				ID = 138;
				description = "";
				break;
			case "Wigglytuff":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Wigglytuff.png", true);
				ID = 139;
				description = "";
				break;
			case "Feebas":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Feebas.png", true);
				ID = 140;
				description = "";
				break;
			case "Milotic":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Milotic.png", true);
				ID = 141;
				description = "";
				break;
			case "Castform":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Castform.png", true);
				ID = 142;
				description = "";
				break;
			case "Staryu":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Staryu.png", true);
				ID = 143;
				description = "";
				break;
			case "Starmie":
				type1 = Type.WATER;
				type2 = Type.PSYCHIC;
				img = new Image("Starmie.png", true);
				ID = 144;
				description = "";
				break;
			case "Kecleon":
				type1 = Type.NORMAL;
				type2 = Type.NONE;
				img = new Image("Kecleon.png", true);
				ID = 145;
				description = "";
				break;
			case "Shuppet":
				type1 = Type.GHOST;
				type2 = Type.NONE;
				img = new Image("Shuppet.png", true);
				ID = 146;
				description = "";
				break;
			case "Banette":
				type1 = Type.GHOST;
				type2 = Type.NONE;
				img = new Image("Banette.png", true);
				ID = 147;
				description = "";
				break;
			case "Duskull":
				type1 = Type.GHOST;
				type2 = Type.NONE;
				img = new Image("Duskull.png", true);
				ID = 148;
				description = "";
				break;
			case "Dusclops":
				type1 = Type.GHOST;
				type2 = Type.NONE;
				img = new Image("Dusclops.png", true);
				ID = 149;
				description = "";
				break;
			case "Tropius":
				type1 = Type.GRASS;
				type2 = Type.FLYING;
				img = new Image("Tropius.png", true);
				ID = 150;
				description = "";
				break;
			case "Chimecho":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Chimecho.png", true);
				ID = 151;
				description = "";
				break;
			case "Absol":
				type1 = Type.DARK;
				type2 = Type.NONE;
				img = new Image("Absol.png", true);
				ID = 152;
				description = "";
				break;
			case "Vulpix":
				type1 = Type.FIRE;
				type2 = Type.NONE;
				img = new Image("Vulpix.png", true);
				ID = 153;
				description = "";
				break;
			case "Ninetales":
				type1 = Type.FIRE;
				type2 = Type.NONE;
				img = new Image("Ninetales.png", true);
				ID = 154;
				description = "";
				break;
			case "Pichu":
				type1 = Type.ELECTRIC;
				type2 = Type.NONE;
				img = new Image("Pichu.png", true);
				ID = 155;
				description = "";
				break;
			case "Pikachu":
				type1 = Type.ELECTRIC;
				type2 = Type.NONE;
				img = new Image("Pikachu.png", true);
				ID = 156;
				description = "";
				break;
			case "Raichu":
				type1 = Type.ELECTRIC;
				type2 = Type.NONE;
				img = new Image("Raichu.png", true);
				ID = 157;
				description = "";
				break;
			case "Psyduck":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Psyduck.png", true);
				ID = 158;
				description = "";
				break;
			case "Golduck":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Golduck.png", true);
				ID = 159;
				description = "";
				break;
			case "Wynaut":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Wynaut.png", true);
				ID = 160;
				description = "";
				break;
			case "Wobbuffet":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Wobbuffet.png", true);
				ID = 161;
				description = "";
				break;
			case "Natu":
				type1 = Type.PSYCHIC;
				type2 = Type.FLYING;
				img = new Image("Natu.png", true);
				ID = 162;
				description = "";
				break;
			case "Xatu":
				type1 = Type.PSYCHIC;
				type2 = Type.FLYING;
				img = new Image("Xatu.png", true);
				ID = 163;
				description = "";
				break;
			case "Girafarig":
				type1 = Type.NORMAL;
				type2 = Type.PSYCHIC;
				img = new Image("Girafarig.png", true);
				ID = 164;
				description = "";
				break;
			case "Phanpy":
				type1 = Type.GROUND;
				type2 = Type.NONE;
				img = new Image("Phanpy.png", true);
				ID = 165;
				description = "";
				break;
			case "Donphan":
				type1 = Type.GROUND;
				type2 = Type.NONE;
				img = new Image("Donphan.png", true);
				ID = 166;
				description = "";
				break;
			case "Pinsir":
				type1 = Type.BUG;
				type2 = Type.NONE;
				img = new Image("Pinsir.png", true);
				ID = 167;
				description = "";
				break;
			case "Heracross":
				type1 = Type.BUG;
				type2 = Type.FIGHTING;
				img = new Image("Heracross.png", true);
				ID = 168;
				description = "";
				break;
			case "Rhyhorn":
				type1 = Type.GROUND;
				type2 = Type.ROCK;
				img = new Image("Rhyhorn.png", true);
				ID = 169;
				description = "";
				break;
			case "Rhydon":
				type1 = Type.GROUND;
				type2 = Type.ROCK;
				img = new Image("Rhydon.png", true);
				ID = 170;
				description = "";
				break;
			case "Snorunt":
				type1 = Type.ICE;
				type2 = Type.NONE;
				img = new Image("Snorunt.png", true);
				ID = 171;
				description = "";
				break;
			case "Glalie":
				type1 = Type.ICE;
				type2 = Type.NONE;
				img = new Image("Glalie.png", true);
				ID = 172;
				description = "";
				break;
			case "Spheal":
				type1 = Type.ICE;
				type2 = Type.WATER;
				img = new Image("Spheal.png", true);
				ID = 173;
				description = "";
				break;
			case "Sealo":
				type1 = Type.ICE;
				type2 = Type.WATER;
				img = new Image("Sealo.png", true);
				ID = 174;
				description = "";
				break;
			case "Walrein":
				type1 = Type.ICE;
				type2 = Type.WATER;
				img = new Image("Walrein.png", true);
				ID = 175;
				description = "";
				baseHealth = 1000;
				baseAttack = 1000;
				baseDefense = 1000;
				break;
			case "Clamperl":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Clamperl.png", true);
				ID = 176;
				description = "";
				break;
			case "Huntail":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Huntail.png", true);
				ID = 177;
				description = "";
				break;
			case "Gorebyss":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Gorebyss.png", true);
				ID = 178;
				description = "";
				break;
			case "Relicanth":
				type1 = Type.WATER;
				type2 = Type.ROCK;
				img = new Image("Relicanth.png", true);
				ID = 179;
				description = "";
				break;
			case "Corsola":
				type1 = Type.WATER;
				type2 = Type.ROCK;
				img = new Image("Corsola.png", true);
				ID = 180;
				description = "";
				break;
			case "Chinchou":
				type1 = Type.WATER;
				type2 = Type.ELECTRIC;
				img = new Image("Chinchou.png", true);
				ID = 181;
				description = "";
				break;
			case "Lanturn":
				type1 = Type.WATER;
				type2 = Type.ELECTRIC;
				img = new Image("Lanturn.png", true);
				ID = 182;
				description = "";
				break;
			case "Luvdisc":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Luvdisc.png", true);
				ID = 183;
				description = "";
				break;
			case "Horsea":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Horsea.png", true);
				ID = 184;
				description = "";
				break;
			case "Seadra":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Seadra.png", true);
				ID = 185;
				description = "";
				break;
			case "Kingdra":
				type1 = Type.WATER;
				type2 = Type.DRAGON;
				img = new Image("Kingdra.png", true);
				ID = 186;
				description = "";
				break;
			case "Bagon":
				type1 = Type.DRAGON;
				type2 = Type.NONE;
				img = new Image("Bagon.png", true);
				ID = 187;
				description = "";
				break;
			case "Shelgon":
				type1 = Type.DRAGON;
				type2 = Type.NONE;
				img = new Image("Shelgon.png", true);
				ID = 188;
				description = "";
				break;
			case "Salamance":
				type1 = Type.DRAGON;
				type2 = Type.NONE;
				img = new Image("Salamance.png", true);
				ID = 189;
				description = "";
				break;
			case "Beldum":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Beldum.png", true);
				ID = 190;
				description = "";
				break;
			case "Metang":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Metang.png", true);
				ID = 191;
				description = "";
				break;
			case "Metagross":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Metagross.png", true);
				ID = 192;
				description = "";
				break;
			case "Regirock":
				type1 = Type.ROCK;
				type2 = Type.NONE;
				img = new Image("Regirock.png", true);
				ID = 193;
				description = "";
				break;
			case "Regice":
				type1 = Type.ICE;
				type2 = Type.NONE;
				img = new Image("Regice.png", true);
				ID = 194;
				description = "";
				break;
			case "Registeel":
				type1 = Type.STEEL;
				type2 = Type.NONE;
				img = new Image("Registeel.png", true);
				ID = 195;
				description = "";
				break;
			case "Latias":
				type1 = Type.DRAGON;
				type2 = Type.PSYCHIC;
				img = new Image("Latias.png", true);
				ID = 196;
				description = "";
				break;
			case "Latios":
				type1 = Type.DRAGON;
				type2 = Type.PSYCHIC;
				img = new Image("Latios.png", true);
				ID = 197;
				description = "";
				break;
			case "Kyogre":
				type1 = Type.WATER;
				type2 = Type.NONE;
				img = new Image("Kyogre.png", true);
				ID = 198;
				description = "";
				break;
			case "Groudon":
				type1 = Type.GROUND;
				type2 = Type.NONE;
				img = new Image("Groudon.png", true);
				ID = 199;
				description = "";
				break;
			case "Rayquaza":
				type1 = Type.DRAGON;
				type2 = Type.FLYING;
				img = new Image("Rayquaza.png", true);
				ID = 200;
				description = "";
				break;
			case "Jirachi":
				type1 = Type.STEEL;
				type2 = Type.PSYCHIC;
				img = new Image("Jirachi.png", true);
				ID = 201;
				description = "";
				break;
			case "Deoxys":
				type1 = Type.PSYCHIC;
				type2 = Type.NONE;
				img = new Image("Deoxys.png", true);
				ID = 202;
				description = "";
				break;
			case "Drake's Altaria":
				type1 = Type.DRAGON;
				type2 = Type.FLYING;
				img = new Image("Altaria.png", true);
				ID = 122;
				description = "";
				Move[] altariaMoves = {
						new Move("Double-Edge", 120, 15, Type.NORMAL),
						new Move("DragonBreath", 60, 20, Type.DRAGON),
						new Move("Aerial Ace", 60, 20, Type.FLYING),
						new Move("Dragon Claw", 80, 15, Type.DRAGON)
						};
				moveArr = altariaMoves;
				level = 54;
				break;
			case "Drake's Flygon":
				type1 = Type.GROUND;
				type2 = Type.DRAGON;
				img = new Image("Flygon.png", true);
				ID = 118;
				description = "";
				Move[] flygonMoves = {
						new Move("Flamethrower", 95, 15, Type.FIRE),
						new Move("Crunch", 80, 15, Type.DARK),
						new Move("DragonBreath", 60, 20, Type.DRAGON),
						new Move("Earthquake", 100, 10, Type.GROUND)
						};
				moveArr = flygonMoves;
				level = 53;
				break;
			case "Drake's Kingdra":
				type1 = Type.WATER;
				type2 = Type.DRAGON;
				img = new Image("Kingdra.png", true);
				ID = 186;
				description = "";
				Move[] kingdraMoves = {
						new Move("Surf", 95, 15, Type.WATER),
						new Move("Body Slam", 85, 15, Type.NORMAL),
						new Move("DragonBreath", 60, 20, Type.DRAGON),
						new Move("Dragon Claw", 80, 15, Type.DRAGON)
						};
				moveArr = kingdraMoves;
				level = 55;
				break;
			case "Drake's Shelgon":
				type1 = Type.DRAGON;
				type2 = Type.NONE;
				img = new Image("Shelgon.png", true);
				ID = 188;
				description = "";
				Move[] shelgonMoves = {
						new Move("Rock Tomb", 50, 10, Type.ROCK),
						new Move("Dragon Claw", 80, 15, Type.DRAGON),
						new Move("Protect", 0, 10, Type.NORMAL),
						new Move("Double-Edge", 120, 15, Type.NORMAL)
						};
				moveArr = shelgonMoves;
				level = 52;
				break;
			case "Drake's Salamance":
				type1 = Type.DRAGON;
				type2 = Type.FLYING;
				img = new Image("Salamance.png", true);
				ID = 189;
				description = "";
				Move[] salamanceMoves = {
						new Move("Flamethrower", 95, 15, Type.FIRE),
						new Move("Dragon Claw", 80, 15, Type.DRAGON),
						new Move("Rock Slide", 75, 10, Type.ROCK),
						new Move("Crunch", 80, 15, Type.DARK)
						};
				moveArr = salamanceMoves;
				level = 55;
				break;
			case "Glacia's Glalie":
				type1 = Type.ICE;
				type2 = Type.NONE;
				img = new Image("Glalie.png", true);
				ID = 172;
				description = "";
				Move[] glalieMoves = {
						new Move("Shadow Ball", 80, 15, Type.GHOST),
						new Move("Crunch", 80, 15, Type.DARK),
						new Move("Ice Beam", 90, 10, Type.ICE),
						new Move("Icy Wind", 55, 15, Type.ICE)
					};
				moveArr = glalieMoves;
				level = 552;
				break;
			case "Glacia's Sealo":
				type1 = Type.ICE;
				type2 = Type.WATER;
				img = new Image("Sealo.png", true);
				ID = 174;
				description = "";
				Move[] sealoMoves = {
						new Move("Body Slam", 85, 15, Type.NORMAL),
						new Move("Double-Edge", 120, 15, Type.NORMAL),
						new Move("Ice Beam", 90, 10, Type.ICE),
						new Move("Blizzard", 110, 5, Type.ICE)
					};
				moveArr = sealoMoves;
				level = 50;
				break;
			case "Glacia's Walrein":
				type1 = Type.ICE;
				type2 = Type.WATER;
				img = new Image("Walrein.png", true);
				ID = 175;
				description = "";
				Move[] walreinMoves = {
						new Move("Body Slam", 85, 15, Type.NORMAL),
						new Move("Surf", 90, 15, Type.WATER),
						new Move("Ice Beam", 90, 10, Type.ICE),
						new Move("Blizzard", 110, 5, Type.ICE)
					};
				moveArr = walreinMoves;
				level = 55;
				break;
			case "Phoebe's Banette":
				type1 = Type.GHOST;
				type2 = Type.NONE;
				img = new Image("Banette.png", true);
				ID = 147;
				description = "";
				Move[] banetteMoves = {
						new Move("Shadow Ball", 80, 15, Type.GHOST),
						new Move("Psychic", 90, 10, Type.PSYCHIC),
						new Move("Thunderbolt", 90, 15, Type.ELECTRIC),
						new Move("Earthquake", 100, 10, Type.GROUND)
					};
				moveArr = banetteMoves;
				level = 52;
				break;
			case "Phoebe's Dusclops":
				type1 = Type.GHOST;
				type2 = Type.NONE;
				img = new Image("Dusclops.png", true);
				ID = 149;
				description = "";
				Move[] dusclopsMoves = {
						new Move("Shadow Ball", 80, 15, Type.GHOST),
						new Move("Rock Slide", 75, 10, Type.ROCK),
						new Move("Ice Beam", 90, 10, Type.ICE),
						new Move("Earthquake", 100, 10, Type.GROUND)
					};
				moveArr = dusclopsMoves;
				level = 53;
				break;
			case "Phoebe's Sableye":
				type1 = Type.GHOST;
				type2 = Type.DARK;
				img = new Image("Sableye.png", true);
				ID = 68;
				description = "";
				Move[] sableyeMoves = {
						new Move("Shadow Ball", 80, 15, Type.GHOST),
						new Move("Night Shade", 50, 15, Type.GHOST),
						new Move("Faint Attack", 60, 20, Type.DARK),
						new Move("Earthquake", 100, 10, Type.GROUND)
					};
				moveArr = sableyeMoves;
				level = 53;
				break;
					
			default :
				this.name = "MissingNo";
				type1 = Type.NONE;
				type2 = Type.NONE;
				img = new Image("MissingNo.png", true);
				ID = 999;
				description = "";
				break;
		}
		
		totalHealth = Math.abs((((2* baseHealth + 100) * level)/100) + 10);
		currentHealth = Math.abs((((2* baseHealth + 100) * level)/100) + 10);
		attack = (((2* baseAttack + 100) * level)/100) + 10;
		defense = (((2* baseDefense + 100) * level)/100) + 10;
		
		this.name = name;
	}

	/**
	 * returns the Pokemon's name
	 * @return the Pokemon's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the Pokemon's name
	 * @param name the Pokemon's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns the Pokemon's level
	 * @return the Pokemon's level
	 */
	public int getLevel() {	
		return level;
	}

	/**
	 * sets the Pokemon's level
	 * @param level the Pokemon's level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * returns the Pokemon's type 1
	 * @return the Pokemon's type 1
	 */
	public String getType1() {
		return type1;
	}

	/**
	 * sets the Pokemon's type 1
	 * @param type1 the Pokemon's type 1
	 */
	public void setType1(String type1) {
		this.type1 = type1;
	}

	/**
	 * returns the Pokemon's type 2
	 * @return the Pokemon's type 2
	 */
	public String getType2() {
		return type2;
	}

	/**
	 * sets the Pokemon's type 2
	 * @param type2 the Pokemon's type 2
	 */
	public void setType2(String type2) {
		this.type2 = type2;
	}

	/**
	 * returns the Pokemon's total health
	 * @return the Pokemon's total health
	 */
	public int getTotalHealth() {
		return totalHealth;
	}

	/**
	 * sets the Pokemon's total health 
	 * @param totalHealth the Pokemon's total health
	 */
	public void setTotalHealth(int totalHealth) {
		this.totalHealth = totalHealth;
	}

	/**
	 * returns the Pokemon's current health
	 * @return the Pokemon's current health
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}

	/**
	 * sets the Pokemon's current health 
	 * @param currentHealth the Pokemon's current health
	 */
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}	

	/**
	 * returns the Pokemon's attack
	 * @return the Pokemon's attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * sets the Pokemon's attack
	 * @param attack the Pokemon's attack
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * returns the Pokemon's defense
	 * @return the Pokemon's defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * sets the Pokemon's defense
	 * @param defense the Pokemon's defense
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public void takeDamage(int damage)
	{
		currentHealth -= damage;
	}

	/**
	 * returns the Pokemon's moves
	 * @return the Pokemon's moves
	 */
	public Move[] getMoves() {
		return moveArr;
	}

	/**
	 * sets the Pokemon's moves
	 * @param moveArr the Pokemon's moves
	 */
	public void setMoveArr(Move[] moveArr) {
		this.moveArr = moveArr;
	}

	/**
	 * returns the Pokemon's image
	 * @return the Pokemon's image
	 */
	public Image getImage() {
		return img;
	}

	/**
	 * sets the Pokemon's image
	 * @param img the Pokemon's image
	 */
	public void setImg(Image img) {
		this.img = img;
	}

	/**
	 * returns the Pokemon's id
	 * @return the Pokemon's id
	 */
	public int getID() {
		return ID;
	}

	/**
	 * sets the Pokemon's id
	 * @param ID the Pokemon's id
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

	/**
	 * returns the Pokemon's description
	 * @return the Pokemon's description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * sets the Pokemon's description
	 * @param description the Pokemon's description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * teaches the Pokemon a new move
	 * @param move the move to be taught
	 */
	public void learnMove(Move move)
	{
		int moveCount = 0;
		for(Move m: moveArr)
			if(m != null && !m.getMoveName().equals("No Move"))
				moveCount++;
		
		final Move aMove = move;
		
		if(moveCount == 4)
		{
			boolean nameBoolean = AlertBox.confirm("Would you like to learn the move " + aMove.getMoveName() + "?");
			if(nameBoolean == true)
			{
				primaryStage = new Stage();
				
				Button move1Button = new Button(moveArr[0].toString());
				move1Button.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	boolean confirmBoolean = AlertBox.confirm("Are you sure you would like to forget " + moveArr[0].getMoveName() + "?");
		            	if(confirmBoolean)
		            	{
		            		moveArr[0] = aMove;
		            		primaryStage.close();
		            	}
		            }
		        });
				Button move2Button = new Button(moveArr[1].toString());
				move2Button.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	boolean confirmBoolean = AlertBox.confirm("Are you sure you would like to forget " + moveArr[1].getMoveName() + "?");
		            	if(confirmBoolean)
		            	{
		            		moveArr[1] = aMove;
		            		primaryStage.close();
		            	}
		            	
		            }
		        });
				Button move3Button = new Button(moveArr[2].toString());
				move3Button.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	boolean confirmBoolean = AlertBox.confirm("Are you sure you would like to forget " + moveArr[2].getMoveName() + "?");
		            	if(confirmBoolean)
		            	{
		            		moveArr[2] = aMove;
		            		primaryStage.close();
		            	}
		            }
		        });
				Button move4Button = new Button(moveArr[3].toString());
				move4Button.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	boolean confirmBoolean = AlertBox.confirm("Are you sure you would like to forget " + moveArr[1].getMoveName() + "?");
		            	if(confirmBoolean)
		            	{
		            		moveArr[3] = aMove;
		            		primaryStage.close();
		            	}
		            }
		        });
				
				HBox moveLayout = new HBox();
				moveLayout.getChildren().addAll(move1Button, move2Button, move3Button, move4Button);
				moveLayout.setAlignment(Pos.CENTER);
				moveLayout.setSpacing(10);
				
				Scene learnScene = new Scene(moveLayout, 200, 200);
				primaryStage.setScene(learnScene);
				
			}	
			else 
				AlertBox.displayNoTitle(name + " did not learn " + aMove.getMoveName(), "OK");
		}
		else
		{
			moveArr[moveCount] = aMove;
			AlertBox.displayNoTitle(name + " learned " + aMove.getMoveName() + "!", "OK");
		}
			
	}
	
	/**
	 * returns a string version of the Pokemon
	 * @return a string version of the Pokemon
	 */
	public String toString()
	{
		return ("Name: " + name + "\nLevel: " + level + "\nCurrent HP: " + currentHealth);
	}
	
	/**
	 * returns a string version of the Pokemon's moves
	 * @return a string version of the Pokemon's moves
	 */
	public String moveString()
	{
		String moveString = "";
		for(Move m : moveArr)
			moveString += (m + "\n");
		return moveString;
	}
}
