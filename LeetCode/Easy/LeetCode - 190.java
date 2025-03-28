class Solution {
    /*
     * 입력 정수의 비트를 낮은 자리부터 하나씩 꺼낸다.
     * 결과를 왼쪽으로 밀고 현재 비트를 붙이는 과정을 32번 반복한다.
     */
    public int reverseBits(int n) {
        int answer = 0;

        for (int i = 0; i < 32; i++) {
            answer = (answer << 1) | (n & 1);
            n >>>= 1;
        }

        return answer;
    }
}
