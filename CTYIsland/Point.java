//----------------------------------------
//
//Helps make geometric shapes in gridworld
//
//----------------------------------------

import java.awt.Color;


public abstract class Point
{	 
	int xCoordinate, yCoordinate;
	static int distance;
	
	//-------------------------------------------
	// returns the distance between two points
	//-------------------------------------------
	public static int distance(int xOne , int yOne, int xTwo, int yTwo){
		distance = (int)(Math.sqrt((xOne - xTwo)*(xOne - xTwo) + (yOne - yTwo)*(yOne - yTwo)));
		return distance;
	}
	
	//-------------------------------------------
	// says where a point lies relative to an ellipse
	//-------------------------------------------
	//public String onEllipse(int x, int y, int xAxis, int yAxis){
	//	distance = (int)(Math.sqrt((x - xCoordinate) * (x - xCoordinate) / xAxis + (y - yCoordinate) * (y - yCoordinate) / yAxis));
	//	if(distance > 1)
	//		statement = "greater";
	//	else if(distance == 1)
	//		statement = "equal";
	//	else if(distance < 1)
	//		statement = "less";
	//	return statement;
	//}
}