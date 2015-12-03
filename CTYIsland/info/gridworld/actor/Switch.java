//---------------------------------------------------
//Switch		A tile that can be turned on and off
//---------------------------------------------------

package info.gridworld.actor;

public class Switch extends Actor
{
	private boolean state = true;
	
	public void act(){
	
	}
	
	//********************
	//flips the switch
	//********************
	public void flip(){
		state = !state;
	}
	
	//********************
	//Returns trueif the switch is on
	//********************
	public String getState(){
		if(state)
			return "ON";
		else
			return "OFF";
	}
	
	//********************
	//Sets the state to on or off
	//********************
	public void setState(boolean farm){
		state = farm;
	}
}