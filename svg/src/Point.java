public class Point {

    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(Point oldP) {
        this.x = oldP.x;
        this.y = oldP.y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public String toString() {
        String napis = "x=" + this.x + " y=" + y;
        return napis;
    }

    public String toSvg() {
        String napis = "<circle r=\"45\" cx=\"" + x + "\" cy=\"" + y + "\" fill=\"red\" />";
        return napis;
    }

    public void translate(double dx, double dy) {
        x = x + dx;
        y += dy;
    }

    public Point translated(double dx, double dy) {
        Point point = new Point();
        point.x += dx;
        point.y += dy;
        return point;
    }

}
