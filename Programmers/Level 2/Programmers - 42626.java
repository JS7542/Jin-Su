import java.util.*;

class Solution {
    /*
     * 가장 맵지 않은 두 음식을 빠르게 꺼내기 위해 최소 힙을 사용한다.
     * 두 값을 섞어 다시 넣으며 최솟값이 K 이상이 될 때까지 반복한다.
     */
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int value : scoville) heap.offer(value);

        int operations = 0;

        while (heap.peek() < K) {
            if (heap.size() < 2) return -1;

            int first = heap.poll();
            int second = heap.poll();
            heap.offer(first + second * 2);
            operations++;
        }

        return operations;
    }
}
