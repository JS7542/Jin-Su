class Solution {
    /*
     * 경기 결과를 승자에서 패자로 가는 도달 가능 행렬로 표현한다.
     * 플로이드-워셜로 간접 승패 관계를 채우고 모든 다른 선수와 관계가 정해진 선수를 센다.
     */
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n + 1][n + 1];

        for (int[] result : results) win[result[0]][result[1]] = true;

        for (int middle = 1; middle <= n; middle++) {
            for (int from = 1; from <= n; from++) {
                if (!win[from][middle]) continue;

                for (int to = 1; to <= n; to++) {
                    if (win[middle][to]) win[from][to] = true;
                }
            }
        }

        int answer = 0;

        for (int player = 1; player <= n; player++) {
            int known = 0;

            for (int opponent = 1; opponent <= n; opponent++) {
                if (player != opponent
                        && (win[player][opponent] || win[opponent][player])) {
                    known++;
                }
            }

            if (known == n - 1) answer++;
        }

        return answer;
    }
}
