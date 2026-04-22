import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomList<T> extends AbstractList<T>
{
    private class Node
    {
        public Node next = null;
        public T item;
        public Node(T item) { this.item = item; }
        public Node(T item, Node next)
        {
            this.item = item;
            this.next = next;
        }
    }
    private Node first, last;

    private int size = 0;

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public T get(int index) {
        if (index < 0 || index >=size) {
            throw new RuntimeException("Index is either too small or too big");
        }

        Node current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.item;
    }

    public void addLast(T item)
    {
        if (first == null)
        {
            first = new Node(item);
            last = first;
            size++;
            return;
        }
        last.next = new Node(item);
        size++;
        last = last.next;

    }

    public T getLast() {
        return last.item;
    }

    public void addFirst(T item)
    {
        if (first == null)
        {
            first = new Node(item);
            last = first;
            size++;
            return;
        }
        size++;
        first = new Node(item, first);

    }

    public T getFirst()
    {
        return first.item;
    }

    public T removeFirst()
    {
        T ret = first.item;
        first = first.next;
        size--;
        return ret;
    }

    public T removeLast()
    {
        Node current = first;
        if (current.next == null)
        {
            T ret = first.item;
            first = null;
            last = null;
            return ret;
        }
        while (current.next.next != null) current = current.next;

        T ret = last.item;
        current.next = null;
        last = current;
        size--;
        return ret;
    }

    public Iterator<T> iterator(){
        Iterator<T> iterator = new Iterator<T>() {
            Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                Node help = current;
                current = current.next;
                return help.item;
            }
        };

        return iterator;
    }

    public Stream<T> stream(){
        ArrayList<T> list = new ArrayList<T>();
        Node help = first;
        while(help != null){
            list.add(help.item);
            help = help.next;
        }

        return list.stream();
    }

    public static <R> List<R> filterByType(List<R> list, Class<? extends Object> type) {
        return list.stream().filter(i -> type.isAssignableFrom(i.getClass())).collect(Collectors.toList());
    }
}
