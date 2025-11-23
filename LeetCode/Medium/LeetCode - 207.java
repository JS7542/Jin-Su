import java.util.*;

class Solution {
    /*
     * 선수 과목 관계로 인접 리스트와 진입 차수를 만든다.
     * 진입 차수가 0인 과목부터 위상 정렬해 모든 과목 처리 여부를 확인한다.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();

        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) queue.offer(course);
        }

        int completed = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            completed++;

            for (int next : graph[current]) {
                if (--indegree[next] == 0) queue.offer(next);
            }
        }

        return completed == numCourses;
    }
}
