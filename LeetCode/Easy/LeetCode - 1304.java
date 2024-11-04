class Solution {
    /*
     * 양수와 음수를 같은 절댓값의 쌍으로 배열에 넣는다.
     * n이 홀수이면 남은 한 위치에 0을 넣어 전체 합을 0으로 만든다.
     */
    public int[] sumZero(int n) {
        int[] answer = new int[n];
        int index = 0;

        for (int value = 1; index + 1 < n; value++) {
            answer[index++] = value;
            answer[index++] = -value;
        }

        return answer;
    }
}
