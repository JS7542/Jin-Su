import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

class Solution {
    /*
     * preorder의 현재 값은 서브트리의 루트다.
     * inorder에서 루트 위치를 찾아 왼쪽과 오른쪽 구간을 재귀적으로 구성한다.
     */
    private int preorderIndex;
    private final Map<Integer, Integer> inorderIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) inorderIndex.put(inorder[i], i);
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;

        int value = preorder[preorderIndex++];
        TreeNode root = new TreeNode(value);
        int mid = inorderIndex.get(value);

        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);
        return root;
    }
}
