import java.io.*;

class Main {
    /*
     * 가능한 생성자 후보를 작은 수부터 순회하며 후보와 각 자리수의 합을 계산한다.
     * 처음으로 N을 만드는 후보가 가장 작은 생성자이며 없으면 0을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int candidate = 1; candidate < n; candidate++) {
            int sum = candidate;
            int value = candidate;

            while (value > 0) {
                sum += value % 10;
                value /= 10;
            }

            if (sum == n) {
                answer = candidate;
                break;
            }
        }

        System.out.print(answer);
    }
}
