import java.io.*;
import java.util.*;

class Solution {
    /*
     * 길이별 증가 부분수열의 가장 작은 마지막 값을 tails 배열에 저장한다.
     * 각 수의 위치를 이분 탐색해 교체하며 LIS 길이를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] tails = new int[n];
            int length = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                int value = Integer.parseInt(st.nextToken());
                int left = 0;
                int right = length;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (tails[mid] < value) left = mid + 1;
                    else right = mid;
                }

                tails[left] = value;
                if (left == length) length++;
            }

            output.append('#').append(tc).append(' ').append(length).append('\n');
        }

        System.out.print(output);
    }
}
