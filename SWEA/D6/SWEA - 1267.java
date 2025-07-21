import java.io.*;
import java.util.*;

class Solution {
    /*
     * 작업 선행 관계로 방향 그래프와 진입 차수를 만든다.
     * 진입 차수가 0인 작업부터 처리하는 위상 정렬 순서를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertices = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[vertices + 1];
            for (int node = 1; node <= vertices; node++) graph[node] = new ArrayList<>();

            int[] indegree = new int[vertices + 1];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < edges; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
                indegree[to]++;
            }

            Queue<Integer> queue = new ArrayDeque<>();

            for (int node = 1; node <= vertices; node++) {
                if (indegree[node] == 0) queue.offer(node);
            }

            output.append('#').append(tc).append(' ');

            while (!queue.isEmpty()) {
                int current = queue.poll();
                output.append(current).append(' ');

                for (int next : graph[current]) {
                    if (--indegree[next] == 0) queue.offer(next);
                }
            }

            output.append('\n');
        }

        System.out.print(output);
    }
}
