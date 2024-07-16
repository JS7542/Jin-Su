class Solution {
    /*
     * 0이 들어갈 왼쪽, 2가 들어갈 오른쪽 경계와 현재 포인터를 유지한다.
     * 현재 값에 따라 양 끝과 교환하는 Dutch National Flag 알고리즘을 적용한다.
     */
    public void sortColors(int[] nums){int l=0,i=0,r=nums.length-1;while(i<=r){if(nums[i]==0){int t=nums[l];nums[l++]=nums[i];nums[i++]=t;}else if(nums[i]==2){int t=nums[r];nums[r--]=nums[i];nums[i]=t;}else i++;}}
}
