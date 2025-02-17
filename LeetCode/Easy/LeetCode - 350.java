import java.util.*;

class Solution {
    /*
     * 첫 배열의 각 숫자 빈도수를 해시맵에 저장한다.
     * 두 번째 배열에서 남은 빈도가 있는 값만 결과에 추가하고 빈도를 감소시킨다.
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : nums1) count.put(number, count.getOrDefault(number, 0) + 1);

        List<Integer> result = new ArrayList<>();
        for (int number : nums2) {
            int remaining = count.getOrDefault(number, 0);
            if (remaining > 0) {
                result.add(number);
                count.put(number, remaining - 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
