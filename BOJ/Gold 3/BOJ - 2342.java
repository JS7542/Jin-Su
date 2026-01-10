import java.io.*;
import java.util.*;

class Main {
    /*
     * 입력 순서마다 왼발·오른발 위치별 최소 힘을 DP로 관리한다.
     * 다음 발판을 왼발 또는 오른발로 밟는 두 전이를 비교해 최솟값을 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> commands = new ArrayList<>();

        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());

            if (value == 0) break;

            commands.add(value);
        }

        int infinity = 1_000_000_000;
        int[][] dp = new int[5][5];

        for (int[] row : dp) Arrays.fill(row, infinity);

        dp[0][0] = 0;

        for (int command : commands) {
            int[][] next = new int[5][5];

            for (int[] row : next) Arrays.fill(row, infinity);

            for (int left = 0; left < 5; left++) {
                for (int right = 0; right < 5; right++) {
                    if (dp[left][right] == infinity) continue;

                    next[command][right] = Math.min(
                            next[command][right],
                            dp[left][right] + cost(left, command)
                    );

                    next[left][command] = Math.min(
                            next[left][command],
                            dp[left][right] + cost(right, command)
                    );
                }
            }

            dp = next;
        }

        int answer = infinity;

        for (int[] row : dp) {
            for (int value : row) answer = Math.min(answer, value);
        }

        System.out.print(answer);
    }

    static int cost(int from, int to) {
        if (from == 0) return 2;
        if (from == to) return 1;
        if (Math.abs(from - to) == 2) return 4;

        return 3;
    }
}
