//------------------------------------------------
//
// CTYIsland_AllOneWorld
//
//------------------------------------------------

import info.gridworld.grid.*;
import info.gridworld.actor.*;

import java.util.*;
import java.io.*;
import java.awt.Color;

public class CTYIsland_AllOneWorld_3
{	
	public static void main(String[] args) throws FileNotFoundException
	{
		int x, y, a, leftLimit;
		final int XMAX = 118;
		final int YMAX = 94;
		char code;
		String line;
		
		Grid<Actor> gr = new BoundedGrid(YMAX , XMAX);
		ActorWorld overWorld = new ActorWorld(gr);
		Scanner map = new Scanner(new File("Map.txt"));
		Scanner pie = new Scanner(new File("American Pie.txt"));

		a = 0;
		
		//Puts in the base world as per the Map.txt file
		for(y = 0; y < YMAX; y++){
			line = map.nextLine();
			for(x= 0; x < XMAX*2; x++){
				code = line.charAt(x);
				if(code == '\t')
					a++;
				if(code == 'W')
					overWorld.add(new Location(y , x-a) , new Sea());
				else if(code == 'R')
					overWorld.add(new Location(y , x-a) , new Rock());
				else if(code == 'X')
					overWorld.add(new Location(y , x-a) , new Field());
				else if(code == 'F')
					overWorld.add(new Location(y , x-a) , new Forest());
				else if(code == 'T')
					overWorld.add(new Location(y , x-a) , new ForestTree());
				else if(code == 'S')
					overWorld.add(new Location(y , x-a) , new Sand());
				else if(code == 'B')
					overWorld.add(new Location(y , x-a) , new Swamp());
				else if(code == 'G')
					overWorld.add(new Location(y , x-a) , new Ground());
				else if(code == 'P')
					overWorld.add(new Location(y , x-a) , new Path());
				else if(code == 'A')
					overWorld.add(new Location(y , x-a) , new Grass());
				else if(code == 'M')
					overWorld.add(new Location(y , x-a) , new Meadow());
				else if(code != '\t')
					overWorld.add(new Location(y , x-a) , new Fog());
			}
			a = 0;
		}
		
		//puts trees in the forest according to the morse code translation of "American Pie"
		a = 0;
		line = pie.nextLine();
		
		for(y = 14; y < 79; y+=2){
			for(x = 15; x < 96; x++){
				if(gr.get(new Location(y , x)) instanceof Forest) {
				     if(line.charAt(a) == '.'){
				        overWorld.add( new Location( y , x ) , new ForestTree());
				     }
				}
				     a++;
			}
		}
			
		SmartBug alice = new SmartBug();
		overWorld.add(new Location(14 , 66), alice);  
		
		overWorld.show();
	}
}