import java.awt.Color;

import info.gridworld.actor.Rock;

/**
 * Tree object which funcitons as a border to the world
 * @author Andrew
 *
 */
public class Tree extends Rock{
	
	/**
	 * instantiates a tree
	 */
	public Tree()
	{
		
	}
	
	/**
	 * returns null for the color so the gif isn't distorted
	 */
	public Color getColor()
	{
		return null;
	}
}
