import java.io.*;
import java.util.*;

class Main {
    /*
     * 선행 문제 관계를 위상 정렬로 처리한다.
     * 동시에 풀 수 있는 문제 중 번호가 작은 것을 고르기 위해 최소 힙을 사용한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int problems = Integer.parseInt(st.nextToken());
        int relations = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[problems + 1];
        for (int i = 1; i <= problems; i++) graph[i] = new ArrayList<>();

        int[] indegree = new int[problems + 1];

        for (int i = 0; i < relations; i++) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            graph[before].add(after);
            indegree[after]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int problem = 1; problem <= problems; problem++) {
            if (indegree[problem] == 0) queue.offer(problem);
        }

        StringBuilder output = new StringBuilder();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            output.append(current).append(' ');

            for (int next : graph[current]) {
                if (--indegree[next] == 0) queue.offer(next);
            }
        }

        System.out.print(output);
    }
}
