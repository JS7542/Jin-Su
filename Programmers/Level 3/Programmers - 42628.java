import java.util.*;

class Solution {
    /*
     * 최소 힙과 최대 힙에 같은 값을 저장한다.
     * 삭제 시 반대 힙에서도 해당 값을 제거해 두 자료구조의 상태를 동기화한다.
     */
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            int value = Integer.parseInt(parts[1]);

            if (parts[0].equals("I")) {
                minHeap.offer(value);
                maxHeap.offer(value);
            } else if (!minHeap.isEmpty()) {
                if (value == 1) {
                    int removed = maxHeap.poll();
                    minHeap.remove(removed);
                } else {
                    int removed = minHeap.poll();
                    maxHeap.remove(removed);
                }
            }
        }

        if (minHeap.isEmpty()) return new int[]{0, 0};
        return new int[]{maxHeap.peek(), minHeap.peek()};
    }
}
