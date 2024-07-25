class Solution {
    /*
     * 문자열에서 소문자 모음 a, e, i, o, u를 모두 제거한다.
     * 정규식 문자 집합을 이용해 한 번에 빈 문자열로 치환한다.
     */
    public String solution(String my_string) {
        return my_string.replaceAll("[aeiou]", "");
    }
}
