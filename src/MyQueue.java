import java.util.Arrays;

public class MyQueue<V> {
    private int size;
    public Object[] array;

    public MyQueue() {
        array = new Object[size];
        size = 0;

    }

    public void add(V value) {
        array = Arrays.copyOf(array, array.length + 1);
        array[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public V poll() {
        V temp = (V) array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array = Arrays.copyOf(array, array.length - 1);
        size--;
        return temp;
    }

    public V peek() {
        return (V) array[0];
    }

    public void clear() {
        size = 0;
        array=new Object[size];

    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(150);
        queue.add(250);
        queue.add(350);
        queue.add(450);
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.peak() = " + queue.peek());
        queue.clear();
        queue.add(150);
        queue.add(250);
        queue.add(350);
        queue.add(450);
    }
}

