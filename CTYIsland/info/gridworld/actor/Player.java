import javax.swing.JOptionPane;

public class Player extends SmartBug
{
	ActorWorld overWorld, underWorld, currentWorld;
	boolean spaceholder = false;
	int spoons; //the currency
	
	NPC target;	//the blammo target
	
	public Player(ActorWorld over, ActorWorld under){
		super();
		overWorld = over;
		underWorld = under;
		currentWorld = under;
	}
	
	public void act(String in){
		if(in.equals("i"))
			JOptionPane.showMessageDialog(null, "spoons!");
		else if(in.equals(" ")){
			Actor neighbor = getGrid().get(getLocation().getAdjacentLocation(getDirection()));
			if(neighbor instanceof NPC)
				neighbor.converse();
			else if(neighbor instanceof Door)
				if(neighbor.getGrid() = overWorld.getGrid()){
					removeSelfFromGrid();
					putSelfInGrid(underWorld.getGrid() , getLandingLocation());
				}else{
					removeSelfFromGrid();
					putSelfInGrid(overWorld.getGrid() , getLandingLocation());
				} 
			else if(neighbor instanceof Obstacle || neighbor instanceof Terrain)
				JOptionPane.showMessageDialog(null, neighbor.getDescription());
		}
		else super.act(in);
	}
}
			
			