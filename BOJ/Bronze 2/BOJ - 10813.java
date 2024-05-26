import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 바구니에 처음에는 같은 번호의 공을 넣는다.
     * 명령마다 두 바구니의 공을 교환하고 최종 상태를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] basket = new int[n + 1];
        for (int i = 1; i <= n; i++) basket[i] = i;

        for (int command = 0; command < m; command++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = basket[a];
            basket[a] = basket[b];
            basket[b] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(basket[i]).append(' ');
        System.out.print(sb);
    }
}
