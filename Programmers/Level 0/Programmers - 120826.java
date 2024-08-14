class Solution {
    /*
     * 제거할 문자를 빈 문자열로 치환한다.
     * 치환이 끝난 문자열을 그대로 반환한다.
     */
    public String solution(String my_string, String letter) {
        return my_string.replace(letter, "");
    }
}
