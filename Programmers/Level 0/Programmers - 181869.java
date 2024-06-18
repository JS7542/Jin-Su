class Solution {
    /*
     * 문자열은 단어가 한 칸의 공백으로 구분되어 있다.
     * 공백을 기준으로 문자열을 나누어 단어 배열로 반환한다.
     */
    public String[] solution(String my_string) {
        return my_string.split(" ");
    }
}
