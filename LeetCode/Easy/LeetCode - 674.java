class Solution {
    /*
     * 현재 값이 이전 값보다 크면 연속 증가 길이를 늘리고 아니면 1로 초기화한다.
     * 순회 중 가장 긴 길이를 유지한다.
     */
    public int findLengthOfLCIS(int[] nums){int cur=1,ans=1;for(int i=1;i<nums.length;i++){cur=nums[i]>nums[i-1]?cur+1:1;ans=Math.max(ans,cur);}return ans;}
}
