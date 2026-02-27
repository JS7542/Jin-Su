import java.io.*;
import java.util.*;

class Main {
    /*
     * 주어진 시간 동안 각 심사대가 처리 가능한 사람 수를 합산한다.
     * M명을 처리할 수 있는 최소 시간을 이분 탐색한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int counters = Integer.parseInt(st.nextToken());
        long people = Long.parseLong(st.nextToken());

        long[] times = new long[counters];
        long maximum = 0;

        for (int i = 0; i < counters; i++) {
            times[i] = Long.parseLong(br.readLine());
            maximum = Math.max(maximum, times[i]);
        }

        long left = 0;
        long right = maximum * people;

        while (left < right) {
            long middle = left + (right - left) / 2;
            long processed = 0;

            for (long time : times) {
                processed += middle / time;

                if (processed >= people) break;
            }

            if (processed >= people) right = middle;
            else left = middle + 1;
        }

        System.out.print(left);
    }
}
