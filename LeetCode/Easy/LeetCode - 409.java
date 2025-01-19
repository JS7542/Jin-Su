class Solution {
    /*
     * 문자별 빈도에서 짝수 부분은 모두 회문에 사용할 수 있다.
     * 홀수 빈도가 하나라도 있으면 가운데 문자 한 개를 추가한다.
     */
    public int longestPalindrome(String s){int[]c=new int[128];for(char x:s.toCharArray())c[x]++;int ans=0;boolean odd=false;for(int v:c){ans+=v/2*2;if(v%2==1)odd=true;}return ans+(odd?1:0);}
}
