class Solution {
    /*
     * 문자열 길이가 홀수면 가운데 한 글자, 짝수면 가운데 두 글자를 선택한다.
     * 공통 시작 위치 (길이-1)/2에서 길이/2+1까지 자른다.
     */
    public String solution(String s){return s.substring((s.length()-1)/2,s.length()/2+1);}
}
