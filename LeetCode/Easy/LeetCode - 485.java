class Solution {
    /*
     * 1을 만나면 현재 연속 길이를 증가시키고 0이면 0으로 초기화한다.
     * 각 위치에서 최대 연속 길이를 갱신한다.
     */
    public int findMaxConsecutiveOnes(int[] nums){int cur=0,ans=0;for(int x:nums){cur=x==1?cur+1:0;ans=Math.max(ans,cur);}return ans;}
}
