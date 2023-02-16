import java.util.Objects;

public class MyLikedList <T>  {
    private Node<T> head;
    private Node<T> tail;
    int size=0;
    public MyLikedList() {
    }
    /////////////////////
    private Node<T> getCurrentByIndex(int index) {
        Node<T> current = head;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current;

    }
    public void add(T element) {
        Node<T> temp=new Node<T>(element);
        if (size==0) {
            head=tail=temp;
        } else if (size == 1) {
            tail = temp;
            head.next = temp;
            temp.previos = head;
        }   else {
            Node<T> bufNod = tail;
            tail = temp;
            tail.previos = bufNod;
            bufNod.next = tail;
        }
        size++;
    }
    public int size(){
        return size;
    }
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T remItem;
        if (index == 0) {
            remItem = head.item;
            head = head.next;
            head.previos = null;
            if (head == null) {
                tail = null;
            }
        } else {
            Node<T> prevOfDelete = getCurrentByIndex(index - 1);
            remItem = prevOfDelete.next.item;
            prevOfDelete = prevOfDelete.next.next;
            prevOfDelete = prevOfDelete.previos.previos;
            if (index == size - 1) {
                tail = prevOfDelete;
            }
        }
        size--;
        return remItem;
    }
    public T get(int index){
        Objects.checkIndex(index, size);
       Node<T> temp=head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return (T) temp.item;
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
        l.remove(3);
        System.out.println("our land "+ l.size());
        System.out.println("our element "+ l.get(2));
        l.ShouListForward();
    }
}