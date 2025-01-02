import java.util.*;

class Solution {
    /*
     * 각 숫자의 등장 빈도를 해시맵에 저장한다.
     * 빈도 오름차순, 빈도가 같으면 값 내림차순으로 정렬한다.
     */
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : nums) count.put(number, count.getOrDefault(number, 0) + 1);

        Integer[] values = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(values, (a, b) -> {
            int compare = Integer.compare(count.get(a), count.get(b));
            return compare != 0 ? compare : Integer.compare(b, a);
        });

        return Arrays.stream(values).mapToInt(Integer::intValue).toArray();
    }
}
