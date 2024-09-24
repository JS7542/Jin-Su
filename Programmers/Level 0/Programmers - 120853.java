class Solution {
    /*
     * 공백으로 나눈 토큰을 순서대로 확인하며 숫자를 합에 더한다.
     * Z를 만나면 직전에 더한 값을 다시 빼서 연산을 취소한다.
     */
    public int solution(String s) {
        int answer = 0;
        int previous = 0;

        for (String token : s.split(" ")) {
            if (token.equals("Z")) answer -= previous;
            else {
                previous = Integer.parseInt(token);
                answer += previous;
            }
        }

        return answer;
    }
}
