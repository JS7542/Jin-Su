import java.util.*;

class Solution {
    /*
     * 차수가 1인 잎 노드부터 층별로 제거한다.
     * 노드가 두 개 이하로 남았을 때의 중심 노드들이 최소 높이 트리의 루트다.
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> graph = new ArrayList<>();

        for (int node = 0; node < n; node++) graph.add(new HashSet<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();

        for (int node = 0; node < n; node++) {
            if (graph.get(node).size() == 1) leaves.add(node);
        }

        int remaining = n;

        while (remaining > 2) {
            remaining -= leaves.size();
            List<Integer> nextLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);

                if (graph.get(neighbor).size() == 1) nextLeaves.add(neighbor);
            }

            leaves = nextLeaves;
        }

        return leaves;
    }
}
