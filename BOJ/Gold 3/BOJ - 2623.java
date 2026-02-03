import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 PD가 제시한 가수 순서를 연속 간선으로 변환한다.
     * 위상 정렬 결과가 N명을 모두 포함하면 출력하고, 사이클이 있으면 0을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int singers = Integer.parseInt(st.nextToken());
        int producers = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[singers + 1];
        for (int i = 1; i <= singers; i++) graph[i] = new ArrayList<>();

        int[] indegree = new int[singers + 1];

        for (int i = 0; i < producers; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int previous = Integer.parseInt(st.nextToken());

            for (int j = 1; j < count; j++) {
                int current = Integer.parseInt(st.nextToken());
                graph[previous].add(current);
                indegree[current]++;
                previous = current;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int singer = 1; singer <= singers; singer++) {
            if (indegree[singer] == 0) queue.offer(singer);
        }

        StringBuilder output = new StringBuilder();
        int processed = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            output.append(current).append('\n');
            processed++;

            for (int next : graph[current]) {
                if (--indegree[next] == 0) queue.offer(next);
            }
        }

        System.out.print(processed == singers ? output : "0");
    }
}
