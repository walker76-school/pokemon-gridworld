/**
 * Class which holds type constants and returns multipliers based two types
 * @author Andrew
 *
 */
public abstract class Type 
{	
	public static String NORMAL = "Normal";
	public static final String FIRE = "Fire";
	public static final String FIGHTING = "Fighting";
	public static final String WATER = "Water";
	public static final String FLYING = "Flying";
	public static final String GRASS = "Grass";
	public static final String POISON = "Poison";
	public static final String ELECTRIC = "Electric";
	public static final String GROUND = "Ground";
	public static final String PSYCHIC = "Psychic";
	public static final String ROCK = "Rock";
	public static final String ICE = "Ice";
	public static final String BUG = "Bug";
	public static final String DRAGON = "Dragon";
	public static final String GHOST = "Ghost";
	public static final String DARK = "Dark";
	public static final String STEEL = "Steel";
	public static final String NONE = "None";
	
	/**
	 * returns the multiplier based on two types
	 * @param typeOne the first type
	 * @param typeTwo the second type
	 * @return the multiplier based on two types 
	 */
	public static double getMultiplier(String typeOne, String typeTwo)
	{
		double multiplier = 1;
		
		switch(typeOne)
			{
				case "Normal":
					if(typeTwo.equals("Rock") || typeTwo.equals("Steel"))
						multiplier *= 0.5;
					else if(typeTwo.equals("Ghost"))
						multiplier *=  0;
					else 
						multiplier *=  1;
					break;
				case "Fire":
					if(typeTwo.equals("Grass") || typeTwo.equals("Ice") || typeTwo.equals("Bug") || typeTwo.equals("Steel"))
						multiplier *=  2;
					else if(typeTwo.equals("Fire") || typeTwo.equals("Water") || typeTwo.equals("Rock") || typeTwo.equals("Dragon"))
						multiplier *=  0.5;
					else 
						multiplier *=  1;
					break;
				case "Fighting":
					if(typeTwo.equals("Normal") || typeTwo.equals("Ice") || typeTwo.equals("Rock") || typeTwo.equals("Steel") || typeTwo.equals("Dark"))
						multiplier *=  2;
					else if(typeTwo.equals("Poison") || typeTwo.equals("Flying") || typeTwo.equals("Psychic") || typeTwo.equals("Bug"))
						multiplier *=  0.5;
					else if(typeTwo.equals("Ghost"))
						multiplier *=  0;
					else 
						multiplier *=  1;
					break;
				case "Water":
					if(typeTwo.equals("Fire") || typeTwo.equals("Ground") || typeTwo.equals("Rock"))
						multiplier *=  2;
					else if(typeTwo.equals("Water") || typeTwo.equals("Grass") || typeTwo.equals("Dragon"))
						multiplier *=  0.5;
					else 
						multiplier *=  1;
					break;
				case "Flying":
					if(typeTwo.equals("Grass") || typeTwo.equals("Fighting") || typeTwo.equals("Bug"))
						multiplier *=  2;
					else if(typeTwo.equals("Electric") || typeTwo.equals("Rock") || typeTwo.equals("Steel"))
						multiplier *=  0.5;
					else 
						multiplier *=  1;
					break;
				case "Grass":
					if(typeTwo.equals("Water") || typeTwo.equals("Ground") || typeTwo.equals("Rock"))
						multiplier *=  2;
					else if(typeTwo.equals("Fire") || typeTwo.equals("Grass") || typeTwo.equals("Poison") || typeTwo.equals("Flying") || typeTwo.equals("Bug") || typeTwo.equals("Dragon") || typeTwo.equals("Steel"))
						multiplier *=  0.5;
					else 
						multiplier *=  1;
					break;
				case "Poison":
					if(typeTwo.equals("Grass"))
						multiplier *=  2;
					else if(typeTwo.equals("Poison") || typeTwo.equals("Ground") || typeTwo.equals("Rock") || typeTwo.equals("Ghost"))
						multiplier *=  0.5;
					else if (typeTwo.equals("Steel"))
						multiplier *=  0;
					else 
						multiplier =  1;
					break;
				case "Electric":
					if(typeTwo.equals("Water") || typeTwo.equals("Flying"))
						multiplier *= 2;
					else if(typeTwo.equals("Grass") || typeTwo.equals("Electric") || typeTwo.equals("Dragon"))
						multiplier *=  0.5;
					else if (typeTwo.equals("Ground"))
						multiplier *=  0;
					else 
						multiplier *=  1;
					break;
				case "Ground":
					if(typeTwo.equals("Fire") || typeTwo.equals("Electric") || typeTwo.equals("Poison") || typeTwo.equals("Rock") || typeTwo.equals("Steel"))
						multiplier *=  2;
					else if(typeTwo.equals("Grass") || typeTwo.equals("Bug"))
						multiplier *=  0.5;
					else if (typeTwo.equals("Flying"))
						multiplier *=  0;
					else 
						multiplier *=  1;
					break;
				case "Psychic":
					if(typeTwo.equals("Fighting") || typeTwo.equals("Poison"))
						multiplier *=  2;
					else if(typeTwo.equals("Psychic") || typeTwo.equals("Steel"))
						multiplier *=  0.5;
					else if (typeTwo.equals("Dark"))
						multiplier *=  0;
					else 
						multiplier *=  1;
					break;
				case "Rock":
					if(typeTwo.equals("Fire") || typeTwo.equals("Ice") || typeTwo.equals("Flying") || typeTwo.equals("Bug"))
						multiplier *=  2;
					else if(typeTwo.equals("Fighting") || typeTwo.equals("Ground") || typeTwo.equals("Steel"))
						multiplier *=  0.5;
					else 
						multiplier *=  1;
					break;
				case "Ice":
					if(typeTwo.equals("Grass") || typeTwo.equals("Ground") || typeTwo.equals("Flying") || typeTwo.equals("Dragon"))
						multiplier *=  2;
					else if(typeTwo.equals("Fire") || typeTwo.equals("Water") || typeTwo.equals("Ice") || typeTwo.equals("Steel"))
						multiplier *=  0.5;
					else 
						multiplier *=  1;
					break;
				case "Bug":
					if(typeTwo.equals("Grass") || typeTwo.equals("Psychic") || typeTwo.equals("Dark"))
						multiplier *=  2;
					else if(typeTwo.equals("Fire") || typeTwo.equals("Fighting") || typeTwo.equals("Poison") || typeTwo.equals("Flying") || typeTwo.equals("Ghost") || typeTwo.equals("Steel"))
						multiplier *=  0.5;
					else 
						multiplier *=  1;
					break;
				case "Dragon":
					if(typeTwo.equals("Dragon"))
						multiplier *=  2;
					else if(typeTwo.equals("Steel"))
						multiplier *=  0.5;
					else 
						multiplier *=  1;
					break;
				case "Ghost":
					if(typeTwo.equals("Psychic") || typeTwo.equals("Ghost"))
						multiplier *=  2;
					else if(typeTwo.equals("Dark") || typeTwo.equals("Steel"))
						multiplier *=  0.5;
					else if (typeTwo.equals("Normal"))
						multiplier *=  0;
					else 
						multiplier *=  1;
					break;
				case "Dark":
					if(typeTwo.equals("Psychic") || typeTwo.equals("Ghost"))
						multiplier *=  2;
					else if(typeTwo.equals("Fighting") || typeTwo.equals("Dark") || typeTwo.equals("Steel"))
						multiplier *=  0.5;
					else 
						multiplier *=  1;
					break;
				case "Steel":
					if(typeTwo.equals("Ice") || typeTwo.equals("Rock"))
						multiplier *=  2;
					else if(typeTwo.equals("Fire") || typeTwo.equals("Water") || typeTwo.equals("Steel"))
						multiplier *=  0.5;
					else 
						multiplier *=  1;
					break;
				case "None":
					multiplier = 0;
					break;
			}
		return multiplier;
	}
}