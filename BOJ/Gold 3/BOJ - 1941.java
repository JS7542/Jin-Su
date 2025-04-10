import java.io.*;
import java.util.*;

class Main {
    static char[][] classroom = new char[5][5];
    static int answer;

    /*
     * 25자리 중 일곱 자리를 조합으로 고르며 S 학생이 네 명 이상인지 확인한다.
     * 선택된 일곱 칸이 상하좌우로 모두 연결되어 있으면 경우의 수에 포함한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int row = 0; row < 5; row++) {
            classroom[row] = br.readLine().toCharArray();
        }

        choose(0, 0, 0, 0);
        System.out.print(answer);
    }

    static void choose(int start, int count, int sCount, int mask) {
        if (count == 7) {
            if (sCount >= 4 && connected(mask)) answer++;
            return;
        }

        if (25 - start < 7 - count) return;

        for (int position = start; position < 25; position++) {
            int row = position / 5;
            int col = position % 5;

            choose(
                    position + 1,
                    count + 1,
                    sCount + (classroom[row][col] == 'S' ? 1 : 0),
                    mask | (1 << position)
            );
        }
    }

    static boolean connected(int mask) {
        int start = Integer.numberOfTrailingZeros(mask);
        int visited = 1 << start;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            int row = current / 5;
            int col = current % 5;

            for (int direction = 0; direction < 4; direction++) {
                int nr = row + dr[direction];
                int nc = col + dc[direction];

                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;

                int next = nr * 5 + nc;
                int bit = 1 << next;

                if ((mask & bit) == 0 || (visited & bit) != 0) continue;

                visited |= bit;
                queue.offer(next);
            }
        }

        return count == 7;
    }
}
