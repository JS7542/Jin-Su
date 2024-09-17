class Solution {
    /*
     * 전체 1의 개수를 오른쪽 점수로 시작하고 왼쪽에서 문자를 하나씩 이동시킨다.
     * 왼쪽 0 개수와 오른쪽 1 개수 합의 최댓값을 구한다.
     */
    public int maxScore(String s) {
        int rightOnes = 0;
        for (char ch : s.toCharArray()) if (ch == '1') rightOnes++;

        int leftZeros = 0;
        int answer = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') leftZeros++;
            else rightOnes--;

            answer = Math.max(answer, leftZeros + rightOnes);
        }

        return answer;
    }
}
