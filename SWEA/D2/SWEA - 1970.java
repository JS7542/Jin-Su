import java.io.*;

class Solution {
    /*
     * 큰 화폐 단위부터 가능한 만큼 사용하고 남은 금액을 다음 단위로 넘긴다.
     * 각 화폐의 사용 개수를 50000원부터 10원까지 차례대로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int amount = Integer.parseInt(br.readLine().trim());
            sb.append('#').append(tc).append('\n');

            for (int unit : money) {
                sb.append(amount / unit).append(' ');
                amount %= unit;
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
