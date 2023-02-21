import java.util.*;
public  class MyArrayList <E> {
    static int n=0;
    public   Object[] array=new Object[n];;

     public   Object[]  add(E value){
        array = Arrays.copyOf(array, array.length + 1);
        array[n]=value;
        n++;
        return array;
    }
    public    Object[]  remove(int index){
        for (int i = index+1; i < array.length; i++) {
            array[i-1]=array[i];
        }
        array = Arrays.copyOf(array, array.length-1);
        n--;
        return array;
    }
    public   Object[]  clear(){
        n=0;
        array=Arrays.copyOf(array,n);
        return array;
    }
    public  int size(){
         return array.length;
    }
    public  Object get(int index){
        return array[index];
    }
    public static void main(String[] args) {
        MyArrayList myArray = new MyArrayList<String>();
        myArray.add("ssa");
        myArray.add("1");
        myArray.add("sasa");
        myArray.add("aaaaa");
       // MyArrayList.clear();
        for (int i = 0; i < myArray.size(); i++) {
            System.out.println(myArray.get(i));
        }
        System.out.println(myArray.size());
        System.out.println(myArray.get(3));
    }
}
