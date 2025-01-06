class Solution {
    /*
     * 짝수에서는 1을 선택해 홀수를 넘길 수 있고 홀수에서는 모든 약수가 홀수다.
     * 최적 플레이에서 Alice는 n이 짝수일 때만 승리한다.
     */
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}
