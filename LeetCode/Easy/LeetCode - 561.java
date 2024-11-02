import java.util.*;
class Solution {
    /*
     * 배열을 오름차순 정렬하면 인접한 두 수를 묶는 것이 각 쌍 최솟값 합을 최대화한다.
     * 짝수 인덱스의 값을 모두 더한다.
     */
    public int arrayPairSum(int[] nums){Arrays.sort(nums);int ans=0;for(int i=0;i<nums.length;i+=2)ans+=nums[i];return ans;}
}
