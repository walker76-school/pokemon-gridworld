import javafx.scene.image.Image;

public class SidneyAbsol extends EliteFourPokemon {
	
	public SidneyAbsol() 
	{
		setName("Sidney's Absol");
		setLevel(49);
		setType(Type.DARK);
		setTotalHealth((((2* 40 + 100) * getLevel())/100) + 10);
		setCurrentHealth(getTotalHealth());
		makePositive();
		setAttack((((2* 30 + 100) * getLevel())/100) + 10);
		setDefense((((2* 30 + 100) * getLevel())/100) + 10);
		Move[] moves = {
		new Move("Aerial Ace", 30, 15, Type.FLYING),
		new Move("Crunch", 0, 0, Type.DARK),
		new Move("Faint Attack", 0, 0, Type.DARK),
		new Move("Double-Edge", 0, 0, Type.NORMAL)
		};
		setMoves(moves);
	}
	
	public Image getImage()
	{
		return new Image("Absol.png", true);
	}
}
