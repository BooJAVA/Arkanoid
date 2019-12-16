package arkanoid;

class Rectangle extends GameObject
{

    int x;
    int y;
    int width;
    int height;

    double left() { return x; }

    double right() { return x + width; }

    double top() { return y; }

    double bottom() { return y + height; }

    public int getX() { return x; }

    public int getY() { return y; }

}