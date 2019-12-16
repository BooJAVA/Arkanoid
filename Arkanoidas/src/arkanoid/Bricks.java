package arkanoid;

import static arkanoid.Constants.*;
import java.awt.*;

public class Bricks
{
    private int[][] map;
    private int brickWidth = BRICKS_WIDTH;
    private int brickHeight = BRICKS_HEIGHT;
    private int AmountOfBricks = BRICKS_ROW * BRICKS_COL;

    public Bricks (int row, int col)
    {
        map = new int[row][col];
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[0].length; j++)
            {
                map[i][j] = 1;
            }
        }
    }

    public void BrickIsDestroyed (int row, int col, boolean destroyed)
    {
        if (destroyed)
        {
            map[row][col] = 0;
            AmountOfBricks--;
        }
    }

    public int[][] getMap() { return map; }

    public int getMapHeight() { return map.length; }

    public int getMapWidth() { return map[0].length; }

    public int getBrickWidth() { return brickWidth; }

    public int getBrickHeight() {
        return brickHeight;
    }

    public int getAmountOfBricks() { return AmountOfBricks; }

    public void setAmountOfBricks(int ResetAmountOfBricks)
    {
        this.AmountOfBricks = ResetAmountOfBricks;
    }


}
