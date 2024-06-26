class Solution {
    /*
     * s부터 e까지의 부분문자열만 뒤집는다.
     * 앞 구간, 뒤집힌 구간, 뒤 구간을 이어 붙여 반환한다.
     */
    public String solution(String my_string, int s, int e) {
        String middle = new StringBuilder(my_string.substring(s, e + 1)).reverse().toString();
        return my_string.substring(0, s) + middle + my_string.substring(e + 1);
    }
}
