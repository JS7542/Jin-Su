class Solution {
    /*
     * 연속한 같은 문자 그룹의 이전 길이와 현재 길이를 유지한다.
     * 그룹이 바뀔 때마다 두 그룹 길이의 최솟값만큼 유효 부분 문자열이 생긴다.
     */
    public int countBinarySubstrings(String s){int prev=0,cur=1,ans=0;for(int i=1;i<s.length();i++){if(s.charAt(i)==s.charAt(i-1))cur++;else{ans+=Math.min(prev,cur);prev=cur;cur=1;}}return ans+Math.min(prev,cur);}
}
