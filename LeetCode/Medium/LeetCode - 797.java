import java.util.*;

class Solution {
    /*
     * 0번 정점에서 시작해 인접 정점을 따라 DFS를 수행한다.
     * 마지막 정점에 도달하면 현재 경로를 복사해 결과에 추가한다.
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        search(0, graph, path, answer);

        return answer;
    }

    private void search(
            int node,
            int[][] graph,
            List<Integer> path,
            List<List<Integer>> answer
    ) {
        if (node == graph.length - 1) {
            answer.add(new ArrayList<>(path));
            return;
        }

        for (int next : graph[node]) {
            path.add(next);
            search(next, graph, path, answer);
            path.remove(path.size() - 1);
        }
    }
}
