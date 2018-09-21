import java.util.ArrayList;

/**
 * A move for a Pokemon to use
 * @author Andrew
 *
 */
public class Move 
{
	private String name;
	private int power;
	private int pp;
	private int currentPP;
	private String type;
	
	/**
	 * constructs a default move
	 */
	public Move() 
	{
		name = "Struggle Bug";
		power = 5;
		pp = 50;
		type = Type.NORMAL;
	}
    
	/**
	 * creates a move with a name, power, pp and type
	 * @param aName the name of the Move
	 * @param aPower the power of the Move
	 * @param aPP the PP of the Move
	 * @param aType the Type of the Move
	 */
    public Move(String aName, int aPower, int aPP, String aType) 
	{
		name = aName;
		power = aPower;
		pp = aPP;
		currentPP = aPP;
		type = aType;
	}
	
    /**
     * returns an ArrayList of all moves in the game
     * @return an ArrayList of all moves in the game
     */
    public static ArrayList<Move> getAllMoves()
    {
    	ArrayList<Move> moves = new ArrayList<Move>();
    	moves.add(new Move("Absorb", 20, 20, Type.GRASS));
    	moves.add(new Move("Acid", 40, 30, Type.POISON));
    	moves.add(new Move("Aerial Ace", 60, 20, Type.FLYING));
    	moves.add(new Move("Aeroblast", 100, 5, Type.FLYING));
    	moves.add(new Move("Air Cutter", 55, 25, Type.FLYING));
    	moves.add(new Move("Ancient Power", 60, 5, Type.ROCK));
    	moves.add(new Move("Arm Thrust", 40, 20, Type.FIGHTING));
    	moves.add(new Move("Astonish", 30, 15, Type.GHOST));
    	moves.add(new Move("Aurora Beam", 65, 20, Type.ICE));
    	moves.add(new Move("Barrage", 35, 20, Type.NORMAL));
    	moves.add(new Move("Beat Up", 10, 10, Type.DARK));
    	moves.add(new Move("Bind", 35, 20, Type.NORMAL));
    	moves.add(new Move("Bite", 60, 25, Type.DARK));
    	moves.add(new Move("Blast Burn", 150, 5, Type.FIRE));
    	moves.add(new Move("Blaze Kick", 85, 10, Type.FIRE));
    	moves.add(new Move("Blizzard", 120, 5, Type.ICE));
    	moves.add(new Move("Body Slam", 85, 15, Type.NORMAL));
    	moves.add(new Move("Bone Club", 65, 20, Type.GROUND));
    	moves.add(new Move("Bone Rush", 45, 10, Type.GROUND));
    	moves.add(new Move("Bonemerang", 50, 10, Type.GROUND));
    	moves.add(new Move("Bounce", 85, 5, Type.FLYING));
    	moves.add(new Move("Brick Break", 75, 15, Type.FIGHTING));
    	moves.add(new Move("Bubble", 20, 30, Type.WATER));
    	moves.add(new Move("Bubble Beam", 65, 20, Type.WATER));
    	moves.add(new Move("Bullet Seed", 35, 30, Type.GRASS));
    	moves.add(new Move("Clamp", 35, 10, Type.WATER));
    	moves.add(new Move("Comet Punch", 38, 15, Type.NORMAL));
    	moves.add(new Move("Confusion", 50, 25, Type.PSYCHIC));
    	moves.add(new Move("Constrict", 30, 25, Type.NORMAL));
    	moves.add(new Move("Covet", 40, 40, Type.NORMAL));
    	moves.add(new Move("Crabhammer", 90, 10, Type.WATER));
    	moves.add(new Move("Cross Chop", 100, 5, Type.FIGHTING));
    	moves.add(new Move("Cruch", 80, 15, Type.DARK));
    	moves.add(new Move("Crush Claw", 75, 10, Type.NORMAL));
    	moves.add(new Move("Cut", 50, 30, Type.NORMAL));
    	moves.add(new Move("Dig", 60, 10, Type.GROUND));
    	moves.add(new Move("Dive", 60, 10, Type.WATER));
    	moves.add(new Move("Dizzy Punch", 70, 10, Type.NORMAL));
    	moves.add(new Move("Doom Desire", 120, 5, Type.STEEL));
    	moves.add(new Move("Double Kick", 50, 30, Type.FIGHTING));
    	moves.add(new Move("Double Edge", 120, 15, Type.WATER));
    	moves.add(new Move("Doubleslap", 35, 10, Type.NORMAL));
    	moves.add(new Move("Dragon Claw", 80, 15, Type.DRAGON));
    	moves.add(new Move("Dragonbreath", 60, 20, Type.DRAGON));
    	moves.add(new Move("Dream Eater", 100, 15, Type.PSYCHIC));
    	moves.add(new Move("Drill Peck", 80, 100, Type.WATER));
    	moves.add(new Move("Dynamic Punch", 100, 5, Type.FIGHTING));
    	moves.add(new Move("Earthquake", 100, 10, Type.GROUND));
    	moves.add(new Move("Egg Bomb", 100, 10, Type.NORMAL));
    	moves.add(new Move("Ember", 40, 25, Type.FIRE));
    	moves.add(new Move("Eruption", 150, 5, Type.FIRE));
    	moves.add(new Move("Explosion", 150, 5, Type.NORMAL));
    	moves.add(new Move("Extrasensory", 80, 30, Type.PSYCHIC));
    	moves.add(new Move("Extremespeed", 80, 5, Type.NORMAL));
    	moves.add(new Move("Facade", 70, 20, Type.NORMAL));
    	moves.add(new Move("Faint Attack", 60, 20, Type.DARK));
    	moves.add(new Move("Fake Out", 40, 10, Type.NORMAL));
    	moves.add(new Move("False Swipe", 40, 40, Type.NORMAL));
    	moves.add(new Move("Fire Blast", 120, 5, Type.FIRE));
    	moves.add(new Move("Fire Punch", 75, 15, Type.FIRE));
    	moves.add(new Move("Fire Spin", 35, 15, Type.FIRE));
    	moves.add(new Move("Flamethrower", 95, 15, Type.FIRE));
    	moves.add(new Move("Fly", 70, 15, Type.FLYING));
    	moves.add(new Move("Focus Punch", 150, 20, Type.FIGHTING));
    	moves.add(new Move("Frenzy Plant", 150, 5, Type.GRASS));
    	moves.add(new Move("Fury Attack", 35, 20, Type.NORMAL));
    	moves.add(new Move("Fury Cutter", 10, 20, Type.BUG));
    	moves.add(new Move("Furry Swipes", 38, 15, Type.NORMAL));
    	moves.add(new Move("Future Sight", 80, 15, Type.PSYCHIC));
    	moves.add(new Move("Giga Drain", 60, 5, Type.GRASS));
    	moves.add(new Move("Gust", 40, 35, Type.FLYING));
    	moves.add(new Move("Headbutt", 70, 15, Type.NORMAL));
    	moves.add(new Move("Heat Wave", 100, 10, Type.FIRE));
    	moves.add(new Move("Hi Jump Kick", 85, 20, Type.FIGHTING));
    	moves.add(new Move("Horn Attack", 65, 25, Type.NORMAL));
    	moves.add(new Move("Hydro Cannon", 150, 5, Type.WATER));
    	moves.add(new Move("Hydro Pump", 120, 5, Type.WATER));
    	moves.add(new Move("Hyper Beam", 120, 5, Type.NORMAL));
    	moves.add(new Move("Hyper Voice", 90, 10, Type.NORMAL));
    	moves.add(new Move("Ice Ball", 30, 20, Type.ICE));
    	moves.add(new Move("Ice Beam", 95, 10, Type.ICE));
    	moves.add(new Move("Ice Punch", 75, 15, Type.ICE));
    	moves.add(new Move("Icy Wind", 55, 15, Type.ICE));
    	moves.add(new Move("Iron Tail", 100, 15, Type.STEEL));
    	moves.add(new Move("Karate Chop", 50, 25, Type.FIGHTING));
    	moves.add(new Move("Knock Off", 20, 20, Type.DARK));
    	moves.add(new Move("Leaf Blade", 70, 15, Type.GRASS));
    	moves.add(new Move("Leech Life", 20, 15, Type.BUG));
    	moves.add(new Move("Lick", 20, 20, Type.GHOST));
    	moves.add(new Move("Luster Purge", 70, 5, Type.PSYCHIC));
    	moves.add(new Move("Mach Punch", 40, 5, Type.FIGHTING));
    	moves.add(new Move("Magical Leaf", 60, 20, Type.GRASS));
    	moves.add(new Move("Mega Drain", 40, 10, Type.GRASS));
    	moves.add(new Move("Megahorn", 120, 10, Type.BUG));
    	moves.add(new Move("Metal Claw", 50, 35, Type.STEEL));
    	moves.add(new Move("Meteor Mash", 100, 10, Type.STEEL));
    	moves.add(new Move("Mist Ball", 70, 5, Type.PSYCHIC));
    	moves.add(new Move("Mud Shot", 55, 15, Type.GROUND));
    	moves.add(new Move("Muddy Water", 95, 10, Type.WATER));
    	moves.add(new Move("Mud Slap", 20, 10, Type.GROUND));
    	moves.add(new Move("Needle Arm", 60, 15, Type.GRASS));
    	moves.add(new Move("Night Shade", 50, 15, Type.GHOST));
    	moves.add(new Move("Outrage", 90, 15, Type.DRAGON));
    	moves.add(new Move("Overheat", 140, 5, Type.FIRE));
    	moves.add(new Move("Peck", 35, 35, Type.FLYING));
    	moves.add(new Move("Petal Dance", 70, 20, Type.GRASS));
    	moves.add(new Move("Pin Missle", 34, 20, Type.BUG));
    	moves.add(new Move("Poison Fang", 50, 15, Type.POISON));
    	moves.add(new Move("Poison Sting", 15, 35, Type.POISON));
    	moves.add(new Move("Poison Tail", 50, 25, Type.POISON));
    	moves.add(new Move("Pound", 40, 35, Type.NORMAL));
    	moves.add(new Move("Powder Snow", 40, 25, Type.ICE));
    	moves.add(new Move("Protect", 0, 10, Type.NORMAL));
    	moves.add(new Move("Psybeam", 65, 20, Type.PSYCHIC));
    	moves.add(new Move("Psychic", 90, 10, Type.PSYCHIC));
    	moves.add(new Move("Pursuit", 40, 20, Type.DARK));
    	moves.add(new Move("Quick Attack", 40, 30, Type.NORMAL));
    	moves.add(new Move("Rage", 20, 20, Type.NORMAL));
    	moves.add(new Move("Razor Leaf", 55, 25, Type.GRASS));
    	moves.add(new Move("Razor Wind", 80, 10, Type.NORMAL));
    	moves.add(new Move("Revenge", 60, 10, Type.FIGHTING));
    	moves.add(new Move("Rock Blast", 45, 10, Type.ROCK));
    	moves.add(new Move("Rock Slide", 75, 10, Type.ROCK));
    	moves.add(new Move("Rock Smash", 20, 15, Type.FIGHTING));
    	moves.add(new Move("Rock Throw", 50, 15, Type.ROCK));
    	moves.add(new Move("Rock Tomb", 50, 10, Type.ROCK));
    	moves.add(new Move("Scratch", 40, 35, Type.NORMAL));
    	moves.add(new Move("Secret Power", 70, 20, Type.NORMAL));
    	moves.add(new Move("Seismic Toss", 90, 20, Type.FIGHTING));
    	moves.add(new Move("Shadow Ball", 80, 15, Type.GHOST));
    	moves.add(new Move("Shadow Punch", 60, 20, Type.GHOST));
    	moves.add(new Move("Shock Wave", 60, 20, Type.ELECTRIC));
    	moves.add(new Move("Signal Beam", 75, 15, Type.BUG));
    	moves.add(new Move("Silver Wind", 60, 205, Type.BUG));
    	moves.add(new Move("Skull Bash", 100, 15, Type.NORMAL));
    	moves.add(new Move("Sky Attack", 140, 5, Type.FLYING));
    	moves.add(new Move("Sky Uppercut", 85, 15, Type.FIGHTING));
    	moves.add(new Move("Slam", 80, 20, Type.NORMAL));
    	moves.add(new Move("Slash", 70, 20, Type.NORMAL));
    	moves.add(new Move("Sludge", 65, 20, Type.POISON));
    	moves.add(new Move("Sludge Bomb", 90, 10, Type.POISON));
    	moves.add(new Move("Smellingsalt", 60, 10, Type.NORMAL));
    	moves.add(new Move("Smog", 20, 20, Type.POISON));
    	moves.add(new Move("Snore", 40, 15, Type.NORMAL));
    	moves.add(new Move("Solarbeam", 120, 10, Type.GRASS));
    	moves.add(new Move("Spark", 65, 20, Type.ELECTRIC));
    	moves.add(new Move("Spike Cannon", 20, 15, Type.NORMAL));
    	moves.add(new Move("Spit Up", 50, 10, Type.NORMAL));
    	moves.add(new Move("Steel Wing", 70, 25, Type.STEEL));
    	moves.add(new Move("Stomp", 65, 20, Type.NORMAL));
    	moves.add(new Move("Strength", 80, 15, Type.NORMAL));
    	moves.add(new Move("Submisison", 80, 25, Type.FIGHTING));
    	moves.add(new Move("Super Power", 120, 5, Type.FIGHTING));
    	moves.add(new Move("Surf", 95, 15, Type.WATER));
    	moves.add(new Move("Swift", 60, 20, Type.NORMAL));
    	moves.add(new Move("Tackle", 35, 35, Type.NORMAL));
    	moves.add(new Move("Take Down", 90, 20, Type.NORMAL));
    	moves.add(new Move("Thief", 40, 10, Type.DARK));
    	moves.add(new Move("Thrash", 90, 20, Type.NORMAL));
    	moves.add(new Move("Thunder", 120, 10, Type.ELECTRIC));
    	moves.add(new Move("Thundebrolt", 95, 15, Type.ELECTRIC));
    	moves.add(new Move("Thunder Punch", 75, 15, Type.ELECTRIC));
    	moves.add(new Move("Thundershock", 40, 30, Type.ELECTRIC));
    	moves.add(new Move("Tri-Attack", 80, 10, Type.NORMAL));
    	moves.add(new Move("Twister", 40, 20, Type.DRAGON));
    	moves.add(new Move("Uproar", 50, 10, Type.NORMAL));
    	moves.add(new Move("Vine Whip", 35, 10, Type.GRASS));
    	moves.add(new Move("Vital Throw", 70, 10, Type.FIGHTING));
    	moves.add(new Move("Water Gun", 40, 25, Type.WATER));
    	moves.add(new Move("Water Pulse", 40, 25, Type.WATER));
    	moves.add(new Move("Water Spout", 150, 5, Type.WATER));
    	moves.add(new Move("Waterfall", 80, 15, Type.WATER));
    	moves.add(new Move("Weather Ball", 50, 10, Type.NORMAL));
    	moves.add(new Move("Wing Attack", 60, 35, Type.FLYING));
    	moves.add(new Move("Zap Cannon", 100, 5, Type.ELECTRIC));
    	
    	return moves;
    }
    
    /**
     * returns the Move's name
     * @return the Move's name
     */
	public String getMoveName()
	{
		return name;
	}
	
	/**
     * returns the Move's Type
     * @return the Move's Type
     */
	public String getType()
	{
		return type;
	}
	
	/**
     * returns the Move's power
     * @return the Move's power
     */
	public int getPower()
	{
		if(currentPP == 0)
			return 0;
		return power;
	}
	
	/**
     * returns the Move's PP
     * @return the Move's PP
     */
	public int getPP()
	{
		return currentPP;
	}
	
	/**
     * returns a string version of the move
     * @return a string version of the move
     */
	public String toString()
	{
		return name + "  " + power + "  " + currentPP + "/" + pp;
	}
	
	/**
	 * subtracts one PP from the Move
	 */
	public void use()
	{
		currentPP--;
	}
}