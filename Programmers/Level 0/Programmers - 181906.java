class Solution {
    /*
     * my_string이 is_prefix 문자열로 시작하는지 확인한다.
     * 접두사가 맞으면 1, 아니면 0을 반환한다.
     */
    public int solution(String my_string, String is_prefix) {
        return my_string.startsWith(is_prefix) ? 1 : 0;
    }
}
