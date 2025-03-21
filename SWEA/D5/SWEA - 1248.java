import java.io.*;
import java.util.*;

class Solution {
    /*
     * 각 정점의 부모를 저장해 첫 정점의 조상들을 표시한다.
     * 두 번째 정점에서 위로 올라가 처음 표시된 정점을 공통 조상으로 찾고 서브트리 크기를 센다.
     */
    static List<Integer>[] children;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int vertices = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            int[] parent = new int[vertices + 1];
            children = new ArrayList[vertices + 1];

            for (int node = 1; node <= vertices; node++) {
                children[node] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < edges; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                parent[to] = from;
                children[from].add(to);
            }

            boolean[] ancestor = new boolean[vertices + 1];

            while (first != 0) {
                ancestor[first] = true;
                first = parent[first];
            }

            while (!ancestor[second]) second = parent[second];

            output.append('#').append(tc).append(' ')
                    .append(second).append(' ')
                    .append(subtreeSize(second)).append('\n');
        }

        System.out.print(output);
    }

    static int subtreeSize(int node) {
        int size = 1;

        for (int child : children[node]) {
            size += subtreeSize(child);
        }

        return size;
    }
}
