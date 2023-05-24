import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public abstract class Zone {
    protected int pixWidth;
    protected int pixHeight;
    protected Color color;

    //Constructor
    public Zone(int pixWidth, int pixHeight, Color color) {
        this.pixWidth = pixWidth;
        this.pixHeight = pixHeight;
        this.color = color;
    }

    // abstract methods
    public abstract void drawSelf(Graphics g,int x, int y);

    public abstract Zone generateNeighbor();

}
