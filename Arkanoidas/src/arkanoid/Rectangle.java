package arkanoid;

class Rectangle extends GameObject
{

    double x;
    double y;
    double width;
    double height;

    double left() {
        return x;
    }

    double right() {
        return x + width;
    }

    double top() {
        return y - height / 2;
    }

    double bottom() {
        return y + height / 2;
    }

    public double getX() { return x; }

    public double getY() { return x; }

}