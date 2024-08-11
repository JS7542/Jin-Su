class Solution {
    /*
     * 문자열 길이에서 n을 뺀 위치를 시작 인덱스로 사용한다.
     * 해당 위치부터 끝까지의 부분문자열을 반환한다.
     */
    public String solution(String my_string, int n) {
        return my_string.substring(my_string.length() - n);
    }
}
