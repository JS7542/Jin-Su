class Solution {
    /*
     * 1부터 n까지 n을 나누어떨어지게 하는 수를 센다.
     * 각 약수는 하나의 순서쌍 첫 번째 값이므로 약수 개수를 반환한다.
     */
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) answer++;
        return answer;
    }
}
