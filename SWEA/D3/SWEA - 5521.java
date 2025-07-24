import java.io.*;
import java.util.*;

class Solution {
    /*
     * 상원이 1번에서 BFS를 수행한다.
     * 거리가 1인 친구와 거리가 2인 친구까지만 초대하고 그 수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int people = Integer.parseInt(br.readLine());
            int relations = Integer.parseInt(br.readLine());

            List<Integer>[] graph = new ArrayList[people + 1];

            for (int person = 1; person <= people; person++) {
                graph[person] = new ArrayList<>();
            }

            for (int i = 0; i < relations; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                graph[first].add(second);
                graph[second].add(first);
            }

            int[] distance = new int[people + 1];
            Arrays.fill(distance, -1);

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(1);
            distance[1] = 0;

            while (!queue.isEmpty()) {
                int current = queue.poll();

                if (distance[current] == 2) continue;

                for (int next : graph[current]) {
                    if (distance[next] != -1) continue;

                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }

            int answer = 0;

            for (int person = 2; person <= people; person++) {
                if (distance[person] == 1 || distance[person] == 2) answer++;
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
