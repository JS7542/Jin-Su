class Solution {
    /*
     * 연속된 0 구간 뒤에 이어지는 1 구간 길이를 각각 센다.
     * 두 구간 길이 중 작은 값의 두 배로 균형 부분문자열 길이를 계산한다.
     */
    public int findTheLongestBalancedSubstring(String s) {
        int answer = 0;
        int index = 0;

        while (index < s.length()) {
            int zeros = 0;
            int ones = 0;

            while (index < s.length() && s.charAt(index) == '0') {
                zeros++;
                index++;
            }

            while (index < s.length() && s.charAt(index) == '1') {
                ones++;
                index++;
            }

            answer = Math.max(answer, Math.min(zeros, ones) * 2);
        }

        return answer;
    }
}
