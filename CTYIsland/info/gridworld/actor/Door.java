public class Door extends Obstacle
{
	Door brother;
	Location landingPad;
	
	public Door(Door other, Location spot){
		brother = other;
		landingPad = spot;
	}
	
	public Location getLandingLocation(){
		return LandingPad();
	}
}