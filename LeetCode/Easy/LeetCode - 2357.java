import java.util.*;

class Solution {
    /*
     * 한 번의 연산은 하나의 서로 다른 양수 값을 제거할 수 있다.
     * 배열에서 0을 제외한 서로 다른 값의 개수를 반환한다.
     */
    public int minimumOperations(int[] nums) {
        Set<Integer> values = new HashSet<>();

        for (int number : nums) {
            if (number > 0) values.add(number);
        }

        return values.size();
    }
}
