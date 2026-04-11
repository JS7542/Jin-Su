import java.util.*;

class LRUCache {
    /*
     * HashMap으로 키의 노드를 즉시 찾고, 이중 연결 리스트로 최근 사용 순서를 관리한다.
     * 조회·삽입 시 노드를 맨 앞으로 옮기고 용량 초과 시 맨 뒤 노드를 제거한다.
     */
    private static class Node {
        int key;
        int value;
        Node previous;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> nodes = new HashMap<>();
    private final Node head = new Node(0, 0);
    private final Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        Node node = nodes.get(key);
        if (node == null) return -1;

        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = nodes.get(key);

        if (node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }

        Node created = new Node(key, value);
        nodes.put(key, created);
        addAfterHead(created);

        if (nodes.size() > capacity) {
            Node removed = tail.previous;
            remove(removed);
            nodes.remove(removed.key);
        }
    }

    private void moveToFront(Node node) {
        remove(node);
        addAfterHead(node);
    }

    private void addAfterHead(Node node) {
        node.previous = head;
        node.next = head.next;
        head.next.previous = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
}
