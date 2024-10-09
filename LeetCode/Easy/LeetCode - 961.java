import java.util.*;

class Solution {
    /*
     * 배열을 순회하며 이미 본 숫자인지 해시셋으로 확인한다.
     * 처음 중복된 숫자가 정확히 N번 반복되는 원소다.
     */
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int number : nums) {
            if (!seen.add(number)) return number;
        }

        return -1;
    }
}
