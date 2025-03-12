class Solution {
    /*
     * 가장 큰 값과 두 번째 큰 값을 한 번의 순회로 구한다.
     * 최댓값이 두 번째 값의 두 배 이상이면 인덱스를, 아니면 -1을 반환한다.
     */
    public int dominantIndex(int[] nums){int max=-1,second=-1,index=-1;for(int i=0;i<nums.length;i++){if(nums[i]>max){second=max;max=nums[i];index=i;}else if(nums[i]>second)second=nums[i];}return max>=2*second?index:-1;}
}
