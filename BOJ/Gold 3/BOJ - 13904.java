import java.io.*;
import java.util.*;

class Main {
    static class Assignment {
        int deadline;
        int score;

        Assignment(int deadline, int score) {
            this.deadline = deadline;
            this.score = score;
        }
    }

    /*
     * 마감일이 늦은 과제부터 확인하고 가능한 과제를 최대 힙에 넣는다.
     * 각 날짜마다 점수가 가장 높은 과제를 하나 선택한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Assignment[] assignments = new Assignment[n];
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            assignments[i] = new Assignment(deadline, score);
            maxDeadline = Math.max(maxDeadline, deadline);
        }

        Arrays.sort(
                assignments,
                (a, b) -> Integer.compare(b.deadline, a.deadline)
        );

        PriorityQueue<Integer> scores =
                new PriorityQueue<>(Collections.reverseOrder());

        int index = 0;
        int answer = 0;

        for (int day = maxDeadline; day >= 1; day--) {
            while (index < n && assignments[index].deadline >= day) {
                scores.offer(assignments[index].score);
                index++;
            }

            if (!scores.isEmpty()) answer += scores.poll();
        }

        System.out.print(answer);
    }
}
