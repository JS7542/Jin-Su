import java.io.*;
import java.util.*;

class Solution {
    /*
     * 각 길이의 증가 부분수열이 가질 수 있는 가장 작은 마지막 값을 배열에 저장한다.
     * 현재 값을 이분 탐색 위치에 교체해 O(N log N)으로 LIS 길이를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int count = Integer.parseInt(br.readLine());
            int[] tails = new int[count];
            int length = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < count; i++) {
                int value = Integer.parseInt(st.nextToken());
                int left = 0;
                int right = length;

                while (left < right) {
                    int middle = (left + right) / 2;

                    if (tails[middle] < value) left = middle + 1;
                    else right = middle;
                }

                tails[left] = value;

                if (left == length) length++;
            }

            output.append('#').append(tc).append(' ')
                    .append(length).append('\n');
        }

        System.out.print(output);
    }
}
