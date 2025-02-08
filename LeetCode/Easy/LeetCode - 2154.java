import java.util.*;

class Solution {
    /*
     * 배열의 모든 숫자를 해시셋에 저장한다.
     * original이 집합에 존재하는 동안 두 배로 늘린다.
     */
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> values = new HashSet<>();
        for (int number : nums) values.add(number);

        while (values.contains(original)) original *= 2;
        return original;
    }
}
