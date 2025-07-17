import java.io.*;

class Main {
    /*
     * N×N 곱셈표에서 middle 이하인 수의 개수를 각 행별로 계산한다.
     * 그 개수가 K 이상이 되는 가장 작은 값을 이분 탐색한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long left = 1;
        long right = k;

        while (left < right) {
            long middle = (left + right) / 2;
            long count = 0;

            for (long row = 1; row <= n; row++) {
                count += Math.min(n, middle / row);
            }

            if (count >= k) right = middle;
            else left = middle + 1;
        }

        System.out.print(left);
    }
}
