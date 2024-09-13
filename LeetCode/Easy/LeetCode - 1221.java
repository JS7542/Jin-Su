class Solution {
    /*
     * L은 1을 더하고 R은 1을 빼며 현재 구간의 균형을 계산한다.
     * 균형이 0이 되는 순간마다 하나의 균형 문자열이 완성된다.
     */
    public int balancedStringSplit(String s) {
        int balance = 0;
        int answer = 0;

        for (char ch : s.toCharArray()) {
            balance += ch == 'L' ? 1 : -1;
            if (balance == 0) answer++;
        }

        return answer;
    }
}
