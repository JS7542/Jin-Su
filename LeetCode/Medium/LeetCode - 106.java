import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    /*
     * 중위 순회에서 각 값의 위치를 해시맵에 저장한다.
     * 후위 순회를 뒤에서 읽어 루트를 만들고 오른쪽·왼쪽 서브트리 순으로 재귀 생성한다.
     */
    private int postIndex;
    private int[] postorder;
    private Map<Integer, Integer> inorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.postIndex = postorder.length - 1;
        this.inorderIndex = new HashMap<>();

        for (int index = 0; index < inorder.length; index++) {
            inorderIndex.put(inorder[index], index);
        }

        return build(0, inorder.length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) return null;

        int value = postorder[postIndex--];
        TreeNode root = new TreeNode(value);
        int middle = inorderIndex.get(value);

        root.right = build(middle + 1, right);
        root.left = build(left, middle - 1);

        return root;
    }
}
