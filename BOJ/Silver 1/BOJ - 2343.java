import java.io.*;
import java.util.*;

class Main {
    /*
     * 블루레이 크기를 정하면 순서대로 강의를 담아 필요한 블루레이 수를 계산할 수 있다.
     * M개 이하로 담을 수 있는 최소 크기를 이분 탐색한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lessons = Integer.parseInt(st.nextToken());
        int disks = Integer.parseInt(st.nextToken());

        int[] durations = new int[lessons];
        st = new StringTokenizer(br.readLine());

        long left = 0;
        long right = 0;

        for (int i = 0; i < lessons; i++) {
            durations[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, durations[i]);
            right += durations[i];
        }

        while (left < right) {
            long middle = (left + right) / 2;
            int used = 1;
            long current = 0;

            for (int duration : durations) {
                if (current + duration > middle) {
                    used++;
                    current = 0;
                }

                current += duration;
            }

            if (used <= disks) right = middle;
            else left = middle + 1;
        }

        System.out.print(left);
    }
}
