public class Main {
    public static void main(String[] args) {
        testLab1();
    }

    private static void testLab1() {
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

        Segment s1=new Segment(point1, point2);
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