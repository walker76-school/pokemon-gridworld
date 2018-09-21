import java.awt.Color;
import info.gridworld.actor.*;

/**
 * Actor object to return a specific Pokemon
 * @author Andrew
 *
 */
public class Grass extends Actor
{
    private Pokemon pokemon;
    private boolean pokeBoolean;
    private Pokemon[] allPoke;
      
    /**
     * Creates a grass object with a random Pokemon assigned to it
     */
    public Grass() 
    {
    	Pokemon[] temp = {
				new Pokemon("Treecko"),
				new Pokemon("Grovyle"), 
				new Pokemon("Sceptile"), 
				new Pokemon("Torchic"),
				new Pokemon("Combusken"),
				new Pokemon("Blaziken"), 
				new Pokemon("Mudkip"), 
				new Pokemon("Marshtomp"),  
				new Pokemon("Swampert"), 
				new Pokemon("Poochyena"),  
				new Pokemon("Mightyena"),  
				new Pokemon("Zigzagoon"),  
				new Pokemon("Linoone"), 
				new Pokemon("Wurmple"), 
				new Pokemon("Silcoon"),
				new Pokemon("Beautifly"), 
				new Pokemon("Cascoon"), 
				new Pokemon("Dustox"), 
				new Pokemon("Lotad"), 
				new Pokemon("Lombre"), 
				new Pokemon("Ludicolo"), 
				new Pokemon("Seedot"), 
				new Pokemon("Nuzleaf"), 
				new Pokemon("Shiftry"), 
				new Pokemon("Tailow"), 
				new Pokemon("Swellow"), 
				new Pokemon("Wingull"), 
				new Pokemon("Pelipper"), 
				new Pokemon("Ralts"), 
				new Pokemon("Kirlia"), 
				new Pokemon("Gardevoir"), 
				new Pokemon("Surskit"), 
				new Pokemon("Masquerain"), 
				new Pokemon("Shroomish"), 
				new Pokemon("Breloom"), 
				new Pokemon("Slakoth"), 
				new Pokemon("Vigoroth"), 
				new Pokemon("Slaking"), 
				new Pokemon("Abra"), 
				new Pokemon("Kadabra"), 
				new Pokemon("Alakazam"), 
				new Pokemon("Nincada"), 
				new Pokemon("Ninjask"), 
				new Pokemon("Shedinja"), 
				new Pokemon("Whismur"), 
				new Pokemon("Loudred"), 
				new Pokemon("Exploud"), 
				new Pokemon("Makuhita"), 
				new Pokemon("Hariyama"), 
				new Pokemon("Goldeen"), 
				new Pokemon("Seaking"), 
				new Pokemon("Magikarp"), 
				new Pokemon("Gyrados"), 
				new Pokemon("Azurill"), 
				new Pokemon("Marill"), 
				new Pokemon("Azumarill"), 
				new Pokemon("Geodude"), 
				new Pokemon("Graveler"), 
				new Pokemon("Golem"), 
				new Pokemon("Nosepass"), 
				new Pokemon("Skitty"), 
				new Pokemon("Delcatty"), 
				new Pokemon("Zubat"), 
				new Pokemon("Golbat"), 
				new Pokemon("Crobat"), 
				new Pokemon("Tentacool"), 
				new Pokemon("Tentacruel"), 
				new Pokemon("Sableye"), 
				new Pokemon("Mawile"), 
				new Pokemon("Aron"), 
				new Pokemon("Lairon"), 
				new Pokemon("Aggron"), 
				new Pokemon("Machop"), 
				new Pokemon("Machoke"), 
				new Pokemon("Machamp"), 
				new Pokemon("Meditite"), 
				new Pokemon("Medicham"), 
				new Pokemon("Electrike"), 
				new Pokemon("Manectric"), 
				new Pokemon("Plusle"), 
				new Pokemon("Minun"), 
				new Pokemon("Magnemite"), 
				new Pokemon("Magneton"), 
				new Pokemon("Voltorb"), 
				new Pokemon("Electrode"), 
				new Pokemon("Volbeat"), 
				new Pokemon("Illumise"), 
				new Pokemon("Oddish"), 
				new Pokemon("Gloom"), 
				new Pokemon("Vileplume"), 
				new Pokemon("Bellossom"), 
				new Pokemon("Doduo"), 
				new Pokemon("Dodrio"), 
				new Pokemon("Roselia"), 
				new Pokemon("Gulpin"), 
				new Pokemon("Swalot"), 
				new Pokemon("Carvanha"), 
				new Pokemon("Sharpedo"), 
				new Pokemon("Wailmer"), 
				new Pokemon("Wailord"), 
				new Pokemon("Numel"), 
				new Pokemon("Camerupt"), 
				new Pokemon("Slugma"), 
				new Pokemon("Magcargo"), 
				new Pokemon("Torkoal"),
				new Pokemon("Grimer"), 
				new Pokemon("Muk"),
				new Pokemon("Koffing"), 
				new Pokemon("Weezing"), 
				new Pokemon("Spoink"), 
				new Pokemon("Grumpig"), 
				new Pokemon("Sandshrew"), 
				new Pokemon("Sandslash"), 
				new Pokemon("Spinda"), 
				new Pokemon("Skarmory"), 
				new Pokemon("Trapinch"), 
				new Pokemon("Vibrava"), 
				new Pokemon("Flygon"), 
				new Pokemon("Cacnea"), 
				new Pokemon("Cacturne"), 
				new Pokemon("Swablu"), 
				new Pokemon("Altaria"), 
				new Pokemon("Zangoose"), 
				new Pokemon("Seviper"), 
				new Pokemon("Lunatone"), 
				new Pokemon("Solrock"), 
				new Pokemon("Barboach"), 
				new Pokemon("Whiscash"), 
				new Pokemon("Corphish"), 
				new Pokemon("Crawdaunt"), 
				new Pokemon("Baltoy"), 
				new Pokemon("Claydol"), 
				new Pokemon("Lileep"), 
				new Pokemon("Cradily"), 
				new Pokemon("Anorith"), 
				new Pokemon("Armaldo"), 
				new Pokemon("Igglybuff"), 
				new Pokemon("Jigglypuff"), 
				new Pokemon("Wigglytuff"), 
				new Pokemon("Feebas"), 
				new Pokemon("Milotic"), 
				new Pokemon("Castform"), 
				new Pokemon("Staryu"), 
				new Pokemon("Starmie"), 
				new Pokemon("Kecleon"), 
				new Pokemon("Shuppet"), 
				new Pokemon("Banette"), 
				new Pokemon("Duskull"), 
				new Pokemon("Dusclops"), 
				new Pokemon("Tropius"), 
				new Pokemon("Chimecho"), 
				new Pokemon("Absol"), 
				new Pokemon("Vulpix"), 
				new Pokemon("Ninetales"), 
				new Pokemon("Pichu"), 
				new Pokemon("Pikachu"), 
				new Pokemon("Raichu"), 
				new Pokemon("Psyduck"), 
				new Pokemon("Golduck"), 
				new Pokemon("Wynaut"), 
				new Pokemon("Wobbuffet"), 
				new Pokemon("Natu"), 
				new Pokemon("Xatu"), 
				new Pokemon("Girafarig"), 
				new Pokemon("Phanpy"), 
				new Pokemon("Donphan"), 
				new Pokemon("Pinsir"), 
				new Pokemon("Heracross"), 
				new Pokemon("Rhyhorn"), 
				new Pokemon("Rhydon"), 
				new Pokemon("Snorunt"), 
				new Pokemon("Glalie"), 
				new Pokemon("Spheal"), 
				new Pokemon("Sealo"), 
				new Pokemon("Walrein"), 
				new Pokemon("Clamperl"), 
				new Pokemon("Huntail"), 
				new Pokemon("Gorebyss"), 
				new Pokemon("Relicanth"), 
				new Pokemon("Corsola"), 
				new Pokemon("Chinchou"), 
				new Pokemon("Lanturn"), 
				new Pokemon("Luvdisc"), 
				new Pokemon("Horsea"), 
				new Pokemon("Seadra"), 
				new Pokemon("Kingdra"), 
				new Pokemon("Bagon"), 
				new Pokemon("Shelgon"), 
				new Pokemon("Salamance"), 
				new Pokemon("Beldum"), 
				new Pokemon("Metang"), 
				new Pokemon("Metagross"), 
				new Pokemon("Regirock"), 
				new Pokemon("Regice"), 
				new Pokemon("Registeel"), 
				new Pokemon("Latias"), 
				new Pokemon("Latios"), 
				new Pokemon("Kyogre"), 
				new Pokemon("Groudon"), 
				new Pokemon("Rayquaza"), 
				new Pokemon("Jirachi"), 
				new Pokemon("Deoxys")
    	};
    	
    	allPoke = temp;
    	
    	int booleanNum = ((int)(Math.random() * 101));
    	if(booleanNum >= 70)
    		pokeBoolean = true;
    	else
    		pokeBoolean = false;
    	
		if(pokeBoolean)
		{
			int pokeIndex = ((int)(Math.random() * 202));
			pokemon = allPoke[pokeIndex];
		}
    }
    
    /**
	 * returns null for the color so the gif isn't distorted
	 * @return the color of the gif
	 */
    public Color getColor()
	{
		return null;
	}	
    
    /**
     * Returns the Pokemon assigned to the Grass object
     * @return the Pokemon assigned to the Grass object
     */
    public Pokemon getPokemon()
    {
    	return pokemon;
    }
    
    /**
     * Returns if there is a Pokemon assigned to the Grass object
     * @return if there is a Pokemon assigned to the Grass object
     */
    public boolean getPokeBoolean()
    {
    	return pokeBoolean;
    }
}