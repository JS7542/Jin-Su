class Solution {
    /*
     * n의 비트를 오른쪽부터 확인하며 위치의 홀짝을 구분한다.
     * 1인 비트가 있는 짝수 위치와 홀수 위치 개수를 각각 센다.
     */
    public int[] evenOddBit(int n) {
        int[] answer = new int[2];
        int position = 0;

        while (n > 0) {
            if ((n & 1) == 1) answer[position % 2]++;
            n >>= 1;
            position++;
        }

        return answer;
    }
}
