class Solution {
    /*
     * 현재 문자가 공백이 아니고 이전 위치가 문자열 시작 또는 공백일 때 단어 시작이다.
     * 모든 단어 시작 위치의 개수를 센다.
     */
    public int countSegments(String s){int ans=0;for(int i=0;i<s.length();i++)if(s.charAt(i)!=' '&&(i==0||s.charAt(i-1)==' '))ans++;return ans;}
}
