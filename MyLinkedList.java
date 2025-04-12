public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T value;
        Node next, prev;
        Node(T val) { value = val; }
    }

    private Node head, tail;
    private int size = 0;

    public void add(T item) {
        addLast(item);
    }

    public void addFirst(T item) {
        Node node = new Node(item);
        if (head == null) head = tail = node;
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addLast(T item) {
        Node node = new Node(item);
        if (tail == null) head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void add(int index, T item) {
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            Node current = getNode(index);
            Node node = new Node(item);
            node.prev = current.prev;
            node.next = current;
            current.prev.next = node;
            current.prev = node;
            size++;
        }
    }

    public void set(int index, T item) {
        getNode(index).value = item;
    }

    public T get(int index) {
        return getNode(index).value;
    }

    public T getFirst() { return head.value; }

    public T getLast() { return tail.value; }

    public void remove(int index) {
        Node node = getNode(index);
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;
        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;
        size--;
    }

    public void removeFirst() { remove(0); }

    public void removeLast() { remove(size - 1); }

    public void sort() { /* skip for simplicity */ }

    public int indexOf(Object obj) {
        Node curr = head;
        for (int i = 0; curr != null; curr = curr.next, i++)
            if (curr.value.equals(obj)) return i;
        return -1;
    }

    public int lastIndexOf(Object obj) {
        Node curr = tail;
        for (int i = size - 1; curr != null; curr = curr.prev, i--)
            if (curr.value.equals(obj)) return i;
        return -1;
    }

    public boolean exists(Object obj) {
        return indexOf(obj) != -1;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node curr = head;
        for (int i = 0; i < size; i++) {
            arr[i] = curr.value;
            curr = curr.next;
        }
        return arr;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() { return size; }

    private Node getNode(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) node = node.next;
        return node;
    }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            Node current = head;
            public boolean hasNext() { return current != null; }
            public T next() {
                T val = current.value;
                current = current.next;
                return val;
            }
        };
    }
}