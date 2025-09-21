import java.io.*;
import java.util.*;

class Main {
    /*
     * BFS로 각 위치의 최소 시간을 구하면서 직전 위치를 함께 저장한다.
     * 목표 지점에서 이전 위치를 따라가 역순으로 경로를 복원한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int limit = 100_000;

        int[] distance = new int[limit + 1];
        int[] previous = new int[limit + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        distance[start] = 0;
        previous[start] = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == target) break;

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next < 0 || next > limit || distance[next] != -1) continue;

                distance[next] = distance[current] + 1;
                previous[next] = current;
                queue.offer(next);
            }
        }

        Deque<Integer> path = new ArrayDeque<>();

        for (int current = target; current != -1; current = previous[current]) {
            path.push(current);
        }

        StringBuilder output = new StringBuilder();
        output.append(distance[target]).append('\n');

        while (!path.isEmpty()) output.append(path.pop()).append(' ');

        System.out.print(output);
    }
}
