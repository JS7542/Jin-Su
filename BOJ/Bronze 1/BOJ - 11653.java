import java.io.*;

class Main {
    /*
     * 가장 작은 소수 후보 2부터 시작해 나누어떨어지는 동안 반복 출력한다.
     * 나눈 몫을 다시 같은 수로 검사해 소인수를 오름차순으로 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int factor = 2; factor * factor <= n; factor++) {
            while (n % factor == 0) {
                sb.append(factor).append('\n');
                n /= factor;
            }
        }

        if (n > 1) sb.append(n);
        System.out.print(sb);
    }
}
