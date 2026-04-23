class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    public Node(int val) { this.val = val; }
}

class Solution {
    /*
     * 완전 이진 트리의 한 레벨을 next 포인터로 순회한다.
     * 각 노드의 두 자식과 이웃 노드의 자식을 연결한 뒤 다음 레벨로 내려간다.
     */
    public Node connect(Node root) {
        if (root == null) return null;

        Node level = root;

        while (level.left != null) {
            Node current = level;

            while (current != null) {
                current.left.next = current.right;

                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                current = current.next;
            }

            level = level.left;
        }

        return root;
    }
}
