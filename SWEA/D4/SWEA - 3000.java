import java.io.*;
import java.util.*;

class Solution {
    /*
     * 작은 절반은 최대 힙, 큰 절반은 최소 힙으로 관리하고 A를 중간값으로 유지한다.
     * 두 수를 추가할 때 세 값의 순서를 조정해 매 단계 중간값을 누적한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        final int MOD = 20_171_109;

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pairs = Integer.parseInt(st.nextToken());
            int middle = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> lower =
                    new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> upper = new PriorityQueue<>();

            long sum = 0;

            for (int i = 0; i < pairs; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                if (first < middle) lower.offer(first);
                else upper.offer(first);

                if (second < middle) lower.offer(second);
                else upper.offer(second);

                while (lower.size() > upper.size()) {
                    upper.offer(middle);
                    middle = lower.poll();
                }

                while (upper.size() > lower.size()) {
                    lower.offer(middle);
                    middle = upper.poll();
                }

                sum = (sum + middle) % MOD;
            }

            output.append('#').append(tc).append(' ')
                    .append(sum).append('\n');
        }

        System.out.print(output);
    }
}
