import java.util.*;

class Solution {
    /*
     * 모든 돌을 최대 힙에 넣고 가장 무거운 두 돌을 반복해서 꺼낸다.
     * 무게가 다르면 차이를 다시 넣고 마지막 남은 돌의 무게를 반환한다.
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) heap.offer(stone);

        while (heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();
            if (first != second) heap.offer(first - second);
        }

        return heap.isEmpty() ? 0 : heap.peek();
    }
}
