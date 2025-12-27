import java.util.*;

class Solution {
    /*
     * dp[i]는 문자열 앞 i개 문자를 단어들로 나눌 수 있는지 나타낸다.
     * 가능한 이전 경계와 사전에 존재하는 부분문자열을 확인해 DP를 갱신한다.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (dp[start] && words.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
