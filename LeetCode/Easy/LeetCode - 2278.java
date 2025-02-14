class Solution {
    /*
     * 문자열에서 letter와 같은 문자의 개수를 센다.
     * 개수에 100을 곱하고 문자열 길이로 나눈 정수 백분율을 반환한다.
     */
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (char ch : s.toCharArray()) if (ch == letter) count++;
        return count * 100 / s.length();
    }
}
