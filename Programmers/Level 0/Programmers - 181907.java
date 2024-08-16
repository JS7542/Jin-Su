class Solution {
    /*
     * 문자열의 처음부터 n개 문자를 부분문자열로 자른다.
     * 잘라낸 앞부분을 그대로 반환한다.
     */
    public String solution(String my_string, int n) {
        return my_string.substring(0, n);
    }
}
