//----------------------------------------
//
// Acts as a cell in Conway's Game of Life
//
//-----------------------------------------

package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

import info.gridworld.actor.Bug;


public class Life extends Bug
{
    private int numLive;
    private int numDead;
	 Location here;

    public Life(){
	 	setColor(Color.WHITE);
		here = getLocation();
    }

    /**Changes the color of the actor based on the four rules:
	 	1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
		2. Any live cell with two or three live neighbours lives on to the next generation.
		3. Any live cell with more than three live neighbours dies, as if by overcrowding.
		4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	 **/
    public void act(){
	 	Grid<Actor> gr = getGrid();	
		numLive = 0;
		numDead = 0;
		
		for(int i = 0; i < 360; i+=45){
			if(!canMove() && gr.isValid(here.getAdjacentLocation(i))){
				Life life = new Life();
				life.putSelfInGrid(gr , here.getAdjacentLocation(i));
			}
			this.turn();
		}
  
   	for(int i = 0; i < 360; i+=45){
		 	if(canMove() && gr.get(here.getAdjacentLocation(i)).getColor()== Color.BLACK)
				numDead++;
			else if(canMove() && gr.get(here.getAdjacentLocation(i)).getColor()== Color.GREEN)
				numLive++;
			this.turn();
		}
		
		if(numLive < 2){
			setColor(Color.WHITE);
		}
		else if(numLive == 2 && this.getColor() == Color.GREEN){
		}
		else if(numLive > 3){
			setColor(Color.WHITE);
		}
		else if(numLive == 3){
			setColor(Color.GREEN);
		}
    }
	
	//------------------------------
	//manually kills the cell
	//------------------------------ 
	public void kill(){
	 	this.setColor(Color.WHITE);
	}
	
	//------------------------------
	//manually gives the cell life
	//------------------------------
	public void create(){
		this.setColor(Color.GREEN);
	}
}
