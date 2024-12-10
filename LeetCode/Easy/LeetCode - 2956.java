import java.util.*;

class Solution {
    /*
     * 두 배열을 각각 해시셋으로 만든다.
     * 상대 배열 집합에 포함되는 원소 수를 각 배열 기준으로 센다.
     */
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();

        for (int number : nums1) first.add(number);
        for (int number : nums2) second.add(number);

        int firstCount = 0;
        int secondCount = 0;

        for (int number : nums1) if (second.contains(number)) firstCount++;
        for (int number : nums2) if (first.contains(number)) secondCount++;

        return new int[]{firstCount, secondCount};
    }
}
