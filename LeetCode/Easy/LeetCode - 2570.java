import java.util.*;

class Solution {
    /*
     * 같은 ID의 값을 TreeMap에서 합산한다.
     * ID 오름차순으로 [id, value] 배열을 구성해 반환한다.
     */
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> values = new TreeMap<>();

        for (int[] item : nums1) {
            values.put(item[0], values.getOrDefault(item[0], 0) + item[1]);
        }

        for (int[] item : nums2) {
            values.put(item[0], values.getOrDefault(item[0], 0) + item[1]);
        }

        int[][] answer = new int[values.size()][2];
        int index = 0;

        for (Map.Entry<Integer, Integer> entry : values.entrySet()) {
            answer[index++] = new int[]{entry.getKey(), entry.getValue()};
        }

        return answer;
    }
}
