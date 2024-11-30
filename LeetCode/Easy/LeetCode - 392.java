class Solution {
    /*
     * t를 왼쪽부터 순회하며 s의 현재 문자와 같을 때 s 포인터를 이동한다.
     * s의 모든 문자를 순서대로 찾았는지 확인한다.
     */
    public boolean isSubsequence(String s,String t){int i=0;for(int j=0;j<t.length()&&i<s.length();j++)if(s.charAt(i)==t.charAt(j))i++;return i==s.length();}
}
