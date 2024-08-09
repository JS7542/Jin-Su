class Solution {
    /*
     * 각 구간의 첫 문자와 같은 문자 수, 다른 문자 수를 센다.
     * 두 수가 같아지는 순간 문자열을 분리하고 다음 구간을 시작한다.
     */
    public int solution(String s) {
        int answer = 0;
        int same = 0;
        int different = 0;
        char first = 0;

        for (int i = 0; i < s.length(); i++) {
            if (same == different) {
                answer++;
                first = s.charAt(i);
                same = 0;
                different = 0;
            }

            if (s.charAt(i) == first) same++;
            else different++;
        }

        return answer;
    }
}
