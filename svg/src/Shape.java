public abstract class Shape {

    protected Style style = new Style("transparent", "black", 1.0);

    public abstract String toSvg();

    public abstract BoundingBox boundingBox();

    public Shape() {
        this.style = new Style("transparent", "black", 1.0);
    }

    public Shape(Style style) {
        this.style = style;
    }

    protected Style getStyle() {
        return style;
    }

}
