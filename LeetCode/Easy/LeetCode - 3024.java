import java.util.*;

class Solution {
    /*
     * 세 변을 정렬해 가장 긴 변이 나머지 두 변의 합보다 작은지 확인한다.
     * 성립하면 같은 변의 개수에 따라 삼각형 종류를 반환한다.
     */
    public String triangleType(int[] nums) {
        Arrays.sort(nums);

        if (nums[0] + nums[1] <= nums[2]) return "none";
        if (nums[0] == nums[2]) return "equilateral";
        if (nums[0] == nums[1] || nums[1] == nums[2]) return "isosceles";
        return "scalene";
    }
}
