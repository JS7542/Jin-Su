import java.io.*;
import java.util.*;

class Main {
    /*
     * 매일 아직 방문하지 않은 나라에서 BFS로 국경을 열 수 있는 연합을 찾는다.
     * 연합 인구를 평균으로 갱신하고 더 이상 이동이 없을 때까지 날짜를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int minimum = Integer.parseInt(st.nextToken());
        int maximum = Integer.parseInt(st.nextToken());

        int[][] population = new int[size][size];

        for (int row = 0; row < size; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < size; col++) {
                population[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (true) {
            boolean[][] visited = new boolean[size][size];
            boolean moved = false;

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (visited[row][col]) continue;

                    List<int[]> union = new ArrayList<>();
                    Queue<int[]> queue = new ArrayDeque<>();

                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                    int sum = 0;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        union.add(current);
                        sum += population[current[0]][current[1]];

                        for (int direction = 0; direction < 4; direction++) {
                            int nr = current[0] + dr[direction];
                            int nc = current[1] + dc[direction];

                            if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
                            if (visited[nr][nc]) continue;

                            int difference = Math.abs(
                                    population[current[0]][current[1]]
                                            - population[nr][nc]
                            );

                            if (difference < minimum || difference > maximum) continue;

                            visited[nr][nc] = true;
                            queue.offer(new int[]{nr, nc});
                        }
                    }

                    if (union.size() > 1) {
                        moved = true;
                        int average = sum / union.size();

                        for (int[] country : union) {
                            population[country[0]][country[1]] = average;
                        }
                    }
                }
            }

            if (!moved) break;
            days++;
        }

        System.out.print(days);
    }
}
