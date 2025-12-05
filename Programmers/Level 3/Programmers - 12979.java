class Solution {
    /*
     * 기존 기지국의 전파 범위를 제외하고 남는 연속 구간 길이를 계산한다.
     * 새 기지국 하나가 덮는 길이 2W+1로 각 빈 구간을 올림 나눗셈한다.
     */
    public int solution(int n, int[] stations, int w) {
        int coverage = w * 2 + 1;
        int answer = 0;
        int start = 1;

        for (int station : stations) {
            int end = station - w - 1;

            if (start <= end) {
                int length = end - start + 1;
                answer += (length + coverage - 1) / coverage;
            }

            start = station + w + 1;
        }

        if (start <= n) {
            int length = n - start + 1;
            answer += (length + coverage - 1) / coverage;
        }

        return answer;
    }
}
