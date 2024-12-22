import java.util.*;

class Solution {
    /*
     * 가장 큰 선물 더미를 빠르게 꺼내기 위해 최대 힙을 사용한다.
     * k번 동안 최댓값을 제곱근으로 바꾼 뒤 남은 선물 합을 구한다.
     */
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int gift : gifts) heap.offer(gift);

        while (k-- > 0) {
            heap.offer((int) Math.sqrt(heap.poll()));
        }

        long answer = 0;
        while (!heap.isEmpty()) answer += heap.poll();

        return answer;
    }
}
