class Solution {
    /*
     * i번째 등차수열 항 a+d*i를 계산한다.
     * included[i]가 true인 항만 합에 더해 반환한다.
     */
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;

        for (int i = 0; i < included.length; i++) {
            if (included[i]) answer += a + d * i;
        }

        return answer;
    }
}
