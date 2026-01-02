import java.util.*;

class Solution {
    /*
     * x에서 시작해 +n, ×2, ×3 연산으로 만들 수 있는 값을 BFS한다.
     * y를 넘지 않는 처음 방문 상태만 큐에 넣어 최소 연산 횟수를 구한다.
     */
    public int solution(int x, int y, int n) {
        int[] distance = new int[y + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(x);
        distance[x] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == y) return distance[current];

            for (int next : new int[]{current + n, current * 2, current * 3}) {
                if (next > y || distance[next] != -1) continue;

                distance[next] = distance[current] + 1;
                queue.offer(next);
            }
        }

        return -1;
    }
}
