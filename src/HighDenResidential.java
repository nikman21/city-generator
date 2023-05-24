import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;



public class HighDenResidential extends Zone {
    // The color for the HighDenResidential zone
    private static final Color COLOR = Color.darkGray;

    //Constructor
    public HighDenResidential(int pixWidth, int pixHeight) {
        super(pixWidth, pixHeight, COLOR);
    }

    //Draw the zone with its assigned color
    @Override
    public void drawSelf(Graphics g,int x, int y) {
        g.setColor(color);
        g.fillRect(x, y, pixWidth, pixHeight);
    }

    //Generate a new neighbor zone based on probabilities
    @Override
    public Zone generateNeighbor() {
 
        Double rand = Math.random()*100+1;

        int choice = rand.intValue();

        // If the random number is less than 40, generate a new HighDenResidential zone
        if (choice < 40) {
            return new HighDenResidential(pixWidth, pixHeight);
        }
        // If the random number is less than 60, generate a new AverageDenResidential zone
        else if (choice < 60) {
            return new AverageDenResidential(pixWidth, pixHeight);
        }
        // If the random number is less than 80, generate a new Commercial zone
        else if (choice < 80) {
            return new Commercial(pixWidth, pixHeight);
        }
        // If the random number is less than 90, generate a new Industrial zone
        else if (choice < 90) {
            return new Industrial(pixWidth, pixHeight);
        }
        // Otherwise, generate a new RecreationSpace zone
        else {
            return new RecreationSpace(pixWidth, pixHeight);
        }
    }
}
