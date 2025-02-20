import java.util.*;
class Solution {
    /*
     * 정렬 후 가장 큰 세 수의 곱과 가장 작은 두 수와 최댓값의 곱을 비교한다.
     * 음수 두 개가 큰 양수 곱을 만들 수 있으므로 두 후보 중 큰 값을 반환한다.
     */
    public int maximumProduct(int[] nums){Arrays.sort(nums);int n=nums.length;return Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[0]*nums[1]*nums[n-1]);}
}
