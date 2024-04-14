package queue;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/lru-cache/description/

class LRUCache {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private void remove(Node node) {
        cache.remove(node.key);
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    private void add(Node node) {
        cache.put(node.key, node);
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        if (cache.size() == capacity) {
            remove(tail.prev);
        }
        add(new Node(key, value));
    }
}
