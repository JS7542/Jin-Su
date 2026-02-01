import java.io.*;
import java.util.*;

class Main {
    /*
     * 수열을 정렬하고 두 포인터 차이가 M 이상이 되도록 오른쪽을 이동한다.
     * 조건을 만족하면 차이를 갱신하고 왼쪽을 이동해 더 작은 차이를 탐색한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long minimumDifference = Long.parseLong(st.nextToken());

        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) numbers[i] = Long.parseLong(br.readLine());

        Arrays.sort(numbers);

        int left = 0;
        int right = 0;
        long answer = Long.MAX_VALUE;

        while (left < n && right < n) {
            long difference = numbers[right] - numbers[left];

            if (difference < minimumDifference) {
                right++;
            } else {
                answer = Math.min(answer, difference);
                left++;
            }
        }

        System.out.print(answer);
    }
}
