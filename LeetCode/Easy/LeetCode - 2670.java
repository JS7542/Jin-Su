import java.util.*;

class Solution {
    /*
     * 오른쪽 전체 빈도를 먼저 저장하고 왼쪽 집합을 하나씩 늘린다.
     * 각 위치에서 왼쪽 서로 다른 값 수와 오른쪽 서로 다른 값 수의 차이를 기록한다.
     */
    public int[] distinctDifferenceArray(int[] nums) {
        Map<Integer, Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();

        for (int number : nums) right.put(number, right.getOrDefault(number, 0) + 1);

        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            left.add(nums[i]);

            int count = right.get(nums[i]) - 1;
            if (count == 0) right.remove(nums[i]);
            else right.put(nums[i], count);

            answer[i] = left.size() - right.size();
        }

        return answer;
    }
}
