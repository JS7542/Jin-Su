class Solution {
    /*
     * x의 1배부터 n배까지 계산한다.
     * int 범위를 넘을 수 있으므로 long 배열에 차례대로 저장한다.
     */
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }

        return answer;
    }
}
