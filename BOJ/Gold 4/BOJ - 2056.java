import java.io.*;
import java.util.*;

class Main {
    /*
     * 작업별 선행 관계를 방향 그래프로 구성한다.
     * 위상 정렬 중 선행 작업 완료 시간의 최댓값에 현재 작업 시간을 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] time = new int[n + 1];
        int[] completion = new int[n + 1];
        int[] indegree = new int[n + 1];

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int task = 1; task <= n; task++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[task] = Integer.parseInt(st.nextToken());
            completion[task] = time[task];

            int prerequisites = Integer.parseInt(st.nextToken());

            for (int i = 0; i < prerequisites; i++) {
                int before = Integer.parseInt(st.nextToken());
                graph[before].add(task);
                indegree[task]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int task = 1; task <= n; task++) {
            if (indegree[task] == 0) queue.offer(task);
        }

        int answer = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            answer = Math.max(answer, completion[current]);

            for (int next : graph[current]) {
                completion[next] = Math.max(
                        completion[next],
                        completion[current] + time[next]
                );

                if (--indegree[next] == 0) queue.offer(next);
            }
        }

        System.out.print(answer);
    }
}
