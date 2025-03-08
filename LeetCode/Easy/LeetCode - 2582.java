class Solution {
    /*
     * 한 방향 이동 횟수는 n-1이고 그때마다 방향이 반전된다.
     * 완전한 구간 수의 홀짝과 남은 이동으로 현재 위치를 계산한다.
     */
    public int passThePillow(int n, int time) {
        int length = n - 1;
        int rounds = time / length;
        int remaining = time % length;

        return rounds % 2 == 0 ? remaining + 1 : n - remaining;
    }
}
