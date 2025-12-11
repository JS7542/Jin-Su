import java.io.*;
import java.util.*;

class Main {
    /*
     * 키 비교 결과를 방향 그래프로 만들고 진입 차수가 0인 학생부터 처리한다.
     * 위상 정렬 순서가 모든 비교 조건을 만족하는 줄 세우기 결과다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        int[] indegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int shorter = Integer.parseInt(st.nextToken());
            int taller = Integer.parseInt(st.nextToken());

            graph[shorter].add(taller);
            indegree[taller]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int student = 1; student <= n; student++) {
            if (indegree[student] == 0) queue.offer(student);
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
