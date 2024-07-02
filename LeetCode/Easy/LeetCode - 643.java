class Solution {
    /*
     * 처음 k개 합을 구한 뒤 한 칸 이동할 때 들어오는 값과 나가는 값을 반영한다.
     * 모든 길이 k 구간 합의 최댓값을 k로 나누어 반환한다.
     */
    public double findMaxAverage(int[] nums,int k){int sum=0;for(int i=0;i<k;i++)sum+=nums[i];int best=sum;for(int i=k;i<nums.length;i++){sum+=nums[i]-nums[i-k];best=Math.max(best,sum);}return(double)best/k;}
}
