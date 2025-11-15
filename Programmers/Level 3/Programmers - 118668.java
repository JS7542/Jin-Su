import java.util.*;

class Solution {
    /*
     * 알고력과 코딩력을 상태로 두고 목표 능력치까지의 최소 시간을 DP로 계산한다.
     * 1씩 공부하는 행동과 현재 풀 수 있는 문제 풀이 행동을 모두 전이한다.
     */
    public int solution(int alp, int cop, int[][] problems) {
        int targetAlp = alp;
        int targetCop = cop;

        for (int[] problem : problems) {
            targetAlp = Math.max(targetAlp, problem[0]);
            targetCop = Math.max(targetCop, problem[1]);
        }

        alp = Math.min(alp, targetAlp);
        cop = Math.min(cop, targetCop);

        int[][] dp = new int[targetAlp + 1][targetCop + 1];

        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE / 4);

        dp[alp][cop] = 0;

        for (int currentAlp = alp; currentAlp <= targetAlp; currentAlp++) {
            for (int currentCop = cop; currentCop <= targetCop; currentCop++) {
                int current = dp[currentAlp][currentCop];

                if (currentAlp < targetAlp) {
                    dp[currentAlp + 1][currentCop] = Math.min(
                            dp[currentAlp + 1][currentCop],
                            current + 1
                    );
                }

                if (currentCop < targetCop) {
                    dp[currentAlp][currentCop + 1] = Math.min(
                            dp[currentAlp][currentCop + 1],
                            current + 1
                    );
                }

                for (int[] problem : problems) {
                    if (currentAlp < problem[0] || currentCop < problem[1]) continue;

                    int nextAlp = Math.min(targetAlp, currentAlp + problem[2]);
                    int nextCop = Math.min(targetCop, currentCop + problem[3]);

                    dp[nextAlp][nextCop] = Math.min(
                            dp[nextAlp][nextCop],
                            current + problem[4]
                    );
                }
            }
        }

        return dp[targetAlp][targetCop];
    }
}
