import java.io.*;
import java.util.*;

class Main {
    static int[][][] memo = new int[21][21][21];

    /*
     * 입력값이 1~20 범위일 때 결과를 3차원 메모 배열에 저장한다.
     * 이미 계산한 상태는 재사용해 재귀 호출의 중복을 제거한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            output.append("w(")
                    .append(a).append(", ")
                    .append(b).append(", ")
                    .append(c).append(") = ")
                    .append(w(a, b, c))
                    .append('\n');
        }

        System.out.print(output);
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);

        if (memo[a][b][c] != 0) return memo[a][b][c];

        if (a < b && b < c) {
            memo[a][b][c] = w(a, b, c - 1)
                    + w(a, b - 1, c - 1)
                    - w(a, b - 1, c);
        } else {
            memo[a][b][c] = w(a - 1, b, c)
                    + w(a - 1, b - 1, c)
                    + w(a - 1, b, c - 1)
                    - w(a - 1, b - 1, c - 1);
        }

        return memo[a][b][c];
    }
}
