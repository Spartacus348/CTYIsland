//------------------------------------------------
//
// CTYIsland_AllOneWorld
//
//------------------------------------------------

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Sea;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class CTYIsland_AllOneWorld_2
{	
    public static void main(String[] args)
    {
	 	int i , j, k;
		final int XAXIS1 = 10;		//semiMinor axis of the top left ellipse.
		final int YAXIS1 = 15;
		
		Point bottomLeft = new Point(6, 114);
		Point bottomCenter = new Point(60 , 403);
		Point topLeft = new Point (20 , 14);
	
      ActorWorld world = new ActorWorld();
		CircleBug alice = new CircleBug(6);
      alice.setColor(Color.ORANGE);
      CircleBug bob = new CircleBug(3);
      world.add(new Location(10, 8), alice);
      world.add(new Location(25, 25), bob);

		//-----------------------------------------
		//surrounds the island with the sea
		//-----------------------------------------
		for(k = 0; k < 4; k++){
			for(j = 0;	j < 2; j++){
				for(i = 0; i < 120; i++){
					world.add(new Location(i , 115*j+k), new Sea());
					if(i == 1){
						world.add(new Location(i, 115*j+4), new Sea());
						}
					}
				}
			}
		for(k = 0; k < 6; k++){
			for(i = 0; i < 2; i++){
				for(j = 0; j < 120; j++){
					world.add(new Location(113*i+k , j), new Sea());
					if(i > 0){
						world.add(new Location(113*i+6 , j), new Sea());
						}
					}
				}
			}
		for(i = 5; i < 114; i++){
			for(j = 100; j < 114; j++){
				if(bottomCenter.onCircle(i , j , RCIRCLE1).equals("less")){
					world.add(new Location(j , i), new Sea());
				}
			}
		}
		for(i = 3; i < 54; i++){
			for(j = 100; j < 114; j++){
				if(bottomLeft.onCircle(i , j , RCIRCLE2).equals("less")){
					world.add(new Location(j , i), new Sea());
				}
			}
		}

		//-----------------------------------
		//draws the rocky borders of the island
		//-----------------------------------
		for(i = 6; i < 104; i++){
			world.add(new Location(i , 4), new Rock());
		}
		for(j = 5; j < 115; j++){
			world.add(new Location(6 , j), new Rock());
		}
		for(i = 4; i < 15; i++){
			for(j = 100; j < 114; j++){
				if(bottomLeft.onCircle(i , j , RCIRCLE2).equals("equal")){
					world.add(new Location(j , i), new Rock());
				}
			}
		}
		for(i = 6; i < 17; i++){
			for(j = 4; j < 20; j++){
				if(topLeft.onEllipse(i , j , 10 , 15).equals("equal")){
					world.add(new Location(j , i), new Rock());
				}
			}
		}
		//ellipse 15 tall and 10 wide
     world.show();
	 }
}