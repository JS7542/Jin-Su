import java.util.*;

class Solution {
    /*
     * 상담 유형별 상담원 수에 따른 총 대기 시간을 우선순위 큐 시뮬레이션으로 미리 계산한다.
     * K개 유형에 총 N명을 배분하는 모든 조합 중 대기 시간 합의 최솟값을 구한다.
     */
    private int k;
    private int n;
    private int[][] wait;
    private int answer = Integer.MAX_VALUE;

    public int solution(int k, int n, int[][] reqs) {
        this.k = k;
        this.n = n;
        wait = new int[k][n + 1];

        List<int[]>[] requests = new ArrayList[k];

        for (int type = 0; type < k; type++) requests[type] = new ArrayList<>();

        for (int[] request : reqs) {
            requests[request[2] - 1].add(request);
        }

        for (int type = 0; type < k; type++) {
            for (int mentors = 1; mentors <= n - k + 1; mentors++) {
                wait[type][mentors] = simulate(requests[type], mentors);
            }
        }

        allocate(0, n, 0);
        return answer;
    }

    private void allocate(int type, int remaining, int totalWait) {
        if (totalWait >= answer) return;

        if (type == k) {
            if (remaining == 0) answer = totalWait;
            return;
        }

        int remainingTypes = k - type - 1;

        for (int mentors = 1; mentors <= remaining - remainingTypes; mentors++) {
            allocate(
                    type + 1,
                    remaining - mentors,
                    totalWait + wait[type][mentors]
            );
        }
    }

    private int simulate(List<int[]> requests, int mentors) {
        PriorityQueue<Integer> finishTimes = new PriorityQueue<>();

        for (int mentor = 0; mentor < mentors; mentor++) finishTimes.offer(0);

        int totalWait = 0;

        for (int[] request : requests) {
            int available = finishTimes.poll();
            int start = Math.max(available, request[0]);

            totalWait += start - request[0];
            finishTimes.offer(start + request[1]);
        }

        return totalWait;
    }
}
