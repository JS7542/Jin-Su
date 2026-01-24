import java.util.*;

class Solution {
    /*
     * 작업을 요청 시간순으로 정렬하고, 대기 중 작업은 소요 시간 최소 힙에 넣는다.
     * 실행 가능한 가장 짧은 작업부터 처리해 반환 시간의 평균을 최소화한다.
     */
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));

        PriorityQueue<int[]> waiting = new PriorityQueue<>(
                Comparator.comparingInt(job -> job[1])
        );

        int time = 0;
        int index = 0;
        int total = 0;
        int completed = 0;

        while (completed < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= time) {
                waiting.offer(jobs[index++]);
            }

            if (waiting.isEmpty()) {
                time = jobs[index][0];
                continue;
            }

            int[] job = waiting.poll();
            time += job[1];
            total += time - job[0];
            completed++;
        }

        return total / jobs.length;
    }
}
