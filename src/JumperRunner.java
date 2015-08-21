/** 
 *	Name:JumperRunner
 *	Data:08.20.2015
 *	Description: A JumperRunner Class
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

import java.awt.Color;

//JumperRunner class, Main Class
public class JumperRunner
{
	JumperRunner() {
	}
	//Main function
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		Jumper alice = new Jumper(Color.BLUE);
		world.add(new Location(0, 0), alice);
		world.add(new Location(3, 2),new Bug());
		world.add(new Location(2, 1),new Rock());
		world.add(new Location(2, 7),new Flower());
		world.show();
	}
}
