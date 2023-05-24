import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;



public class RecreationSpace extends Zone {
	private static final Color COLOR = Color.blue;
    // Constructor
    public RecreationSpace(int pixWidth, int pixHeight){
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
        // Create a new Random object to generate a random number
        Double rand = Math.random()*100+1;

        int choice = rand.intValue();

        // If the random number is less than 5, generate a new HighDenResidential zone
        if (choice < 5) {
            return new HighDenResidential(pixWidth, pixHeight);
        }
        // If the random number is less than 15, generate a new AverageDenResidential zone
        else if (choice < 15) {
            return new AverageDenResidential(pixWidth, pixHeight);
        }
        // If the random number is less than 40, generate a new LowDenResidential zone
        else if (choice < 40) {
            return new LowDenResidential(pixWidth, pixHeight);
        }
        // If the random number is less than 55, generate a new Commercial zone
        else if (choice < 55) {
            return new Commercial(pixWidth, pixHeight);
        }
        // Otherwise, generate a new RecreationSpace zone
        else {
            return new RecreationSpace(pixWidth, pixHeight);
        }
    }
}
