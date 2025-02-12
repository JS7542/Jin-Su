import java.util.*;

class Solution {
    /*
     * 첫 배열의 값을 집합에 저장하고 두 번째 배열에서 공통 값을 찾는다.
     * 결과도 집합에 저장해 중복 없는 교집합 배열을 만든다.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int number : nums1) first.add(number);
        for (int number : nums2) if (first.contains(number)) result.add(number);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
