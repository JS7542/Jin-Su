import java.io.*;
import java.util.*;

class Main {
    /*
     * 문 위치와 진행 방향을 상태로 두고 거울 설치 수를 비용으로 탐색한다.
     * 느낌표 칸에서는 직진과 두 방향 회전을 모두 시도해 다른 문까지의 최소 비용을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        char[][] house = new char[size][];
        List<int[]> doors = new ArrayList<>();

        for (int row = 0; row < size; row++) {
            house[row] = br.readLine().toCharArray();

            for (int col = 0; col < size; col++) {
                if (house[row][col] == '#') doors.add(new int[]{row, col});
            }
        }

        int[][][] distance = new int[size][size][4];

        for (int[][] row : distance) {
            for (int[] cell : row) Arrays.fill(cell, Integer.MAX_VALUE);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        int[] start = doors.get(0);
        int[] target = doors.get(1);

        for (int direction = 0; direction < 4; direction++) {
            distance[start[0]][start[1]][direction] = 0;
            deque.offer(new int[]{start[0], start[1], direction});
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int row = current[0];
            int col = current[1];
            int direction = current[2];
            int cost = distance[row][col][direction];

            int nr = row + dr[direction];
            int nc = col + dc[direction];

            if (nr < 0 || nr >= size || nc < 0 || nc >= size) continue;
            if (house[nr][nc] == '*') continue;

            if (cost < distance[nr][nc][direction]) {
                distance[nr][nc][direction] = cost;
                deque.offerFirst(new int[]{nr, nc, direction});
            }

            if (house[nr][nc] == '!') {
                for (int nextDirection : new int[]{
                        (direction + 1) % 4,
                        (direction + 3) % 4
                }) {
                    if (cost + 1 < distance[nr][nc][nextDirection]) {
                        distance[nr][nc][nextDirection] = cost + 1;
                        deque.offerLast(new int[]{nr, nc, nextDirection});
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int direction = 0; direction < 4; direction++) {
            answer = Math.min(
                    answer,
                    distance[target[0]][target[1]][direction]
            );
        }

        System.out.print(answer);
    }
}
