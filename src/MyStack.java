import java.util.Arrays;

public class MyStack<V> {
    private int size;
    public Object[] array;

    public MyStack() {
        array = new Object[size];
        size = 0;

    }

    public void push(V value) {
        array = Arrays.copyOf(array, array.length + 1);
        array[size] = value;
        size++;
    }

    public Object remove(int index) {
        for (int i = index + 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
        array = Arrays.copyOf(array, array.length - 1);
        size--;
        return array[index];
    }

    public int size() {
        return size;
    }

    public Object[] clear() {
        size = 0;
        array = Arrays.copyOf(array, size);
        return array;
    }

    public V peek() {
        return (V) array[size - 1];
    }

    public V pop() {
        V temp = (V) array[size - 1];
        array = Arrays.copyOf(array, array.length - 1);
        size--;
        return temp;
    }

    public static void main(String[] args) {
        MyStack<Boolean> stack = new MyStack<>();
        stack.push(true);
        stack.push(true);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        stack.remove(0);
        System.out.println("stack.size() = " + stack.size());
    }
}
