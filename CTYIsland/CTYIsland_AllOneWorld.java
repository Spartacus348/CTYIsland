//------------------------------------------------
//
// CTYIsland_AllOneWorld
//
//------------------------------------------------

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.*;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class CTYIsland_AllOneWorld
{	
    public static void main(String[] args)
    {
	 	int i , j, k;
		final int RCIRCLE1 = 295;		//radius of the bottom, center circle
		final int RCIRCLE2 = 10;		//radius of the bottom, left cirlce
		final int MINORELLIPSE1 = 10;	//semiminor axis of the top left ellipse "trans montem
		final int RCIRCLE3 = 7;			//radius of the top, center cirlce
		final int MINORELLIPSE2 = 13;	//semiminor axis of the top left ellipse "cis montem"
	
      ActorWorld world = new ActorWorld();
		CircleBug alice = new CircleBug(6);
      alice.setColor(Color.ORANGE);
      CircleBug bob = new CircleBug(3);
      world.add(new Location(10, 8), alice);
      world.add(new Location(25, 25), bob);

		//-----------------------------------------
		//fills the world with sea; the island will
		//be added next
		//-----------------------------------------
		for(j = 0;	j < 120; j++){
			for(i = 0; i < 120; i++){
				world.add(new Location(i , j), new Sea());
			}
		}
		//-----------------------------------
		//draws the rocky borders of the island
		//-----------------------------------
		for(i = 21; i < 104; i++){
			world.add(new Location(i , 4), new Rock());
		}
		for(j = 16; j < 115; j++){
			world.add(new Location(6 , j), new Rock());
		}
		for(i = 4; i < 25; i++){
			for(j = 100; j < 117; j++){
				if(Point.distance(i , j , 6 , 114) == RCIRCLE2){
					world.add(new Location(j , i), new Rock());
				}
			}
		}
		for(i = 16; i < 55; i++){
			for(j = 99; j < 115; j++){
				if(Point.distance(i , j , 60 , 403) == RCIRCLE1){
					world.add(new Location(j , i) , new Rock());
				}
			}
		}
		for(i = 0; i < 21; i++){
			for(j = 0; j < 16; j++){
				if(Point.distance( j , (int)(i/1.5) , 14 , 13) == MINORELLIPSE1){
					world.add(new Location(i , j), new Rock());
				}
			}
		}
		for(i = 40; i < 49; i++){
			for(j = 6; j < 20; j++){
				if(Point.distance( i , j , 40 , 12) == RCIRCLE3){
					world.add(new Location(j , i) , new Rock());
				}
			}
		}
		for(i = 17; i < 35; i++){
			for(j = 18; j < 30; j++){
				if(Point.distance( i , (int)(13 * j / 18) , 30 , 31) == MINORELLIPSE2){
					world.add(new Location( j , i ) , new Rock());
				}
			}
		}
		
		//********************************************************************
		//Draws the Ridge region
		//********************************************************************
		
		for(i = 5; i < 17; i++){
			for(j = 31; j < 77; j++){
				world.add(new Location( j , i ) , new Ground());
			}
		}
		
		//*********************************************************************
		//Draws the Quad in all its glory
		//*********************************************************************
		
		for( i = 21; i < 65; i++){
			for(j = 34; j < 80; j++){
				world.add(new Location( j , i) , new Field());
			}
		}
		
  		world.show();
   }	 
}