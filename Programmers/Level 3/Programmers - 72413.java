import java.util.*;

class Solution {
    /*
     * 모든 지점 쌍의 최소 택시비를 플로이드-워셜로 계산한다.
     * 각 지점을 합승 종료 지점으로 가정한 총비용의 최솟값을 구한다.
     */
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int INF = 1_000_000_000;
        int[][] distance = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        for (int[] fare : fares) {
            distance[fare[0]][fare[1]] = Math.min(distance[fare[0]][fare[1]], fare[2]);
            distance[fare[1]][fare[0]] = Math.min(distance[fare[1]][fare[0]], fare[2]);
        }

        for (int middle = 1; middle <= n; middle++) {
            for (int from = 1; from <= n; from++) {
                for (int to = 1; to <= n; to++) {
                    distance[from][to] = Math.min(
                            distance[from][to],
                            distance[from][middle] + distance[middle][to]
                    );
                }
            }
        }

        int answer = INF;

        for (int split = 1; split <= n; split++) {
            answer = Math.min(
                    answer,
                    distance[s][split] + distance[split][a] + distance[split][b]
            );
        }

        return answer;
    }
}
