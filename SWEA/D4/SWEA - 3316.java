import java.io.*;

class Solution {
    /*
     * 각 날짜의 참석자 집합을 비트마스크로 표현한다.
     * 전날 참석자와 한 명 이상 겹치고 당일 책임자를 포함하는 모든 집합으로 DP를 전이한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        final int MOD = 1_000_000_007;

        for (int tc = 1; tc <= tests; tc++) {
            String schedule = br.readLine();

            long[] previous = new long[16];
            previous[1] = 1;

            for (int day = 0; day < schedule.length(); day++) {
                int required = 1 << (schedule.charAt(day) - 'A');
                long[] current = new long[16];

                for (int before = 1; before < 16; before++) {
                    if (previous[before] == 0) continue;

                    for (int today = 1; today < 16; today++) {
                        if ((today & required) == 0 || (today & before) == 0) continue;

                        current[today] = (current[today] + previous[before]) % MOD;
                    }
                }

                previous = current;
            }

            long answer = 0;

            for (long count : previous) answer = (answer + count) % MOD;

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
