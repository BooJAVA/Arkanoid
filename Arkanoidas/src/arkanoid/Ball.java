package arkanoid;

import java.awt.*;

import static arkanoid.Constants.BALL_RADIUS;

public class Ball extends GameObject
{
    double x;
    double y;
    double radius = BALL_RADIUS;
    private int xDir = -1;
    private int yDir = -1;

    public Ball (double x, double y)
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

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    public void setyDir(int yDir) { this.yDir = yDir; }

    public int getxDir() { return xDir; }

    public void invertXDir() { this.xDir *= -1; }

    public int getyDir() {
        return yDir;
    }

    public void invertYDir() {
        this.yDir *= -1;
    }


}
