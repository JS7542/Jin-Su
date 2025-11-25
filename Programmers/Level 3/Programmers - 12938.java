class Solution {
    /*
     * 합이 고정되어 있을 때 곱을 최대화하려면 원소 차이를 최소화해야 한다.
     * s를 n으로 나눈 몫을 기본값으로 두고 나머지만 뒤쪽 원소에 1씩 더한다.
     */
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1};

        int[] answer = new int[n];
        int base = s / n;
        int remainder = s % n;

        for (int i = 0; i < n; i++) {
            answer[i] = base + (i >= n - remainder ? 1 : 0);
        }

        return answer;
    }
}
