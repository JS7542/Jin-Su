class Solution {
    /*
     * 문자열을 두 번 이어 붙이고 맨 앞과 맨 뒤 문자를 제거한다.
     * 원래 문자열이 내부에 존재하면 더 짧은 패턴의 반복으로 구성된다.
     */
    public boolean repeatedSubstringPattern(String s){return (s+s).substring(1,2*s.length()-1).contains(s);}
}
