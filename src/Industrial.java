import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;



public class Industrial extends Zone {
	private static final Color COLOR = Color.red;
	// Constructor
	public Industrial(int pixWidth, int pixHeight) {
		super(pixWidth, pixHeight,COLOR);
		
	}

	// Draw the zone as a rectangle with the assigned color
	@Override
	public void drawSelf(Graphics g,int x, int y) {
		g.setColor(color);
		g.fillRect(x, y, pixWidth, pixHeight);
	}

	// Generate a neighbor object with the assigned probabilities
	@Override
	public Zone generateNeighbor() {
        Double rand = Math.random()*100+1;

        int choice = rand.intValue();

		// If the random number is less than 20, generate a new HighDenResidential zone
		if (choice < 20) {
			return new HighDenResidential(pixWidth, pixHeight);
		}
		// If the random number is less than 25, generate a new AverageDenResidential zone
		else if (choice < 25) {
			return new AverageDenResidential(pixWidth, pixHeight);
		}
		// If the random number is less than 45, generate a new Commercial zone
		else if (choice < 45) {
			return new Commercial(pixWidth, pixHeight);
		}
		// If the random number is less than 95, generate a new Industrial zone
		else if (choice < 95) {
			return new Industrial(pixWidth, pixHeight);
		}
		// Otherwise, generate a new RecreationSpace zone
		else {
			return new RecreationSpace(pixWidth, pixHeight);
		}
	}
}
