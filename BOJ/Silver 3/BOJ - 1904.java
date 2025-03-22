import java.io.*;

class Main {
    /*
     * 길이 N의 문자열은 마지막에 1을 붙이거나 00을 붙이는 두 경우로 나뉜다.
     * 피보나치 형태의 점화식을 15746으로 나눈 나머지로 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int MOD = 15746;

        if (n == 1) {
            System.out.print(1);
            return;
        }

        int twoBack = 1;
        int oneBack = 2;

        for (int length = 3; length <= n; length++) {
            int current = (twoBack + oneBack) % MOD;
            twoBack = oneBack;
            oneBack = current;
        }

        System.out.print(oneBack);
    }
}
