import java.io.*;
import java.util.*;

class Main {
    /*
     * 바구니를 1부터 N까지 초기화하고 각 명령 구간을 양 끝에서 교환한다.
     * 모든 구간 뒤집기를 수행한 후 바구니 순서를 출력한다.
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
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            while (left < right) {
                int temp = basket[left];
                basket[left++] = basket[right];
                basket[right--] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(basket[i]).append(' ');
        System.out.print(sb);
    }
}
