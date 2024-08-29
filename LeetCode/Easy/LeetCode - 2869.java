import java.util.*;

class Solution {
    /*
     * 배열 뒤에서부터 읽으며 1부터 k까지 숫자를 집합에 모은다.
     * k개의 숫자를 모두 모은 순간까지의 연산 횟수를 반환한다.
     */
    public int minOperations(List<Integer> nums, int k) {
        boolean[] collected = new boolean[k + 1];
        int count = 0;

        for (int i = nums.size() - 1; i >= 0; i--) {
            int value = nums.get(i);

            if (value <= k && !collected[value]) {
                collected[value] = true;
                count++;
            }

            if (count == k) return nums.size() - i;
        }

        return nums.size();
    }
}
