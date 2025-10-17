import java.io.*;
import java.util.*;

class Main {
    static class Part {
        int next;
        int count;

        Part(int next, int count) {
            this.next = next;
            this.count = count;
        }
    }

    /*
     * 기본 부품에서 중간·완제품 방향으로 위상 정렬한다.
     * 각 부품을 만드는 데 필요한 기본 부품 개수를 다음 부품으로 배수만큼 전달한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int relations = Integer.parseInt(br.readLine());

        List<Part>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        int[] indegree = new int[n + 1];

        for (int i = 0; i < relations; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int product = Integer.parseInt(st.nextToken());
            int component = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            graph[component].add(new Part(product, count));
            indegree[product]++;
        }

        long[][] needs = new long[n + 1][n + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int part = 1; part <= n; part++) {
            if (indegree[part] == 0) {
                queue.offer(part);
                needs[part][part] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Part edge : graph[current]) {
                for (int basic = 1; basic <= n; basic++) {
                    needs[edge.next][basic] += needs[current][basic] * edge.count;
                }

                if (--indegree[edge.next] == 0) queue.offer(edge.next);
            }
        }

        StringBuilder output = new StringBuilder();

        for (int basic = 1; basic <= n; basic++) {
            if (needs[n][basic] > 0) {
                output.append(basic).append(' ')
                        .append(needs[n][basic]).append('\n');
            }
        }

        System.out.print(output);
    }
}
