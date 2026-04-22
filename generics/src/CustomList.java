import java.util.AbstractList;
import java.util.LinkedList;

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

    public void addLast(T item)
    {
        if (first == null)
        {
            first = new Node(item);
            last = first;
            return;
        }
        last.next = new Node(item);
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
            return;
        }
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
        return ret;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
