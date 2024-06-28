class Solution {
    /*
     * target 문자열이 my_string 내부에 연속해서 존재하는지 확인한다.
     * 포함되면 1, 포함되지 않으면 0을 반환한다.
     */
    public int solution(String my_string, String target) {
        return my_string.contains(target) ? 1 : 0;
    }
}
