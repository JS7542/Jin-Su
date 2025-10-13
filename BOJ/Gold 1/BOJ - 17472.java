import java.io.*;
import java.util.*;

class Main {
    static class Edge {
        int first;
        int second;
        int length;

        Edge(int first, int second, int length) {
            this.first = first;
            this.second = second;
            this.length = length;
        }
    }

    /*
     * 섬을 BFS로 번호 매기고 각 육지 칸에서 직선으로 길이 2 이상인 다리를 탐색한다.
     * 섬 사이 후보 다리를 크루스칼 알고리즘으로 연결해 최소 총길이를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        int[][] map = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < cols; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int islands = label(map);
        List<Edge> edges = findEdges(map);

        edges.sort(Comparator.comparingInt(edge -> edge.length));

        int[] parent = new int[islands + 1];

        for (int island = 1; island <= islands; island++) parent[island] = island;

        int total = 0;
        int selected = 0;

        for (Edge edge : edges) {
            int firstRoot = find(parent, edge.first);
            int secondRoot = find(parent, edge.second);

            if (firstRoot == secondRoot) continue;

            parent[secondRoot] = firstRoot;
            total += edge.length;
            selected++;

            if (selected == islands - 1) break;
        }

        System.out.print(selected == islands - 1 ? total : -1);
    }

    static int label(int[][] map) {
        int rows = map.length;
        int cols = map[0].length;
        int number = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (map[row][col] != 1) continue;

                number++;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{row, col});
                map[row][col] = number + 1;

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();

                    for (int direction = 0; direction < 4; direction++) {
                        int nr = current[0] + dr[direction];
                        int nc = current[1] + dc[direction];

                        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                        if (map[nr][nc] != 1) continue;

                        map[nr][nc] = number + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (map[row][col] > 1) map[row][col]--;
            }
        }

        return number;
    }

    static List<Edge> findEdges(int[][] map) {
        int rows = map.length;
        int cols = map[0].length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        List<Edge> edges = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int startIsland = map[row][col];

                if (startIsland == 0) continue;

                for (int direction = 0; direction < 4; direction++) {
                    int nr = row + dr[direction];
                    int nc = col + dc[direction];
                    int length = 0;

                    while (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                        if (map[nr][nc] == startIsland) break;

                        if (map[nr][nc] > 0) {
                            if (length >= 2) {
                                edges.add(new Edge(
                                        startIsland,
                                        map[nr][nc],
                                        length
                                ));
                            }
                            break;
                        }

                        length++;
                        nr += dr[direction];
                        nc += dc[direction];
                    }
                }
            }
        }

        return edges;
    }

    static int find(int[] parent, int value) {
        if (parent[value] == value) return value;
        return parent[value] = find(parent, parent[value]);
    }
}
