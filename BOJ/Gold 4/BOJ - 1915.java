import java.io.*;

class Main {
    /*
     * 값이 1인 칸을 오른쪽 아래 꼭짓점으로 하는 최대 정사각형 변 길이를 계산한다.
     * 위, 왼쪽, 왼쪽 위 값의 최솟값에 1을 더하고 최대 넓이를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");

        int rows = Integer.parseInt(first[0]);
        int cols = Integer.parseInt(first[1]);

        int[] dp = new int[cols + 1];
        int maximum = 0;

        for (int r = 1; r <= rows; r++) {
            String line = br.readLine();
            int upperLeft = 0;

            for (int c = 1; c <= cols; c++) {
                int upper = dp[c];

                if (line.charAt(c - 1) == '1') {
                    dp[c] = Math.min(upperLeft, Math.min(dp[c], dp[c - 1])) + 1;
                    maximum = Math.max(maximum, dp[c]);
                } else {
                    dp[c] = 0;
                }

                upperLeft = upper;
            }
        }

        System.out.print(maximum * maximum);
    }
}
