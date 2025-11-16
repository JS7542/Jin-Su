import java.io.*;
import java.util.*;

class Main {
    /*
     * 작년 순위로 모든 팀 사이 방향을 정하고 변경된 쌍의 간선 방향을 뒤집는다.
     * 위상 정렬 중 후보가 없으면 사이클, 둘 이상이면 순위가 불확실하다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (tests-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ranking = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) ranking[i] = Integer.parseInt(st.nextToken());

            boolean[][] graph = new boolean[n + 1][n + 1];
            int[] indegree = new int[n + 1];

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    graph[ranking[i]][ranking[j]] = true;
                    indegree[ranking[j]]++;
                }
            }

            int changes = Integer.parseInt(br.readLine());

            for (int i = 0; i < changes; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                if (graph[first][second]) {
                    graph[first][second] = false;
                    graph[second][first] = true;
                    indegree[second]--;
                    indegree[first]++;
                } else {
                    graph[second][first] = false;
                    graph[first][second] = true;
                    indegree[first]--;
                    indegree[second]++;
                }
            }

            Queue<Integer> queue = new ArrayDeque<>();

            for (int team = 1; team <= n; team++) {
                if (indegree[team] == 0) queue.offer(team);
            }

            int[] result = new int[n];
            boolean impossible = false;
            boolean ambiguous = false;

            for (int index = 0; index < n; index++) {
                if (queue.isEmpty()) {
                    impossible = true;
                    break;
                }

                if (queue.size() > 1) ambiguous = true;

                int current = queue.poll();
                result[index] = current;

                for (int next = 1; next <= n; next++) {
                    if (graph[current][next] && --indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            if (impossible) {
                output.append("IMPOSSIBLE\n");
            } else if (ambiguous) {
                output.append("?\n");
            } else {
                for (int team : result) output.append(team).append(' ');
                output.append('\n');
            }
        }

        System.out.print(output);
    }
}
