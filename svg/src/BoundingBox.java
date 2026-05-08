public record BoundingBox(double x, double y, double width, double height) {
    /*
        słowo kluczowe record sprawia, że pola klasy zostaną utworzone jako private final
        utworzone zostaną do nich gettery wywoływane bez słowa get np. name()
        wygenerowane zostaną: konstruktor ze wszystkimi parametrami oraz metody equals(), hashCode() i toString()
     */

}
