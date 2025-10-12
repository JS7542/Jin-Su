import java.io.*;

class Main {
    /*
     * 각 행에서 사자를 놓지 않음, 왼쪽에 놓음, 오른쪽에 놓음 상태를 구분한다.
     * 이전 행에서 인접하지 않는 상태만 이어 붙여 경우의 수를 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int MOD = 9901;

        int empty = 1;
        int left = 1;
        int right = 1;

        for (int row = 2; row <= n; row++) {
            int nextEmpty = (empty + left + right) % MOD;
            int nextLeft = (empty + right) % MOD;
            int nextRight = (empty + left) % MOD;

            empty = nextEmpty;
            left = nextLeft;
            right = nextRight;
        }

        System.out.print((empty + left + right) % MOD);
    }
}
