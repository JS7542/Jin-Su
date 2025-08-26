import java.io.*;
import java.util.*;

class Main {
    /*
     * 배정 가능한 상한액을 이분 탐색한다.
     * 각 요청에 min(요청액, 상한액)을 적용한 합이 총예산 이하인지 확인한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] requests = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int right = 0;

        for (int i = 0; i < n; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, requests[i]);
        }

        int budget = Integer.parseInt(br.readLine());
        int left = 0;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = 0;

            for (int request : requests) sum += Math.min(request, mid);

            if (sum <= budget) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(answer);
    }
}
