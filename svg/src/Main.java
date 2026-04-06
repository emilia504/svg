public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!\n");
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
        Segment s1 = new Segment();
        s1.a = point1;
        s1.b = point2;
        System.out.println(s1.length());
    }

}