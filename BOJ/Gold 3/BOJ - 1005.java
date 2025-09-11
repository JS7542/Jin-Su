import java.io.*;
import java.util.*;

class Main {
    /*
     * 건물 간 선행 관계를 방향 그래프로 만들고 위상 정렬을 수행한다.
     * 각 건물의 완성 시간은 선행 건물 최대 완성 시간에 자신의 건설 시간을 더한 값이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (tests-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int rules = Integer.parseInt(st.nextToken());

            int[] time = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) time[i] = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

            int[] indegree = new int[n + 1];

            for (int i = 0; i < rules; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                indegree[to]++;
            }

            int target = Integer.parseInt(br.readLine());
            int[] completion = time.clone();

            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) queue.offer(i);
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int next : graph[current]) {
                    completion[next] = Math.max(
                            completion[next],
                            completion[current] + time[next]
                    );

                    if (--indegree[next] == 0) queue.offer(next);
                }
            }

            output.append(completion[target]).append('\n');
        }

        System.out.print(output);
    }
}
