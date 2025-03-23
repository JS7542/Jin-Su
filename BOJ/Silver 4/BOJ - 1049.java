import java.io.*;
import java.util.*;

class Main {
    /*
     * 패키지 최저가와 낱개 최저가만 알면 최적 구매 비용을 계산할 수 있다.
     * 전부 패키지, 패키지+낱개, 전부 낱개 세 경우 중 최솟값을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int needed = Integer.parseInt(st.nextToken());
        int brands = Integer.parseInt(st.nextToken());

        int packagePrice = Integer.MAX_VALUE;
        int singlePrice = Integer.MAX_VALUE;

        for (int i = 0; i < brands; i++) {
            st = new StringTokenizer(br.readLine());
            packagePrice = Math.min(packagePrice, Integer.parseInt(st.nextToken()));
            singlePrice = Math.min(singlePrice, Integer.parseInt(st.nextToken()));
        }

        int onlyPackages = ((needed + 5) / 6) * packagePrice;
        int mixed = (needed / 6) * packagePrice + (needed % 6) * singlePrice;
        int onlySingles = needed * singlePrice;

        System.out.print(Math.min(onlyPackages, Math.min(mixed, onlySingles)));
    }
}
