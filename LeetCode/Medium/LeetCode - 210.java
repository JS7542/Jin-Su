import java.util.*;

class Solution {
    /*
     * 선수 과목 관계로 그래프와 진입 차수를 만든다.
     * 진입 차수가 0인 과목부터 위상 정렬하고 모든 과목을 처리하지 못하면 빈 배열을 반환한다.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            graph[course] = new ArrayList<>();
        }

        for (int[] relation : prerequisites) {
            graph[relation[1]].add(relation[0]);
            indegree[relation[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) queue.offer(course);
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[index++] = current;

            for (int next : graph[current]) {
                if (--indegree[next] == 0) queue.offer(next);
            }
        }

        return index == numCourses ? order : new int[0];
    }
}
