class Solution {
    /*
     * 조합 C(balls, share)를 곱셈과 나눗셈을 동시에 진행하며 계산한다.
     * 대칭성을 이용해 더 작은 선택 수로 계산해 중간값을 줄인다.
     */
    public int solution(int balls, int share) {
        int r = Math.min(share, balls - share);
        long answer = 1;

        for (int i = 1; i <= r; i++) {
            answer = answer * (balls - r + i) / i;
        }

        return (int) answer;
    }
}
