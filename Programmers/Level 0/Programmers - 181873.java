class Solution {
    /*
     * 문자열에서 alp와 같은 소문자를 찾는다.
     * 해당 문자를 대문자로 치환한 문자열을 반환한다.
     */
    public String solution(String my_string, String alp) {
        return my_string.replace(alp, alp.toUpperCase());
    }
}
