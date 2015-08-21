/** 
 *	Name:Jumper
 *	Data:08.20.2015
 *	Description: A Jumper Class
 */

import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

//Jumper extends Actor
public class Jumper extends Actor
{
	//constructors
	public Jumper()
	{
		setColor(Color.orange);
	}

	public Jumper(Color bugColor)
	{
		setColor(bugColor);
	}

	//override
	public void act()
	{
		if (canMove()) {
			move();
		}
		else {
			turn();
		}
	}

	//turn 45 degrees
	public void turn()
	{
		setDirection(getDirection() + Location.HALF_RIGHT);
	}

	//move without leaving a flower
	public void move()
	{
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return;
		}
		Location loc = getLocation();
		Location next1 = loc.getAdjacentLocation(getDirection());
		Location next2 = next1.getAdjacentLocation(getDirection());
		if (gr.isValid(next2)) {
			moveTo(next2);
		}
		else {
			removeSelfFromGrid();
		}
	}

	//judge if it's can move
	public boolean canMove()
	{
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return false;
		}
		Location loc = getLocation();
		Location next1 = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next1)) {
			return false;
		}
		Actor neighbor = gr.get(next1);
		if (!((neighbor == null) || (neighbor instanceof Flower) || (neighbor instanceof Rock))) {
			return false;
		}
		Location next2 = next1.getAdjacentLocation(getDirection());
		if (!gr.isValid(next2)) {
			return false;
		}
		neighbor = gr.get(next2);
		return (neighbor == null) || (neighbor instanceof Flower);
	}

	//stop
	public void stop()
	{

	}
}

