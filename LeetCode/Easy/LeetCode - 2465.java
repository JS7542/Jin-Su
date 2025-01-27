import java.util.*;

class Solution {
    /*
     * 배열을 정렬하고 양 끝 값을 하나씩 짝지어 합을 계산한다.
     * 평균 대신 두 수의 합을 집합에 저장해 서로 다른 평균 개수를 센다.
     */
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> sums = new HashSet<>();

        int left = 0;
        int right = nums.length - 1;

        while (left < right) sums.add(nums[left++] + nums[right--]);

        return sums.size();
    }
}
