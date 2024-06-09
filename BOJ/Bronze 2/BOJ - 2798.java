import java.io.*;
import java.util.*;

class Main {
    /*
     * 서로 다른 카드 세 장을 고르는 모든 조합을 확인한다.
     * 합이 M을 넘지 않는 경우 중 가장 큰 합을 정답으로 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) cards[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= m) answer = Math.max(answer, sum);
                }
            }
        }

        System.out.print(answer);
    }
}
