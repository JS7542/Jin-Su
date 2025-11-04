class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    public Node(int val) { this.val = val; }
    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

class Solution {
    /*
     * 현재 레벨의 next 포인터를 따라가며 다음 레벨 노드들을 더미 노드 뒤에 연결한다.
     * 레벨이 끝나면 더미의 next를 다음 레벨 시작점으로 사용한다.
     */
    public Node connect(Node root) {
        Node levelStart = root;

        while (levelStart != null) {
            Node dummy = new Node(0);
            Node tail = dummy;

            for (Node current = levelStart; current != null; current = current.next) {
                if (current.left != null) {
                    tail.next = current.left;
                    tail = tail.next;
                }

                if (current.right != null) {
                    tail.next = current.right;
                    tail = tail.next;
                }
            }

            levelStart = dummy.next;
        }

        return root;
    }
}
