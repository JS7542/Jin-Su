import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 위치의 최소 도달 시간과 그 최소 시간으로 도달하는 방법 수를 BFS로 계산한다.
     * 더 빠른 경로는 시간과 경우의 수를 갱신하고 같은 시간 경로는 경우의 수를 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int limit = 100_000;

        int[] distance = new int[limit + 1];
        int[] ways = new int[limit + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        distance[start] = 0;
        ways[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next < 0 || next > limit) continue;

                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    ways[next] = ways[current];
                    queue.offer(next);
                } else if (distance[next] == distance[current] + 1) {
                    ways[next] += ways[current];
                }
            }
        }

        System.out.println(distance[target]);
        System.out.print(ways[target]);
    }
}
