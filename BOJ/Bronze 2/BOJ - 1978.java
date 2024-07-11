import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 수에 대해 2부터 제곱근까지 나누어 소수 여부를 검사한다.
     * 1보다 크고 나누어지는 수가 없는 입력의 개수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (isPrime(value)) answer++;
        }

        System.out.print(answer);
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
