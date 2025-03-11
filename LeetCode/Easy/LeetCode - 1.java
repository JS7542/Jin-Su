import java.util.*;

class Solution {
    /*
     * 각 숫자를 확인하며 target을 만들기 위해 필요한 보수 값을 해시맵에서 찾는다.
     * 보수가 이미 존재하면 두 인덱스를 반환하고, 아니면 현재 값을 저장한다.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (index.containsKey(need)) return new int[]{index.get(need), i};
            index.put(nums[i], i);
        }

        return new int[0];
    }
}
