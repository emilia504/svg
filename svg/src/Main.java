public class Main {
    public static void main(String[] args) {
        testLab1();
    }

    private static void testLab1() {
        //lab1I2DoZad2();
        Point[] points = {
                new Point(10.0, 50.0),
                new Point(50.0, 100.0),
                new Point(100.0, 150.0)
        };

        Polygon polygon = new Polygon(points);
        System.out.println(polygon);
        System.out.println(polygon.toSvg());
//        points[2] = new Point(2.0, 5.7);
        points[2].setX(5.0);
        points[2].setY(7.4);
        System.out.println(polygon);
        System.out.println(polygon.toSvg());

        Polygon p1 = new Polygon(new Point[]{new Point(2.0, 6.5)});
        Polygon p2 = new Polygon(new Point[]{new Point(3.0, 5.5)});
        Polygon p3 = new Polygon(new Point[]{new Point(4.0, 8.5)});

        SvgScene scene = new SvgScene();
        scene.addPolygon(p1);
        scene.addPolygon(p2);
        scene.addPolygon(p3);
        System.out.println(scene);

        Polygon p4 = new Polygon(new Point[]{new Point(2.0, 10.5)});
        scene.addPolygon(p4);
        System.out.println(scene);
    }

    private static void lab1I2DoZad2() {
        Point point = new Point();
        /*
        To działało, gdy pola były publiczne
        System.out.println(point.x + " " + point.y);
        point.x = 7;
        System.out.println(point.x + " " + point.y);
         */
        System.out.println(point.getX() + " " + point.getY());
        point.setX(7);
        System.out.println(point.getX() + " " + point.getY());
        Point point1 = new Point();
        System.out.println(point1.toString());
        System.out.println(point1.toSvg());

        Point point2 = new Point();
        System.out.println("Punkt oryginalny");
        System.out.println(point2);
        System.out.println("Punkt przesunięty");
        point2.translate(1, 1);
        System.out.println(point2);
        System.out.println(point2.translated(2, 2));
  /*
        --Lab 1 - pola publiczne--
        Segment s1 = new Segment();
        s1.a = point1;
        s1.b = point2;
        System.out.println(s1.length());
        Segment s2 = new Segment();
        s2.a = point2;
        s2.b = point;
        Segment s3 = new Segment();
        s3.a = point1;
        s3.b = point;
*/

        Segment s1 = new Segment(point1, point2);
        System.out.println(s1);
        point1.setX(100.0);
        System.out.println(s1);
        System.out.println(s1.length());
        Segment s2 = new Segment(new Point(3.5, 5.3), new Point(4.2, 2.4));
        System.out.println(s2);
        Segment s3 = new Segment(point1, point);
        System.out.println(s3);
        // Tworzenie tablicy Segmentów
        Segment[] segments = {s1, s2, s3};

        // Znajdowanie i wyświetlanie najdłuższego segmentu
        Segment longest = Segment.findLongestSegment(segments);
        System.out.println("Longest segment length: " + longest.length());
    }

}