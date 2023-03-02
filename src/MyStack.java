import java.util.Arrays;
import java.util.Objects;

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

    public V remove(int index) {
        Objects.checkIndex(index, size);
        V temp=(V) array[index];
        array = Arrays.copyOf(array, array.length-1);
        size--;
        return temp;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size=0;
        array=new Object[size];
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
