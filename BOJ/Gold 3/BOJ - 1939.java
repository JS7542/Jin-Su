import java.io.*;
import java.util.*;

class Main {
    static class Edge {
        int to;
        int limit;

        Edge(int to, int limit) {
            this.to = to;
            this.limit = limit;
        }
    }

    /*
     * 운반 중량을 정하면 그 중량 이상을 버티는 간선만으로 목적지 도달 여부를 검사한다.
     * 이동 가능한 최대 중량을 이분 탐색한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int islands = Integer.parseInt(st.nextToken());
        int bridges = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[islands + 1];
        for (int island = 1; island <= islands; island++) graph[island] = new ArrayList<>();

        int maximum = 0;

        for (int i = 0; i < bridges; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            graph[first].add(new Edge(second, limit));
            graph[second].add(new Edge(first, limit));
            maximum = Math.max(maximum, limit);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = maximum;
        int answer = 0;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (reachable(start, destination, middle, graph)) {
                answer = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        System.out.print(answer);
    }

    static boolean reachable(
            int start,
            int destination,
            int weight,
            List<Edge>[] graph
    ) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == destination) return true;

            for (Edge edge : graph[current]) {
                if (!visited[edge.to] && edge.limit >= weight) {
                    visited[edge.to] = true;
                    queue.offer(edge.to);
                }
            }
        }

        return false;
    }
}
