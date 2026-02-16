import java.io.*;
import java.util.*;

class Main {
    /*
     * 용액 값을 정렬하고 양 끝 포인터의 합을 확인한다.
     * 합이 음수면 왼쪽을, 양수면 오른쪽을 이동하며 0에 가장 가까운 쌍을 찾는다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] values = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) values[i] = Long.parseLong(st.nextToken());

        Arrays.sort(values);

        int left = 0;
        int right = n - 1;
        long bestAbsolute = Long.MAX_VALUE;
        long first = 0;
        long second = 0;

        while (left < right) {
            long sum = values[left] + values[right];
            long absolute = Math.abs(sum);

            if (absolute < bestAbsolute) {
                bestAbsolute = absolute;
                first = values[left];
                second = values[right];
            }

            if (sum < 0) left++;
            else right--;
        }

        System.out.print(first + " " + second);
    }
}
