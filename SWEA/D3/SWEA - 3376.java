import java.io.*;

class Solution {
    /*
     * 초기 다섯 항을 설정한다.
     * 여섯 번째 항부터 P(n)=P(n-1)+P(n-5) 점화식으로 값을 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());

        long[] padovan = new long[101];
        padovan[1] = 1;
        padovan[2] = 1;
        padovan[3] = 1;
        padovan[4] = 2;
        padovan[5] = 2;

        for (int n = 6; n <= 100; n++) {
            padovan[n] = padovan[n - 1] + padovan[n - 5];
        }

        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int n = Integer.parseInt(br.readLine());

            output.append('#').append(tc).append(' ')
                    .append(padovan[n]).append('\n');
        }

        System.out.print(output);
    }
}
