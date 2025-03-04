class Solution {
    /*
     * 각 문자열을 뒤에서 읽으며 #이 나오면 건너뛸 문자 수를 증가시킨다.
     * 실제 남는 문자를 역순으로 만들어 두 결과가 같은지 비교한다.
     */
    public boolean backspaceCompare(String s,String t){return build(s).equals(build(t));}private String build(String s){StringBuilder b=new StringBuilder();int skip=0;for(int i=s.length()-1;i>=0;i--){char c=s.charAt(i);if(c=='#')skip++;else if(skip>0)skip--;else b.append(c);}return b.toString();}
}
