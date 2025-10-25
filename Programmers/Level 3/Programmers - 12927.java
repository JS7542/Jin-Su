import java.util.*;

class Solution {
    /*
     * 가장 큰 작업량을 우선 줄이기 위해 최대 힙을 사용한다.
     * n번 동안 최댓값을 1씩 줄인 뒤 남은 작업량 제곱 합을 계산한다.
     */
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) heap.offer(work);

        while (n-- > 0 && !heap.isEmpty()) {
            int work = heap.poll();

            if (work == 0) {
                heap.offer(0);
                break;
            }

            heap.offer(work - 1);
        }

        long answer = 0;

        while (!heap.isEmpty()) {
            long work = heap.poll();
            answer += work * work;
        }

        return answer;
    }
}
