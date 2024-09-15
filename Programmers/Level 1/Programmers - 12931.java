class Solution {
    /*
     * 자연수의 마지막 자리를 반복해서 분리한다.
     * 각 자리수를 합에 더하고 10으로 나누어 다음 자리로 이동한다.
     */
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}
