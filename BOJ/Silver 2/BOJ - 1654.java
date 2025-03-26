import java.io.*;
import java.util.*;

class Main {
    /*
     * 만들 수 있는 랜선 길이를 이분 탐색한다.
     * 현재 길이로 K개의 랜선을 잘라 얻는 개수가 N 이상이면 길이를 늘린다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int needed = Integer.parseInt(st.nextToken());

        long[] cables = new long[k];
        long right = 0;

        for (int i = 0; i < k; i++) {
            cables[i] = Long.parseLong(br.readLine());
            right = Math.max(right, cables[i]);
        }

        long left = 1;
        long answer = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = 0;

            for (long cable : cables) count += cable / mid;

            if (count >= needed) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(answer);
    }
}
