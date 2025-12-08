class Solution {
    /*
     * 방문하지 않은 도시에서 DFS를 시작한다.
     * 연결된 모든 도시를 방문하는 DFS 시작 횟수가 주의 개수다.
     */
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;

        for (int city = 0; city < isConnected.length; city++) {
            if (!visited[city]) {
                provinces++;
                dfs(city, isConnected, visited);
            }
        }

        return provinces;
    }

    private void dfs(int city, int[][] graph, boolean[] visited) {
        visited[city] = true;

        for (int next = 0; next < graph.length; next++) {
            if (graph[city][next] == 1 && !visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }
}
