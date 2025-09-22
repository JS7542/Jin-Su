import java.util.*;

class Solution {
    /*
     * 큐에 프로세스 인덱스를 저장한다.
     * 현재보다 우선순위가 높은 프로세스가 남아 있으면 뒤로 보내고 아니면 실행한다.
     */
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) queue.offer(i);

        int order = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            boolean higher = false;

            for (int index : queue) {
                if (priorities[index] > priorities[current]) {
                    higher = true;
                    break;
                }
            }

            if (higher) {
                queue.offer(current);
            } else {
                order++;
                if (current == location) return order;
            }
        }

        return -1;
    }
}
