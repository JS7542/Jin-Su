import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 구매 항목의 가격과 개수를 곱해 실제 총액을 계산한다.
     * 영수증의 총 금액과 같으면 Yes, 다르면 No를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int expected = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());
        int actual = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            actual += price * count;
        }

        System.out.print(expected == actual ? "Yes" : "No");
    }
}
