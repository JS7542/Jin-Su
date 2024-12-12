class Solution {
    /*
     * 문자열 내장 메서드 indexOf로 needle이 처음 나타나는 위치를 찾는다.
     * 존재하지 않으면 indexOf가 반환하는 -1을 그대로 반환한다.
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
