import java.util.*;

class Solution {
    /*
     * 각 숫자의 등장 횟수를 해시맵에 저장한다.
     * 빈도수를 집합에 넣을 때 중복이 발생하면 고유하지 않다.
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : arr) count.put(number, count.getOrDefault(number, 0) + 1);

        Set<Integer> frequencies = new HashSet<>();
        for (int frequency : count.values()) {
            if (!frequencies.add(frequency)) return false;
        }

        return true;
    }
}
