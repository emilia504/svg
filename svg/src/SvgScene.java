import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class SvgScene {
    private int index = 0;
    //private Polygon[] polygons = new Polygon[3];
    private final int size = 10;
    private Shape[] shapes = new Shape[size];

    public void addShape(Shape shape) {
//        if (index >= polygons.length) {
//            this.index = 0;
//            this.polygons[index] = polygon;
//            this.index++;
//        }
//        else {
//            this.polygons[index] = polygon;
//            this.index++;
//        }
        //polygons[(index++) % 3] = polygon;
        shapes[(index++) % size] = shape;
    }

    @Override
    public String toString() {
        return "SvgScene{" +
                "index=" + index +
                ", polygons=" + Arrays.toString(shapes) +
                '}';
    }

    public String toSvg() {
        //String result = "<svg xmlns=\"http://www.w3.org/2000/svg\">";
        BoundingBox boundingBox = this.sceneBox();
        String result = String.format(Locale.ENGLISH,
                "<svg width=\"%f\" height=\"%f\" xmlns=\"http://www.w3.org/2000/svg\">",
                boundingBox.width(), boundingBox.height());
        for (var shape : shapes) {
            if (shape != null)
                result += "\n\t" + shape.toSvg();
        }
        result += "\n</svg>";
        return result;
    }

    private BoundingBox sceneBox() {
        double maxX = 0, maxY = 0;
        for (Shape shape : shapes) {
            if (shape != null) {
                BoundingBox polygonBB = shape.boundingBox();
                maxX = Math.max(maxX, polygonBB.x() + polygonBB.width());
                maxY = Math.max(maxY, polygonBB.y() + polygonBB.height());
            }
        }
        return new BoundingBox(0, 0, maxX, maxY);
    }

    public void save(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        writer.write(toSvg());
        writer.close();
    }

}
