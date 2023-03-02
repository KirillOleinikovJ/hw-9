import java.util.*;

public class MyArrayList<E> {
    private final int ARRAY_LENGTH=10;
    public Object[] array;
    private int size;
    public MyArrayList() {
       this. array = new Object[ARRAY_LENGTH];
        this.size = 0;
    }

    public void add(E value) {
        if (size < array.length) {
            array[size++] = value;
            return;
        }
        resizeMyArray(size * 2);
        array[size++] = value;
    }
    private void resizeMyArray(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public Object remove(int index) {
        Objects.checkIndex(index, size);
        E temp=(E) array[index];
        array = Arrays.copyOf(array, array.length-1);
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

    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) array[index];
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
