import java.io.*;
import java.util.*;

class Main {
    /*
     * 수열을 정렬하고 각 목표 인덱스마다 양 끝 포인터를 사용한다.
     * 목표 수 자신은 제외하면서 두 수의 합이 목표가 되는지 확인한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] numbers = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) numbers[i] = Long.parseLong(st.nextToken());

        Arrays.sort(numbers);
        int answer = 0;

        for (int target = 0; target < n; target++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                if (left == target) {
                    left++;
                    continue;
                }

                if (right == target) {
                    right--;
                    continue;
                }

                long sum = numbers[left] + numbers[right];

                if (sum == numbers[target]) {
                    answer++;
                    break;
                }

                if (sum < numbers[target]) left++;
                else right--;
            }
        }

        System.out.print(answer);
    }
}
