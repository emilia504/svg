import java.util.Locale;

public class Ellipse extends Shape {

    private Point center;
    private double rx;
    private double ry;
    private Style style = new Style("transparent", "black", 1.0);

    public Ellipse(double rx, double ry, Point center) {
        this.rx = rx;
        this.ry = ry;
        this.center = new Point(center);
    }

    @Override
    public String toSvg() {
        return String.format(Locale.ENGLISH, "<ellipse rx=\"%f\" ry=\"%f\" cx=\"%f\" cy=\"%f\" %s />",
                rx, ry, center.getX(), center.getY(), super.getStyle().toSvg());
    }

    @Override
    public BoundingBox boundingBox() {
        double x = center.getX() - rx;
        double y = center.getY() - ry;
        double width = rx * 2;
        double height = ry * 2;
        return new BoundingBox(x, y, width, height);
    }

}