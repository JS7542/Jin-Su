class Solution {
    /*
     * 정렬 배열의 중간값과 target을 비교해 탐색 범위를 절반씩 줄인다.
     * 값을 찾으면 인덱스를, 끝까지 없으면 -1을 반환한다.
     */
    public int search(int[] nums,int target){int l=0,r=nums.length-1;while(l<=r){int m=l+(r-l)/2;if(nums[m]==target)return m;if(nums[m]<target)l=m+1;else r=m-1;}return -1;}
}
