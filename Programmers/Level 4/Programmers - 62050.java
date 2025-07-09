import java.util.*;

class Solution {
    static class Edge {
        int first;
        int second;
        int cost;

        Edge(int first, int second, int cost) {
            this.first = first;
            this.second = second;
            this.cost = cost;
        }
    }

    /*
     * 높이 차가 height 이하인 칸들을 BFS로 같은 지형 영역으로 묶는다.
     * 영역 사이 가능한 사다리 비용을 간선으로 수집하고 크루스칼 MST 비용을 구한다.
     */
    public int solution(int[][] land, int height) {
        int size = land.length;
        int[][] group = new int[size][size];
        int groupCount = labelGroups(land, height, group);

        if (groupCount == 1) return 0;

        List<Edge> edges = new ArrayList<>();
        int[] dr = {1, 0};
        int[] dc = {0, 1};

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                for (int direction = 0; direction < 2; direction++) {
                    int nr = row + dr[direction];
                    int nc = col + dc[direction];

                    if (nr >= size || nc >= size) continue;
                    if (group[row][col] == group[nr][nc]) continue;

                    edges.add(new Edge(
                            group[row][col],
                            group[nr][nc],
                            Math.abs(land[row][col] - land[nr][nc])
                    ));
                }
            }
        }

        edges.sort(Comparator.comparingInt(edge -> edge.cost));

        int[] parent = new int[groupCount];
        for (int value = 0; value < groupCount; value++) parent[value] = value;

        int answer = 0;
        int selected = 0;

        for (Edge edge : edges) {
            int firstRoot = find(parent, edge.first);
            int secondRoot = find(parent, edge.second);

            if (firstRoot == secondRoot) continue;

            parent[secondRoot] = firstRoot;
            answer += edge.cost;

            if (++selected == groupCount - 1) break;
        }

        return answer;
    }

    private int labelGroups(int[][] land, int height, int[][] group) {
        int size = land.length;
        int groupNumber = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (group[row][col] != 0) continue;

                groupNumber++;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{row, col});
                group[row][col] = groupNumber;

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();

                    for (int direction = 0; direction < 4; direction++) {
                        int nr = current[0] + dr[direction];
                        int nc = current[1] + dc[direction];

                        if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
                        if (group[nr][nc] != 0) continue;
                        if (Math.abs(land[current[0]][current[1]] - land[nr][nc]) > height) continue;

                        group[nr][nc] = groupNumber;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) group[row][col]--;
        }

        return groupNumber;
    }

    private int find(int[] parent, int value) {
        if (parent[value] == value) return value;
        return parent[value] = find(parent, parent[value]);
    }
}
