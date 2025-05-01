class Solution {
    /*
     * 방문하지 않은 컴퓨터에서 DFS를 시작한다.
     * 한 번의 DFS가 하나의 연결된 네트워크 전체를 방문한다.
     */
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networks = 0;

        for (int computer = 0; computer < n; computer++) {
            if (!visited[computer]) {
                networks++;
                dfs(computer, computers, visited);
            }
        }

        return networks;
    }

    private void dfs(int current, int[][] computers, boolean[] visited) {
        visited[current] = true;

        for (int next = 0; next < computers.length; next++) {
            if (computers[current][next] == 1 && !visited[next]) {
                dfs(next, computers, visited);
            }
        }
    }
}
