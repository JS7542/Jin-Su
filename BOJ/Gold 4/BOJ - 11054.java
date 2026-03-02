import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 위치까지의 증가 부분수열 길이와 그 위치부터의 감소 부분수열 길이를 구한다.
     * 두 길이를 더하고 중심 원소가 중복되므로 1을 빼 최댓값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] increasing = new int[n];
        int[] decreasing = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            increasing[i] = 1;

            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    increasing[i] = Math.max(increasing[i], increasing[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            decreasing[i] = 1;

            for (int j = n - 1; j > i; j--) {
                if (numbers[j] < numbers[i]) {
                    decreasing[i] = Math.max(decreasing[i], decreasing[j] + 1);
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, increasing[i] + decreasing[i] - 1);
        }

        System.out.print(answer);
    }
}
