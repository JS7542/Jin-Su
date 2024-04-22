import java.io.*;

class Solution {
    /*
     * 가운데 열을 기준으로 각 행에서 수확할 마름모 범위의 너비를 계산한다.
     * dist = mid - |mid-row| 범위 안의 숫자만 더해 전체 수익을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            int mid = n / 2;
            int sum = 0;

            for (int row = 0; row < n; row++) {
                String line = br.readLine().trim();
                int dist = mid - Math.abs(mid - row);

                for (int col = mid - dist; col <= mid + dist; col++) {
                    sum += line.charAt(col) - '0';
                }
            }

            sb.append('#').append(tc).append(' ').append(sum).append('\n');
        }
        System.out.print(sb);
    }
}
