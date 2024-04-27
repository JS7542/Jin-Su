import java.io.*;

class Solution {
    /*
     * 입력값을 2, 3, 5, 7, 11로 계속 나누며 각 소인수의 지수를 센다.
     * 다섯 지수를 문제에서 정한 순서대로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] primes = {2, 3, 5, 7, 11};
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] count = new int[5];

            for (int i = 0; i < primes.length; i++) {
                while (n % primes[i] == 0) {
                    count[i]++;
                    n /= primes[i];
                }
            }

            sb.append('#').append(tc);
            for (int value : count) sb.append(' ').append(value);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
