import java.io.*;

class Solution {
    /*
     * N의 배수를 차례로 보며 등장한 숫자를 비트마스크에 표시한다.
     * 0부터 9까지 모든 비트가 채워지는 첫 배수를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            int mask = 0;
            int multiplier = 0;
            int value = 0;

            while (mask != (1 << 10) - 1) {
                value = n * ++multiplier;
                int number = value;

                if (number == 0) mask |= 1;

                while (number > 0) {
                    mask |= 1 << (number % 10);
                    number /= 10;
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(value).append('\n');
        }

        System.out.print(output);
    }
}
