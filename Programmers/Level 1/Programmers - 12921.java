class Solution {
    /*
     * 에라토스테네스의 체로 2부터 n까지의 합성수를 표시한다.
     * 표시되지 않은 수의 개수를 세어 소수 개수를 반환한다.
     */
    public int solution(int n) {
        boolean[] composite = new boolean[n + 1];

        for (int number = 2; number * number <= n; number++) {
            if (composite[number]) continue;
            for (int multiple = number * number; multiple <= n; multiple += number) {
                composite[multiple] = true;
            }
        }

        int answer = 0;
        for (int number = 2; number <= n; number++) {
            if (!composite[number]) answer++;
        }
        return answer;
    }
}
