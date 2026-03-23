import java.io.*;
import java.util.*;

class Main {
    /*
     * 진입 차수가 0인 노드의 Strahler 순서를 1로 시작해 위상 정렬한다.
     * 최대 선행 순서가 둘 이상 들어오면 1을 더하고, 하나뿐이면 그대로 사용한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (tests-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int caseNumber = Integer.parseInt(st.nextToken());
            int nodes = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[nodes + 1];
            for (int i = 1; i <= nodes; i++) graph[i] = new ArrayList<>();

            int[] indegree = new int[nodes + 1];
            int[] maximumOrder = new int[nodes + 1];
            int[] maximumCount = new int[nodes + 1];
            int[] order = new int[nodes + 1];

            for (int i = 0; i < edges; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
                indegree[to]++;
            }

            Queue<Integer> queue = new ArrayDeque<>();

            for (int node = 1; node <= nodes; node++) {
                if (indegree[node] == 0) {
                    order[node] = 1;
                    queue.offer(node);
                }
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int next : graph[current]) {
                    if (order[current] > maximumOrder[next]) {
                        maximumOrder[next] = order[current];
                        maximumCount[next] = 1;
                    } else if (order[current] == maximumOrder[next]) {
                        maximumCount[next]++;
                    }

                    if (--indegree[next] == 0) {
                        order[next] = maximumOrder[next]
                                + (maximumCount[next] >= 2 ? 1 : 0);
                        queue.offer(next);
                    }
                }
            }

            output.append(caseNumber).append(' ')
                    .append(order[nodes]).append('\n');
        }

        System.out.print(output);
    }
}
