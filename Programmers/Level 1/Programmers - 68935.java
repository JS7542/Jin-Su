class Solution {
    /*
     * n을 3으로 나눈 나머지를 얻는 순서가 이미 뒤집힌 3진법 자리 순서다.
     * 이 숫자들을 왼쪽부터 10진수로 누적 변환한다.
     */
    public int solution(int n) {
        StringBuilder ternary = new StringBuilder();

        while (n > 0) {
            ternary.append(n % 3);
            n /= 3;
        }

        int answer = 0;
        for (int i = 0; i < ternary.length(); i++) {
            answer = answer * 3 + ternary.charAt(i) - '0';
        }
        return answer;
    }
}
