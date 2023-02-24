import java.util.Arrays;
import java.util.HashMap;

public class MyHashMap<K, V> {
    private Node[] container;
    private int size;
    private int capacity = 3;

    MyHashMap() {
        container = new Node[capacity];
    }

    static class Node<K, V> {
        K key;
        V value;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }

        @Override
        public String toString() {
            return "key = " + key + ", value = " + value;
        }
    }

    public void put(Object key, Object value) {
        int index = Math.abs(key.hashCode()) % container.length;
        Node<K, V> ourNode = new Node<>((K) key, (V) value);
        if (size >= container.length) {
            changeSize();
        }
        if (container[index] == null) {
            container[index] = ourNode;
            size++;
        } else {
            Node<K, V> prev = null;
            Node<K, V> current = container[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = (V) value;
                    return;
                }
                prev = current;
                current = current.next;
                if (prev != null) {
                    prev.next = ourNode;
                }
            }
            size++;
        }
    }

    public void changeSize() {
        capacity *= 2;
        Node<K, V>[] oldContainer = Arrays.copyOf(container, container.length);
        container = new Node[capacity];
        for (Node<K, V> node : oldContainer) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
        size = oldContainer.length;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        container = new Node[capacity];
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    public Object remove(K key) {
        Node<K, V> removeTable = null;
        int index = key.hashCode() % capacity;
        Node<K, V> secondTable = container[index];
        if (secondTable.key.equals(key)) {
            removeTable = container[index];
            container[index] = null;
        }
        return removeTable.key + "=" + removeTable.value;
    }

    public V get(K key) {
        Node getting = container[key.hashCode() % capacity];
        if (getting == null) {
            return null;
        }
        if (getting.key.equals(key)) {
            return (V) getting.value;
        } else {
            if (getting.next == null) {
                return null;
            }
        }
        return (V) getting.next.value;
    }

    @Override
    public boolean equals(Object obj) {
        Node<K, V> secondTable = container[size];
        if (this == obj)
            return true;
        else if (obj == null || obj.getClass() != getClass())
            return false;
        MyHashMap<K, V> myHashMap = (MyHashMap<K, V>) obj;
        return secondTable.key == myHashMap && secondTable.value == myHashMap;
    }

    @Override
    public String toString() {
        return "MyHashMap " + Arrays.toString(container);
    }

    public static void main(String[] args) {
        HashMap map = new HashMap<>();
        MyHashMap<String, Integer> myMap = new MyHashMap<>();
        myMap.put("ivan", 200);
        myMap.put("roma", 300);
        System.out.println("myMap.toString() = " + myMap.toString());
        myMap.put("maks", 400);
        myMap.put("igorr", 700);
        myMap.put("bobo", 900);
        myMap.remove("igorr");
        myMap.remove("roma");
        myMap.put("artem", 900);
        myMap.put("artem", 1900);
        System.out.println("myMap.toString() = " + myMap.toString());
        System.out.println("myMap.size() = " + myMap.size());
        System.out.println("myMap.get(\"igor\") = " + myMap.get("igorr"));
        System.out.println("myMap.get(\"roma\") = " + myMap.get("roma"));
        System.out.println("myMap.get(\"maks\") = " + myMap.get("maks"));
        System.out.println("myMap.get(\"ivan\") = " + myMap.get("ivan"));
        System.out.println("myMap.get(\"bobo\") = " + myMap.get("bobo"));
        System.out.println("myMap.get(\"artem\") = " + myMap.get("artem"));
    }
}

