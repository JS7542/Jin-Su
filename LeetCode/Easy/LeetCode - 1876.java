class Solution {
    /*
     * 길이 3인 모든 부분문자열의 세 문자를 직접 비교한다.
     * 세 문자가 서로 모두 다른 구간의 개수를 센다.
     */
    public int countGoodSubstrings(String s) {
        int answer = 0;

        for (int i = 0; i + 2 < s.length(); i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);

            if (a != b && b != c && a != c) answer++;
        }

        return answer;
    }
}
