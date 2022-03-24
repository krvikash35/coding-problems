import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

}

public class LRUCache {

    private final int capacity;
    private Map<Integer, Node> cache = new HashMap<>();
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node node = new Node(key, value);
            if (cache.size() == capacity) {
                cache.remove(tail.key);
                cache.put(key, node);
                removeFromTail();
                addToHead(node);
            } else {
                cache.put(key, node);
                addToHead(node);
            }
        }
    }

    private void moveToHead(Node node) {
        if (head == tail) {// single element

        } else if (head.next == tail.prev) {// two element

        } else {
            node.prev.next = node.next;
            node.prev = null;
            node.next = head;
            head = node;
        }
    }

    private void addToHead(Node node) {
        node.next = head;
        node.prev = null;
        head = node;
    }

    private void removeFromTail() {
        if (head == tail) { // single element
            head = null;
            tail = null;
        }
        tail = tail.prev;
        tail.next = null;
    }

}
