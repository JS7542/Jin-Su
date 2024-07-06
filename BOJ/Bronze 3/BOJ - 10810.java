import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 명령의 i번부터 j번 바구니까지 번호 k를 덮어쓴다.
     * 모든 명령을 처리한 뒤 바구니의 공 번호를 순서대로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] basket = new int[n + 1];

        for (int command = 0; command < m; command++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int index = i; index <= j; index++) basket[index] = k;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(basket[i]).append(' ');
        System.out.print(sb);
    }
}
