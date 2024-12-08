class Solution {
    /*
     * 가장 최근 1비트의 위치를 저장하며 오른쪽으로 비트를 이동한다.
     * 새로운 1을 만날 때 이전 위치와의 거리 최댓값을 갱신한다.
     */
    public int binaryGap(int n) {
        int previous = -1;
        int position = 0;
        int answer = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (previous != -1) answer = Math.max(answer, position - previous);
                previous = position;
            }
            n >>= 1;
            position++;
        }

        return answer;
    }
}
