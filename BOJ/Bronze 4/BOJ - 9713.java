import java.io.*;

class Main {
    /*
     * 각 테스트 케이스의 N 이하 홀수를 1부터 2씩 증가시키며 더한다.
     * 홀수 합을 테스트 케이스마다 한 줄에 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;

            for (int value = 1; value <= n; value += 2) sum += value;

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
