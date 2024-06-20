class Solution {
    /*
     * str1이 str2 내부에 연속된 부분문자열로 존재하는지 확인한다.
     * 포함되면 1, 포함되지 않으면 0을 반환한다.
     */
    public int solution(String str1, String str2) {
        return str2.contains(str1) ? 1 : 0;
    }
}
