import java.io.*;
import java.util.*;

class Main {
    /*
     * 현재 위치에서 먹을 수 있는 물고기까지 BFS 최단 거리를 구한다.
     * 거리, 행, 열 순으로 가장 우선인 물고기를 먹고 크기와 시간을 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[][] sea = new int[size][size];
        int sharkRow = 0;
        int sharkCol = 0;

        for (int row = 0; row < size; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int col = 0; col < size; col++) {
                sea[row][col] = Integer.parseInt(st.nextToken());

                if (sea[row][col] == 9) {
                    sharkRow = row;
                    sharkCol = col;
                    sea[row][col] = 0;
                }
            }
        }

        int sharkSize = 2;
        int eaten = 0;
        int time = 0;

        while (true) {
            int[] target = findFish(sea, sharkRow, sharkCol, sharkSize);

            if (target == null) break;

            time += target[2];
            sharkRow = target[0];
            sharkCol = target[1];
            sea[sharkRow][sharkCol] = 0;
            eaten++;

            if (eaten == sharkSize) {
                sharkSize++;
                eaten = 0;
            }
        }

        System.out.print(time);
    }

    static int[] findFish(int[][] sea, int startRow, int startCol, int sharkSize) {
        int size = sea.length;
        int[][] distance = new int[size][size];

        for (int[] row : distance) Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        distance[startRow][startCol] = 0;

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        List<int[]> candidates = new ArrayList<>();
        int minimumDistance = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentDistance = distance[current[0]][current[1]];

            if (currentDistance > minimumDistance) break;

            if (sea[current[0]][current[1]] > 0
                    && sea[current[0]][current[1]] < sharkSize) {
                candidates.add(new int[]{
                    current[0], current[1], currentDistance
                });
                minimumDistance = currentDistance;
                continue;
            }

            for (int direction = 0; direction < 4; direction++) {
                int nr = current[0] + dr[direction];
                int nc = current[1] + dc[direction];

                if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
                if (distance[nr][nc] != -1 || sea[nr][nc] > sharkSize) continue;

                distance[nr][nc] = currentDistance + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        if (candidates.isEmpty()) return null;

        candidates.sort((first, second) -> {
            int rowCompare = Integer.compare(first[0], second[0]);
            return rowCompare != 0
                    ? rowCompare
                    : Integer.compare(first[1], second[1]);
        });

        return candidates.get(0);
    }
}
