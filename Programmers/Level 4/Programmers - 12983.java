import java.util.*;

class Solution {
    /*
     * dp[index]에 문자열 앞 index글자를 만드는 최소 조각 수를 저장한다.
     * 각 위치에서 사전 조각이 일치하면 조각 길이만큼 뒤 상태를 갱신한다.
     */
    public int solution(String[] strs, String t) {
        int[] dp = new int[t.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 4);
        dp[0] = 0;

        Set<String> pieces = new HashSet<>(Arrays.asList(strs));

        for (int start = 0; start < t.length(); start++) {
            if (dp[start] >= Integer.MAX_VALUE / 4) continue;

            for (int length = 1; length <= 5 && start + length <= t.length(); length++) {
                if (pieces.contains(t.substring(start, start + length))) {
                    dp[start + length] = Math.min(
                            dp[start + length],
                            dp[start] + 1
                    );
                }
            }
        }

        return dp[t.length()] >= Integer.MAX_VALUE / 4
                ? -1 : dp[t.length()];
    }
}
