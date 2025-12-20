import java.io.*;
import java.util.*;

class Main {
    /*
     * 방문하지 않은 정점마다 BFS를 시작해 두 색을 번갈아 부여한다.
     * 연결된 두 정점이 같은 색을 가지면 이분 그래프가 아니다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (tests-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertices = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[vertices + 1];
            for (int node = 1; node <= vertices; node++) graph[node] = new ArrayList<>();

            for (int i = 0; i < edges; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                graph[first].add(second);
                graph[second].add(first);
            }

            int[] color = new int[vertices + 1];
            boolean possible = true;

            for (int start = 1; start <= vertices && possible; start++) {
                if (color[start] != 0) continue;

                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(start);
                color[start] = 1;

                while (!queue.isEmpty() && possible) {
                    int current = queue.poll();

                    for (int next : graph[current]) {
                        if (color[next] == 0) {
                            color[next] = -color[current];
                            queue.offer(next);
                        } else if (color[next] == color[current]) {
                            possible = false;
                            break;
                        }
                    }
                }
            }

            output.append(possible ? "YES" : "NO").append('\n');
        }

        System.out.print(output);
    }
}
