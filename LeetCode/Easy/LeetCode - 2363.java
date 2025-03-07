import java.util.*;

class Solution {
    /*
     * 두 배열의 같은 value에 해당하는 weight를 TreeMap에 합산한다.
     * value 오름차순으로 [value, weight] 목록을 만들어 반환한다.
     */
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> weights = new TreeMap<>();

        for (int[] item : items1) {
            weights.put(item[0], weights.getOrDefault(item[0], 0) + item[1]);
        }

        for (int[] item : items2) {
            weights.put(item[0], weights.getOrDefault(item[0], 0) + item[1]);
        }

        List<List<Integer>> answer = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : weights.entrySet()) {
            answer.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }

        return answer;
    }
}
