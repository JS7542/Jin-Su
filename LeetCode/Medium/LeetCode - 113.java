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
     * 현재 경로와 남은 목표 합을 DFS로 전달한다.
     * 리프에서 목표가 정확히 맞으면 경로를 복사하고 탐색 후 현재 노드를 제거한다.
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), answer);
        return answer;
    }

    private void dfs(
            TreeNode node,
            int remaining,
            List<Integer> path,
            List<List<Integer>> answer
    ) {
        if (node == null) return;

        path.add(node.val);
        remaining -= node.val;

        if (node.left == null && node.right == null && remaining == 0) {
            answer.add(new ArrayList<>(path));
        } else {
            dfs(node.left, remaining, path, answer);
            dfs(node.right, remaining, path, answer);
        }

        path.remove(path.size() - 1);
    }
}
