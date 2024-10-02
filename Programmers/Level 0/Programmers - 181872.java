class Solution {
    /*
     * pat이 마지막으로 시작하는 위치를 찾는다.
     * 문자열 처음부터 해당 pat이 끝나는 위치까지 잘라 반환한다.
     */
    public String solution(String myString, String pat) {
        int start = myString.lastIndexOf(pat);
        return myString.substring(0, start + pat.length());
    }
}
