import java.io.*;
import java.util.*;

class Main {
    /*
     * 선수과목 관계를 위상 정렬한다.
     * 다음 과목의 최소 학기는 현재 과목 학기+1과 기존 값 중 큰 값이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subjects = Integer.parseInt(st.nextToken());
        int relations = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[subjects + 1];
        for (int i = 1; i <= subjects; i++) graph[i] = new ArrayList<>();

        int[] indegree = new int[subjects + 1];
        int[] semester = new int[subjects + 1];
        Arrays.fill(semester, 1);

        for (int i = 0; i < relations; i++) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            graph[before].add(after);
            indegree[after]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int subject = 1; subject <= subjects; subject++) {
            if (indegree[subject] == 0) queue.offer(subject);
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                semester[next] = Math.max(semester[next], semester[current] + 1);

                if (--indegree[next] == 0) queue.offer(next);
            }
        }

        StringBuilder output = new StringBuilder();

        for (int subject = 1; subject <= subjects; subject++) {
            output.append(semester[subject]).append(' ');
        }

        System.out.print(output);
    }
}
