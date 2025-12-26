class Solution {
    /*
     * 연속 자연수의 시작값을 하나씩 정하고 합을 늘린다.
     * 합이 n에 도달하는 경우를 세고 n을 넘으면 다음 시작값으로 이동한다.
     */
    public int solution(int n) {
        int answer = 0;

        for (int start = 1; start <= n; start++) {
            int sum = 0;

            for (int value = start; sum < n; value++) {
                sum += value;
            }

            if (sum == n) answer++;
        }

        return answer;
    }
}
