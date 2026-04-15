import java.util.*;

class Solution {
    /*
     * 각 숫자의 등장 횟수를 해시맵에 센다.
     * 빈도 기준 최소 힙을 크기 k로 유지해 가장 자주 등장한 숫자만 남긴다.
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : nums) count.put(number, count.getOrDefault(number, 0) + 1);

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(count::get)
        );

        for (int number : count.keySet()) {
            heap.offer(number);
            if (heap.size() > k) heap.poll();
        }

        int[] answer = new int[k];

        for (int i = k - 1; i >= 0; i--) answer[i] = heap.poll();

        return answer;
    }
}
