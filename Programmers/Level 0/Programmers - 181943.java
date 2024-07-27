class Solution {
    /*
     * my_string의 s 이전 부분과 overwrite_string을 이어 붙인다.
     * 덮어쓴 길이 이후의 my_string 나머지를 뒤에 추가한다.
     */
    public String solution(String my_string, String overwrite_string, int s) {
        int end = s + overwrite_string.length();
        return my_string.substring(0, s)
                + overwrite_string
                + my_string.substring(end);
    }
}
