import java.util.Comparator;

public class MyTreeSet<T> {

    private Node<T> root;
    private Comparator<T> comparator;
    private int size;

    static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;
        Node<T> parent;
    }

    public MyTreeSet(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void add(T item) {
        checkElement(item);

        Node<T> node = new Node<>();
        node.value = item;

        if (root == null) {
            root = node;
            size++;
        }

        Node<T> current = root;

        while (true) {
            int compare = comparator.compare(item, current.value);

            if (compare == 0) {
                return;
            }

            if (compare < 0) {
                if (current.left == null) {
                    current.left = node;
                    current.left.parent = current;
                    size++;
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = node;
                    current.right.parent = current;
                    size++;
                    break;
                } else {
                    current = current.right;
                }
            }
        }

    }

    public int getSize() {
        return size;
    }

    public boolean contains(T item) {

        checkElement(item);

        if (root == null) {
            return false;
        }
        Node<T> current = root;

        while (true) {
            int compare = comparator.compare(item, current.value);

            if (compare == 0) {
                return true;
            }

            if (compare < 0) {
                if (current.left == null) {
                    return false;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    return false;
                } else {
                    current = current.right;
                }
            }
        }
    }

    public boolean remove(T item) {
        checkElement(item);

        boolean contains = contains(item);

        if (!contains) {
            return false;
        }

        Node<T> current = root;

        while (true) {
            int compare = comparator.compare(item, current.value);

            boolean leftIsAbsent = current.left == null;
            boolean rightIsAbsent = current.right == null;

            if (compare == 0) {
                if (leftIsAbsent && rightIsAbsent) {
                    if (current.parent.left.equals(current)) {
                        current.parent.left = null;
                        return true;
                    }
                    if (current.parent.right.equals(current)) {
                        current.parent.right = null;
                        return true;
                    }
                }
            }

            if (compare < 0) {
                if (leftIsAbsent) {
                    return false;
                } else {
                    current = current.left;
                }
            } else {
                if (rightIsAbsent) {
                    return false;
                } else {
                    current = current.right;
                }
            }
        }
    }

    private void checkElement(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }
}
