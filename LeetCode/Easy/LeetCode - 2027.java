class Solution {
    /*
     * X를 발견하면 해당 위치부터 세 문자를 한 번의 연산으로 바꾼다고 생각한다.
     * 연산 후 처리된 세 칸을 건너뛰며 최소 연산 횟수를 센다.
     */
    public int minimumMoves(String s) {
        int answer = 0;

        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == 'X') {
                answer++;
                i += 3;
            } else {
                i++;
            }
        }

        return answer;
    }
}
