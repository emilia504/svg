public class Point {
    public double x=5;
    public double y=10;

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
