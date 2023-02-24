import java.util.*;

public class MyArrayList<E> {
    private int size;
    public Object[] array;

    public MyArrayList() {
        array = new Object[size];
        size = 0;
    }

    public void add(E value) {
        array = Arrays.copyOf(array, array.length + 1);
        array[size] = value;
        size++;

    }

    public Object remove(int index) {
        Object temp = array[index];
        for (int i = index + 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
        array = Arrays.copyOf(array, array.length - 1);
        size--;
        return temp;
    }

    public void clear() {
        size = 0;
        array = new Object[size];

    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                return array[i];
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public static void main(String[] args) {
        MyArrayList<String> myArray = new MyArrayList<>();
        myArray.add("ssa");
        myArray.add("1");
        myArray.add("sasa");
        myArray.add("aaaaa");
        System.out.println("myArray.remove(2) = " + myArray.remove(2));
        for (int i = 0; i < myArray.size(); i++) {
            System.out.println(myArray.get(i));
        }
        System.out.println(myArray.size());
        System.out.println(myArray.get(2));
        myArray.clear();
        for (int i = 0; i < myArray.size(); i++) {
            System.out.println(myArray.get(i));
        }

    }
}
