import java.util.Arrays;
public class MyLikedList <T>{
    private Node<T> head;
    private Node<T> tail;
    int size=0;
    public MyLikedList(Node<T> head, Node<T> tail) {
        tail=new Node<>(null, null, head);
        head=new Node<>(null, tail, null);
    }
    public MyLikedList() {
    }
    /////////////////////
    public void print(){
    }
    public void add(T t) {
        Node<T> temp=new Node<T>(t);
        if (head == null) {
            head=temp;
            tail = temp;
        } else if (size == 1) {
            tail = temp;
            head.next = temp;
            temp.previos = head;
        } else {
            Node<T> bufNod = tail;
            tail = temp;
            tail.previos = bufNod;
            bufNod.next = tail;
        }
        size++;
    }
    public void get(int index){
        //Node
    }
    int size(){
       return size;
    }
    public void ShouListForward() {
        var buffer = head;
        while (buffer != null) {
            System.out.println(buffer.item);
            buffer = buffer.next;
        }
    }
    public static void main(String[] args) {
        MyLikedList<Integer> l=new MyLikedList<Integer>();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);
        System.out.println("our land "+ l.size());
        l.ShouListForward();
    }
}