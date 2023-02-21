import java.util.Arrays;

public class MyStack <V>{
    static int n=0;
    public   Object[] array=new Object[n];

    public  Object[]  push(V value){
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
    public int size(){
        return n;
    }
    public   Object[]  clear(){
        n=0;
        array=Arrays.copyOf(array,n);
        return array;
    }
    public V peek(){
        return (V) array[n-1];
    }
    public V  pop(){
        V temp= (V) array[n-1];
        array = Arrays.copyOf(array, array.length-1);
        n--;
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
