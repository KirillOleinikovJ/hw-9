import java.util.Arrays;

public class MyQueue<V> {
    static int n=0;
    public   Object[] array=new Object[n];
    public  Object[]  add(V value){
        array = Arrays.copyOf(array, array.length + 1);
        array[n]=value;
        n++;
        return array;
    }
    public int size(){
        return n;
    }
    public V  poll(){
         V temp= (V) array[0];
        for (int i = 0; i < array.length-1; i++) {
            array[i]=array[i+1];
        }
        array = Arrays.copyOf(array, array.length-1);
        n--;
        return temp;
    }
    public V peek(){
        return (V) array[0];
    }
    public   Object[]  clear(){
        n=0;
        array=Arrays.copyOf(array,n);
        return array;
    }
    public static void main(String[] args) {
        MyQueue<Integer> queue=new MyQueue<>();
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

