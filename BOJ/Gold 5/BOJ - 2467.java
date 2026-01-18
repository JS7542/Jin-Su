import java.io.*;
import java.util.*;

class Main {
    /*
     * 이미 정렬된 용액 배열의 양 끝에서 두 포인터를 시작한다.
     * 합이 음수면 왼쪽, 양수면 오른쪽을 이동해 0에 가장 가까운 두 용액을 찾는다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] values = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) values[i] = Long.parseLong(st.nextToken());

        int left = 0;
        int right = n - 1;
        long best = Long.MAX_VALUE;
        long first = 0;
        long second = 0;

        while (left < right) {
            long sum = values[left] + values[right];
            long absolute = Math.abs(sum);

            if (absolute < best) {
                best = absolute;
                first = values[left];
                second = values[right];
            }

            if (sum < 0) left++;
            else right--;
        }

        System.out.print(first + " " + second);
    }
}
