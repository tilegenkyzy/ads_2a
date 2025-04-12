public class MyStack<T> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void push(T item) { list.add(item); }

    public T pop() {
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    public T peek() { return list.getLast(); }

    public boolean isEmpty() { return list.size() == 0; }
}