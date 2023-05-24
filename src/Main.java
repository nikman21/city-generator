/* 
 * Name: Nikolas Manuel
 * Date: 2/20/2023
 * Class: CPI 221
 * Assignment 2
 * Description:use Slick2D and a 2D array to generate a simple City out of simple zoning types. Each Zone type will be a polymorphic class. There will be very low user interaction. 
 * 
 * */
import org.newdawn.slick.*;
import java.util.Random;
import javax.swing.JOptionPane;

public class Main extends BasicGame {
    private static final int TILE_SIZE = 20;
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;

    private Zone[][] world;

    public Main(String title) {
        super("Basic Procedural Generation");
    }

    @Override
    public void init(GameContainer container) throws SlickException {

        // Ask user for size of world
        int worldWidth = getUserInput("Enter world width (between 20 and 50): ", 20, 50);
        int worldHeight = getUserInput("Enter world height (between 20 and 50): ", 20, 50);
        world = new Zone[worldWidth][worldHeight];

        // Divide screen width/height by user inputed size
        int tileWidth = SCREEN_WIDTH / worldWidth;
        int tileHeight = SCREEN_HEIGHT / worldHeight;

        // Create first piece of Zone in upper left corner
        Random random = new Random();
        int zoneType = random.nextInt(6);
        switch (zoneType) {
            case 0:
                world[0][0] = new HighDenResidential(tileWidth, tileHeight);
                break;
            case 1:
                world[0][0] = new AverageDenResidential(tileWidth, tileHeight);
                break;
            case 2:
                world[0][0] = new LowDenResidential(tileWidth, tileHeight);
                break;
            case 3:
                world[0][0] = new Commercial(tileWidth, tileHeight);
                break;
            case 4:
                world[0][0] = new Industrial(tileWidth, tileHeight);
                break;
            case 5:
                world[0][0] = new RecreationSpace(tileWidth, tileHeight);
                break;
        }

       
        // Special case for first row
        for (int x = 1; x < worldWidth; x++) {
            world[x][0] = world[x - 1][0].generateNeighbor();
        }
        // Subsequent rows
        for (int y = 1; y < worldHeight; y++) {
            world[0][y] = world[0][y-1].generateNeighbor();
            for (int x = 1; x < worldWidth; x++){
            	world[x][y] = world[x-1][y].generateNeighbor();	
                
            	Zone left = world[x-1][y];
                Zone up = world[x][y-1];
             
                int choice = random.nextInt(2);
                if (choice == 0.5) {
                    world[x][y] = left.generateNeighbor();
                } else {
                    world[x][y] = up.generateNeighbor();
                }
            }
        }
    }
    
    private int getUserInput(String message, int min, int max) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(message);
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // Ignore invalid input
            }
        }
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException{
    	// Render each Zone in world
    	for (int y = 0; y < world[0].length; y++) {
    		for (int x = 0; x < world.length; x++) {
    			world[x][y].drawSelf(g, x * TILE_SIZE, y * TILE_SIZE);
    		}
    	}
    }
    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        // Not needed for this game
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new Main("Basic Procedural Generation"));
            app.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}


