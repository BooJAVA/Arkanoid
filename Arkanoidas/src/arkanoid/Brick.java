package arkanoid;

import static arkanoid.Constants.*;
import java.awt.*;

public class Brick extends Rectangle
{
    private int AmountOfBricks = BRICKS_ROW * BRICKS_COL;

    public Brick (double x, double y)
    {
        this.x = x;
        this.y = y;
        this.width = BRICKS_WIDTH;
        this.height = BRICKS_HEIGHT;

    }

    public void drawBrick (Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect((int) left(), (int) top(), (int) width, (int) height);
    }


    public void BrickIsDestroyed (boolean destroyed)
    {
        if (destroyed)
        {
            AmountOfBricks--;
        }
    }

    public int getAmountOfBricks() { return AmountOfBricks; }

    public void setAmountOfBricks(int ResetAmountOfBricks)
    {
        this.AmountOfBricks = ResetAmountOfBricks;
    }


}
