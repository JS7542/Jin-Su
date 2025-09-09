import java.util.*;

class Solution {
    /*
     * 크기가 k인 최소 힙을 유지한다.
     * 모든 숫자를 처리하면 힙의 최솟값이 전체에서 k번째로 큰 값이다.
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int number : nums) {
            heap.offer(number);

            if (heap.size() > k) heap.poll();
        }

        return heap.peek();
    }
}
