class Solution {
    /*
     * 아직 칠하지 않은 첫 구역에서 길이 m의 롤러를 사용한다.
     * 롤러가 덮은 마지막 위치를 저장하며 다음 필요한 구역만 다시 칠한다.
     */
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paintedUntil = 0;

        for (int position : section) {
            if (position > paintedUntil) {
                answer++;
                paintedUntil = position + m - 1;
            }
        }

        return answer;
    }
}
