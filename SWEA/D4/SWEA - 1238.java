import java.io.*;
import java.util.*;

class Solution {
    /*
     * 시작 정점에서 방향 그래프 BFS를 수행해 각 연락자의 방문 단계를 기록한다.
     * 가장 늦은 단계에서 연락받은 사람 중 번호가 가장 큰 값을 선택한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dataLength = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[101];
            for (int i = 1; i <= 100; i++) graph[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < dataLength / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
            }

            int[] distance = new int[101];
            Arrays.fill(distance, -1);

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(start);
            distance[start] = 0;

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int next : graph[current]) {
                    if (distance[next] != -1) continue;

                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }

            int answer = start;
            int farthest = 0;

            for (int person = 1; person <= 100; person++) {
                if (distance[person] >= farthest) {
                    farthest = distance[person];
                    answer = person;
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
