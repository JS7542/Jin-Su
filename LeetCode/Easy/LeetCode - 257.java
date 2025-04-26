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
     * 루트부터 현재 노드까지의 경로 문자열을 재귀적으로 이어 붙인다.
     * 리프 노드에 도달하면 완성된 경로를 결과 리스트에 추가한다.
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        dfs(root, "", answer);
        return answer;
    }

    private void dfs(TreeNode node, String path, List<String> answer) {
        if (node == null) return;

        String current = path.isEmpty()
                ? String.valueOf(node.val)
                : path + "->" + node.val;

        if (node.left == null && node.right == null) {
            answer.add(current);
            return;
        }

        dfs(node.left, current, answer);
        dfs(node.right, current, answer);
    }
}
