import java.util.*;

class Solution {
    /*
     * 두 배열을 각각 해시셋으로 변환해 중복을 제거한다.
     * 상대 집합에 없는 값만 각 결과 리스트에 담아 반환한다.
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();

        for (int number : nums1) first.add(number);
        for (int number : nums2) second.add(number);

        List<Integer> onlyFirst = new ArrayList<>();
        List<Integer> onlySecond = new ArrayList<>();

        for (int number : first) if (!second.contains(number)) onlyFirst.add(number);
        for (int number : second) if (!first.contains(number)) onlySecond.add(number);

        return Arrays.asList(onlyFirst, onlySecond);
    }
}
