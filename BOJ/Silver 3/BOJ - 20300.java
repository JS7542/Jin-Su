import java.io.*;
import java.util.*;

class Main {
    /*
     * 근손실 값을 정렬하고 가장 작은 값과 가장 큰 값을 짝짓는다.
     * 홀수 개면 가장 큰 값은 단독으로 사용하며 각 날 합의 최댓값을 최소화한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] losses = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) losses[i] = Long.parseLong(st.nextToken());

        Arrays.sort(losses);

        long answer = 0;
        int left = 0;
        int right = n - 1;

        if (n % 2 == 1) {
            answer = losses[right--];
        }

        while (left < right) {
            answer = Math.max(answer, losses[left++] + losses[right--]);
        }

        System.out.print(answer);
    }
}
