class Solution {
    /*
     * 값이 가리키는 인덱스의 부호를 바꾸어 등장 여부를 표시한다.
     * 이미 음수인 위치를 다시 만나면 중복값이고 양수로 남은 위치가 누락값이다.
     */
    public int[] findErrorNums(int[] nums){int dup=0,miss=0;for(int x:nums){int i=Math.abs(x)-1;if(nums[i]<0)dup=Math.abs(x);else nums[i]*=-1;}for(int i=0;i<nums.length;i++)if(nums[i]>0)miss=i+1;return new int[]{dup,miss};}
}
