import java.io.*;
import java.util.*;

class Main {
    /*
     * 과자 한 개 가격과 개수를 곱해 전체 구매 금액을 계산한다.
     * 가진 돈보다 부족한 금액을 구하고 음수이면 0을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int price = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        System.out.print(Math.max(0, price * count - money));
    }
}
