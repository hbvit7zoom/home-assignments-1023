package home;

import java.util.Objects;

public class CustomLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    static class Node<T> {
        T value;

        Node<T> previous;

        Node<T> next;
    }

    public int size() {
        return size;
    }

    public boolean add(T item) {
        Node<T> node = new Node<>();
        node.value = item;

        if (first == null) {
            first = node;
            last = node;
        } else {
            node.previous = last;
            last.next = node;
            last = node;
        }
        size++;

        return true;

//        1 < - 2  < - 3
//          - >    - >
    }

    public int indexOf(T item) {
        int index = -1;

        if (size != 0) {
            Node<T> current = first;
            int currentIndex = 0;
            while (current != null) {
//                if (current.value.equals(item)) {
                if (Objects.equals(item, current.value)) {
                    return currentIndex;
                }
                current = current.next;
                currentIndex++;
            }
        }

        return index;
    }
}
