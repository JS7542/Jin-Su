class Solution {
    /*
     * 전체 합을 구하고 현재 인덱스 왼쪽 합을 순서대로 유지한다.
     * 왼쪽 합과 전체합-왼쪽합-현재값이 같아지는 첫 인덱스를 반환한다.
     */
    public int pivotIndex(int[] nums){int total=0,left=0;for(int x:nums)total+=x;for(int i=0;i<nums.length;i++){if(left==total-left-nums[i])return i;left+=nums[i];}return -1;}
}
