class Solution {
    /*
     * 양 끝 문자가 처음 다를 때 왼쪽 또는 오른쪽 문자 하나를 건너뛴 두 구간을 검사한다.
     * 둘 중 하나가 회문이면 한 문자 삭제로 회문을 만들 수 있다.
     */
    public boolean validPalindrome(String s){int l=0,r=s.length()-1;while(l<r&&s.charAt(l)==s.charAt(r)){l++;r--;}return l>=r||pal(s,l+1,r)||pal(s,l,r-1);}private boolean pal(String s,int l,int r){while(l<r)if(s.charAt(l++)!=s.charAt(r--))return false;return true;}
}
