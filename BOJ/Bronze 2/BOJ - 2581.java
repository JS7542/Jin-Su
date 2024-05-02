import java.io.*;

class Main {
    /*
     * M부터 N까지의 각 수를 제곱근 범위로 나누며 소수인지 확인한다.
     * 소수의 합과 최솟값을 출력하고 소수가 없으면 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = -1;

        for (int value = m; value <= n; value++) {
            if (isPrime(value)) {
                sum += value;
                if (min == -1) min = value;
            }
        }

        if (min == -1) System.out.print(-1);
        else System.out.print(sum + "\n" + min);
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
