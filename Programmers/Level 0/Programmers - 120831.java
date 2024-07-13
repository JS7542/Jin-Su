class Solution {
    /*
     * 1부터 n까지 존재하는 모든 짝수의 합을 계산한다.
     * 2씩 증가하는 반복문으로 짝수만 누적한다.
     */
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i += 2) answer += i;
        return answer;
    }
}
