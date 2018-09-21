import javafx.scene.image.Image;

public class SidneyCacturne extends EliteFourPokemon {

	public SidneyCacturne() 
	{
		setName("Sidney's Cacturne");
		setLevel(46);
		setType(Type.GRASS);
		setTotalHealth((((2* 40 + 100) * getLevel())/100) + 10);
		setCurrentHealth(getTotalHealth());
		makePositive();
		setAttack((((2* 30 + 100) * getLevel())/100) + 10);
		setDefense((((2* 30 + 100) * getLevel())/100) + 10);
		Move[] moves = {
		new Move("Needle Arm", 30, 15, Type.GRASS),
		new Move("Crunch", 0, 0, Type.DARK),
		new Move("Faint Attack", 0, 0, Type.DARK),
		new Move("Double-Edge", 0, 0, Type.NORMAL)
		};
		setMoves(moves);
	}
	
	public Image getImage()
	{
		return new Image("Cacturne.png", true);
	}
}
