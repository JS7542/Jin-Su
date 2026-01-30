import java.io.*;
import java.util.*;

class Main {
    /*
     * 오른쪽 포인터를 늘려 연속합을 키운다.
     * 합이 S 이상이면 왼쪽 포인터를 줄이며 가능한 최소 길이를 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long target = Long.parseLong(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        long sum = 0;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += numbers[right];

            while (sum >= target) {
                answer = Math.min(answer, right - left + 1);
                sum -= numbers[left++];
            }
        }

        System.out.print(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
