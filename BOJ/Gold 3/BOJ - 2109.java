import java.io.*;
import java.util.*;

class Main {
    static class Lecture {
        int pay;
        int deadline;

        Lecture(int pay, int deadline) {
            this.pay = pay;
            this.deadline = deadline;
        }
    }

    /*
     * 마감일이 늦은 강연부터 확인하고 해당 날짜에 가능한 강연을 최대 힙에 넣는다.
     * 매일 수입이 가장 큰 강연을 하나 선택한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[n];
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int pay = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(pay, deadline);
            maxDeadline = Math.max(maxDeadline, deadline);
        }

        Arrays.sort(
                lectures,
                (a, b) -> Integer.compare(b.deadline, a.deadline)
        );

        PriorityQueue<Integer> payments =
                new PriorityQueue<>(Collections.reverseOrder());

        int index = 0;
        int answer = 0;

        for (int day = maxDeadline; day >= 1; day--) {
            while (index < n && lectures[index].deadline >= day) {
                payments.offer(lectures[index].pay);
                index++;
            }

            if (!payments.isEmpty()) answer += payments.poll();
        }

        System.out.print(answer);
    }
}
