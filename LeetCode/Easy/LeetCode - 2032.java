import java.util.*;

class Solution {
    /*
     * 각 배열의 중복을 제거한 집합을 만든다.
     * 숫자가 세 집합 중 두 개 이상에 포함되면 결과에 추가한다.
     */
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> first = toSet(nums1);
        Set<Integer> second = toSet(nums2);
        Set<Integer> third = toSet(nums3);
        Set<Integer> all = new HashSet<>();

        all.addAll(first);
        all.addAll(second);
        all.addAll(third);

        List<Integer> answer = new ArrayList<>();

        for (int number : all) {
            int count = (first.contains(number) ? 1 : 0)
                    + (second.contains(number) ? 1 : 0)
                    + (third.contains(number) ? 1 : 0);

            if (count >= 2) answer.add(number);
        }

        return answer;
    }

    private Set<Integer> toSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int number : nums) set.add(number);
        return set;
    }
}
