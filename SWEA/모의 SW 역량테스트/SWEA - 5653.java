import java.io.*;
import java.util.*;

class Solution {
    static class Cell {
        int life;
        int born;

        Cell(int life, int born) {
            this.life = life;
            this.born = born;
        }
    }

    /*
     * 세포는 생성 후 생명력 시간만큼 비활성, 이후 첫 활성 시간에 네 방향으로 번식한다.
     * 같은 시간에 같은 칸을 노리면 생명력이 큰 세포만 생성하고 K시간 후 살아 있는 세포를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rows = Integer.parseInt(st.nextToken());
            int cols = Integer.parseInt(st.nextToken());
            int hours = Integer.parseInt(st.nextToken());

            Map<Long, Cell> cells = new HashMap<>();

            for (int row = 0; row < rows; row++) {
                st = new StringTokenizer(br.readLine());

                for (int col = 0; col < cols; col++) {
                    int life = Integer.parseInt(st.nextToken());

                    if (life > 0) cells.put(key(row, col), new Cell(life, 0));
                }
            }

            for (int time = 1; time <= hours; time++) {
                Map<Long, Integer> candidates = new HashMap<>();

                for (Map.Entry<Long, Cell> entry : cells.entrySet()) {
                    Cell cell = entry.getValue();

                    if (cell.born + cell.life != time) continue;

                    int row = row(entry.getKey());
                    int col = col(entry.getKey());

                    for (int direction = 0; direction < 4; direction++) {
                        long target = key(
                                row + dr[direction],
                                col + dc[direction]
                        );

                        if (cells.containsKey(target)) continue;

                        candidates.put(
                                target,
                                Math.max(
                                        candidates.getOrDefault(target, 0),
                                        cell.life
                                )
                        );
                    }
                }

                for (Map.Entry<Long, Integer> candidate : candidates.entrySet()) {
                    cells.put(
                            candidate.getKey(),
                            new Cell(candidate.getValue(), time)
                    );
                }
            }

            int answer = 0;

            for (Cell cell : cells.values()) {
                if (cell.born + cell.life * 2 > hours) answer++;
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static long key(int row, int col) {
        return ((long) row << 32) ^ (col & 0xffffffffL);
    }

    static int row(long key) {
        return (int) (key >> 32);
    }

    static int col(long key) {
        return (int) key;
    }
}
