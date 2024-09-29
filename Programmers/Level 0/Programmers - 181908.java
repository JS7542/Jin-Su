class Solution {
    /*
     * my_string이 is_suffix 문자열로 끝나는지 확인한다.
     * 접미사가 맞으면 1, 아니면 0을 반환한다.
     */
    public int solution(String my_string, String is_suffix) {
        return my_string.endsWith(is_suffix) ? 1 : 0;
    }
}
