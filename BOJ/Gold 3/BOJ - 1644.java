import java.io.*;
import java.util.*;

class Main {
    /*
     * 에라토스테네스의 체로 N 이하 소수 목록을 만든다.
     * 두 포인터로 연속한 소수 합을 조절하며 N이 되는 경우의 수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n < 2) {
            System.out.print(0);
            return;
        }

        boolean[] composite = new boolean[n + 1];

        for (int number = 2; number * number <= n; number++) {
            if (composite[number]) continue;

            for (int multiple = number * number; multiple <= n; multiple += number) {
                composite[multiple] = true;
            }
        }

        List<Integer> primes = new ArrayList<>();

        for (int number = 2; number <= n; number++) {
            if (!composite[number]) primes.add(number);
        }

        int left = 0;
        int sum = 0;
        int answer = 0;

        for (int right = 0; right <= primes.size(); right++) {
            if (right < primes.size()) sum += primes.get(right);

            while (sum >= n && left < primes.size()) {
                if (sum == n) answer++;
                sum -= primes.get(left++);
            }
        }

        System.out.print(answer);
    }
}
