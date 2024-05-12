import java.io.*;

class Solution {
    /*
     * 파스칼 삼각형의 양 끝은 1로 채우고 내부는 위쪽 두 수의 합으로 계산한다.
     * 완성된 N개 행을 테스트 케이스 번호 다음 줄부터 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] triangle = new int[n][n];

            for (int i = 0; i < n; i++) {
                triangle[i][0] = triangle[i][i] = 1;
                for (int j = 1; j < i; j++) {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }

            sb.append('#').append(tc).append('\n');
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) sb.append(triangle[i][j]).append(' ');
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}
