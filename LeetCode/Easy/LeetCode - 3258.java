class Solution {
    /*
     * 각 시작 위치에서 끝 위치를 늘리며 0과 1의 개수를 센다.
     * 두 개수가 모두 k를 초과하기 전까지의 부분문자열을 결과에 더한다.
     */
    public int countKConstraintSubstrings(String s, int k) {
        int answer = 0;

        for (int start = 0; start < s.length(); start++) {
            int zero = 0;
            int one = 0;

            for (int end = start; end < s.length(); end++) {
                if (s.charAt(end) == '0') zero++;
                else one++;

                if (zero > k && one > k) break;
                answer++;
            }
        }

        return answer;
    }
}
