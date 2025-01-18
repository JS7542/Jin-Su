class Solution {
    /*
     * i번째 값 start+2i를 계산한다.
     * n개의 값을 모두 XOR해 결과를 반환한다.
     */
    public int xorOperation(int n, int start) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer ^= start + 2 * i;
        }

        return answer;
    }
}
