public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>();
        arr.add(5); arr.add(3); arr.add(4);
        arr.sort();
        for (int x : arr) System.out.print(x + " ");
        System.out.println();

        MyStack<String> stack = new MyStack<>();
        stack.push("A"); stack.push("B");
        System.out.println(stack.pop());

        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("X"); queue.enqueue("Y");
        System.out.println(queue.dequeue());

        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(4); heap.add(2); heap.add(3);
        System.out.println(heap.removeMin());
    }
}