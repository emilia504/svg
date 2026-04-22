import java.util.*;

public class Main {

    public static void main(String[] args) {
        CustomList <Object> lista = new CustomList<>();
        lista.addLast(4);
        lista.addLast(1);
        lista.addLast(9);
        lista.addFirst(7);
        System.out.println("Size " + lista.size());
        System.out.println(lista.getFirst() +" "+ lista.getLast());
        System.out.println(lista.removeFirst());
        System.out.println(lista.getFirst() +" "+ lista.getLast());
        System.out.println(lista.removeLast());
        System.out.println(lista.getFirst() +" "+ lista.getLast());
        System.out.println(lista.removeFirst());
        System.out.println(lista.getFirst() +" "+ lista.getLast());
        System.out.println(lista.add(7));
        System.out.println(lista.get(0));
        System.out.println("Size " + lista.size());
        System.out.println();

        for(Object integer : lista){
            System.out.println(integer);
        }

        lista.add("Aaaa");
        System.out.println(lista.stream().toList());
        System.out.println(CustomList.filterByType(lista, String.class));
        System.out.println(CustomList.filterByType(lista, Integer.class));
    }

}