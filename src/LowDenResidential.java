import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;


public class LowDenResidential extends Zone {
	private static final Color COLOR = Color.lightGray;
    // Constructor
    public LowDenResidential(int pixWidth, int pixHeight) {
        super(pixWidth, pixHeight, COLOR);
        
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

        // If the random number is less than 20, generate a new AverageDenResidential zone
        if (choice < 20) {
            return new AverageDenResidential(pixWidth, pixHeight);
        }
        // If the random number is less than 60, generate a new LowDenResidential zone
        else if (choice < 60) {
            return new LowDenResidential(pixWidth, pixHeight);
        }
        // If the random number is less than 65, generate a new Commercial zone
        else if (choice < 65) {
            return new Commercial(pixWidth, pixHeight);
        }
        // Otherwise, generate a new RecreationSpace zone
        else {
            return new RecreationSpace(pixWidth, pixHeight);
        }
    }
}

