class Solution {
    /*
     * 두 문자열 길이가 같고 goal이 s+s의 부분 문자열인지 확인한다.
     * s를 회전한 모든 결과는 s를 두 번 이은 문자열 안에 존재한다.
     */
    public boolean rotateString(String s,String goal){return s.length()==goal.length()&&(s+s).contains(goal);}
}
