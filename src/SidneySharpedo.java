import javafx.scene.image.Image;

public class SidneySharpedo extends EliteFourPokemon {

	public SidneySharpedo() 
	{
		setName("Sidney's Sharpedo");
		setLevel(48);
		setType(Type.WATER);
		setTotalHealth((((2* 40 + 100) * getLevel())/100) + 10);
		setCurrentHealth(getTotalHealth());
		makePositive();
		setAttack((((2* 30 + 100) * getLevel())/100) + 10);
		setDefense((((2* 30 + 100) * getLevel())/100) + 10);
		Move[] moves = {
		new Move("Surf", 30, 15, Type.WATER),
		new Move("Crunch", 0, 0, Type.DARK),
		new Move("Faint Attack", 0, 0, Type.DARK),
		new Move("Slash", 0, 0, Type.NORMAL)
		};
		setMoves(moves);
	}
	
	public Image getImage()
	{
		return new Image("Sharpedo.png", true);
	}
}
