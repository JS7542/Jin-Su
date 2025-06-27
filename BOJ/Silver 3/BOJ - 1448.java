import java.io.*;
import java.util.*;

class Main {
    /*
     * 막대 길이를 오름차순으로 정렬한다.
     * 가장 긴 막대부터 연속한 세 막대를 확인해 삼각형 조건을 만족하는 첫 둘레를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] sticks = new int[n];

        for (int i = 0; i < n; i++) sticks[i] = Integer.parseInt(br.readLine());

        Arrays.sort(sticks);

        for (int i = n - 1; i >= 2; i--) {
            if (sticks[i - 2] + sticks[i - 1] > sticks[i]) {
                System.out.print(sticks[i - 2] + sticks[i - 1] + sticks[i]);
                return;
            }
        }

        System.out.print(-1);
    }
}
