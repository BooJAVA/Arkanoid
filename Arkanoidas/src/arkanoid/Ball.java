package arkanoid;

import java.awt.*;

import static arkanoid.Constants.BALL_RADIUS;

public class Ball extends GameObject
{
    double x;
    double y;
    int radius = BALL_RADIUS;
    private int xDir = -1;
    private int yDir = -1;

    public Ball (int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    double left() { return x - radius; }

    double right() { return x + radius; }

    double top() { return y - radius; }

    double bottom() { return y + radius; }

    public double getX() { return x; }

    public double getY() { return y; }

    public void setX(double x) { this.x = x; }

    public void setY(double y) { this.y = y; }

    public int getxDir() { return xDir; }

    public void setxDir(int xDir) { this.xDir = xDir; }

    public void invertXDir() { this.xDir *= -1; }

    public int getyDir() {
        return yDir;
    }

    public void setyDir(int yDir) { this.yDir = yDir; }

    public void invertYDir() {
        this.yDir *= -1;
    }


}
