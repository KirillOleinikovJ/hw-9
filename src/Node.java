public class Node<T> {
    public  T item;
    public Node<T> next;
    public   Node<T> previos;

    public Node(T item) {
        this.item = item;
        this.next = next;
        this.previos = previos;
    }


    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public Node<T> getPrevios() {
        return previos;
    }
    public void setPrevios(Node<T> previos) {
        this.previos = previos;
    }
    public void setItem(T item) {
        this.item = item;
    }
}
