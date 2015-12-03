/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * A <code>Bug</code> is an actor that can move and turn. It drops flowers as
 * it moves. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class SmartBug extends Bug
{
	char code = 'T';
	char place = 'T';
	ActorWorld world;
	 
	 /**
     * Constructs a red bug.
     */
    public SmartBug()
    {
        setColor(Color.RED);
		  world = new ActorWorld(getGrid());
    }

    /**
     * Constructs a bug of a given color.
     * @param bugColor the color for this bug
     */
    public SmartBug(Color bugColor)
    {
        setColor(bugColor);
		  world = new ActorWorld(getGrid());
    }

    /**
     * Turns the bug 45 degrees to the right without changing its location.
	 */
  
    public void turn()
    {
        setDirection(getDirection() + Location.RIGHT);
    }

    /**
     * Moves the bug forward, replacing what it previously walked over.
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
		  if(!canMove())
		  		return;
        if (gr.isValid(next)){
		  		if(gr.get(next) instanceof Sea)
					code = 'W';
				else if(gr.get(next) instanceof Rock)
					code = 'R';
				else if(gr.get(next) instanceof Field)
					code = 'X';
				else if(gr.get(next) instanceof Forest)
					code = 'F';
				else if(gr.get(next) instanceof ForestTree)
					code = 'T';
				else if(gr.get(next) instanceof Sand)
					code = 'S';
				else if(gr.get(next) instanceof Swamp)
					code = 'B';
				else if(gr.get(next) instanceof Ground)
					code = 'G';
				else if(gr.get(next) instanceof Path)
					code = 'P';
				else if(gr.get(next) instanceof Grass)
					code = 'A';
				else if(gr.get(next) instanceof Meadow)
					code = 'M';
				else code = 'F';
            moveTo(next);
			}
         else
            removeSelfFromGrid();
			if(place == 'X'){
				Field field = new Field();
				field.putSelfInGrid(gr , loc);
			}
			else if(place == 'F'){
				Forest forest = new Forest();
				forest.putSelfInGrid(gr , loc);
			}
			else if(place == 'S'){
				Sand sand = new Sand();
				sand.putSelfInGrid(gr , loc);
			}
			else if(place == 'B'){
				Swamp swamp  = new Swamp();
				swamp.putSelfInGrid(gr , loc);
			}
			else if(place == 'G'){
				Ground ground = new Ground();
				ground.putSelfInGrid(gr , loc);
			}
			else if(place == 'P'){
				Path path = new Path();
				path.putSelfInGrid(gr , loc);
			}
			else if(place == 'A'){
				Grass grass = new Grass();
				grass.putSelfInGrid(gr , loc);
			}
			else if(place == 'M'){
				Meadow meadow = new Meadow();
				meadow.putSelfInGrid(gr , loc);
			}
			else if(place != '\t'){
				Fog fog = new Fog();
				fog.putSelfInGrid(gr , loc);
			}
			place = code;
    }

    /**
     * Tests whether this bug can move forward into a location that is empty or
     * contains a type of terrain.
     * @return true if this bug can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Terrain);
        // ok to move into empty location or onto a Terrain Tile
        // not ok to move onto any other actor
    }
	 
	public void putSelfInGrid(Grid<Actor> gr, Location loc){
		super.putSelfInGrid(gr , loc);
		world = new ActorWorld(gr);
	}
	
	public void act(String in){
		if(in.equals("w")){
			setDirection(Location.NORTH);
			move();
		}
		else if(in.equals("d")){
			setDirection(Location.EAST);
			move();
		}
		else if(in.equals("s")){
			setDirection(Location.SOUTH);
			move();
		}
		else if(in.equals("a")){
			setDirection(Location.WEST);
			move();
		}
		else super.act();
	}
}
