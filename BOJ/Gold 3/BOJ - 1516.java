import java.io.*;
import java.util.*;

class Main {
    /*
     * 건물별 선행 건물 목록으로 방향 그래프와 진입 차수를 만든다.
     * 위상 정렬 중 선행 건물 완성 시간의 최댓값을 누적해 각 건물 최소 완성 시간을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] buildTime = new int[n + 1];
        int[] completion = new int[n + 1];
        int[] indegree = new int[n + 1];

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int building = 1; building <= n; building++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[building] = Integer.parseInt(st.nextToken());
            completion[building] = buildTime[building];

            while (true) {
                int prerequisite = Integer.parseInt(st.nextToken());
                if (prerequisite == -1) break;

                graph[prerequisite].add(building);
                indegree[building]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int building = 1; building <= n; building++) {
            if (indegree[building] == 0) queue.offer(building);
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                completion[next] = Math.max(
                        completion[next],
                        completion[current] + buildTime[next]
                );

                if (--indegree[next] == 0) queue.offer(next);
            }
        }

        StringBuilder output = new StringBuilder();

        for (int building = 1; building <= n; building++) {
            output.append(completion[building]).append('\n');
        }

        System.out.print(output);
    }
}
