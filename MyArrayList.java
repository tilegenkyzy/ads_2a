public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[10];
        size = 0;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < size; i++) newData[i] = data[i];
            data = newData;
        }
    }

    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    public void set(int index, T item) {
        data[index] = item;
    }

    public void add(int index, T item) {
        ensureCapacity();
        for (int i = size; i > index; i--) data[i] = data[i - 1];
        data[index] = item;
        size++;
    }

    public void addFirst(T item) { add(0, item); }

    public void addLast(T item) { add(item); }

    public T get(int index) { return (T) data[index]; }

    public T getFirst() { return get(0); }

    public T getLast() { return get(size - 1); }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++) data[i] = data[i + 1];
        size--;
    }

    public void removeFirst() { remove(0); }

    public void removeLast() { remove(size - 1); }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T a = (T) data[j];
                T b = (T) data[j + 1];
                if (a.compareTo(b) > 0) {
                    data[j] = b;
                    data[j + 1] = a;
                }
            }
        }
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) if (data[i].equals(obj)) return i;
        return -1;
    }

    public int lastIndexOf(Object obj) {
        for (int i = size - 1; i >= 0; i--) if (data[i].equals(obj)) return i;
        return -1;
    }

    public boolean exists(Object obj) { return indexOf(obj) != -1; }

    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) result[i] = data[i];
        return result;
    }

    public void clear() { size = 0; }

    public int size() { return size; }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int i = 0;
            public boolean hasNext() { return i < size; }
            public T next() { return (T) data[i++]; }
        };
    }
}