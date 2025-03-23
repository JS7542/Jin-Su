import java.io.*;
import java.util.*;

class Main {
    /*
     * 가격을 내림차순으로 정렬해 비싼 상품끼리 세 개씩 묶는다.
     * 각 묶음의 세 번째 상품을 무료로 처리하고 나머지 가격을 합산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] prices = new Integer[n];

        for (int i = 0; i < n; i++) prices[i] = Integer.parseInt(br.readLine());

        Arrays.sort(prices, Collections.reverseOrder());

        long answer = 0;

        for (int i = 0; i < n; i++) {
            if (i % 3 != 2) answer += prices[i];
        }

        System.out.print(answer);
    }
}
