class Solution {
    /*
     * 전체 문자열을 소문자로 통일한다.
     * 모든 a 문자만 대문자 A로 바꾸어 반환한다.
     */
    public String solution(String myString) {
        return myString.toLowerCase().replace('a', 'A');
    }
}
