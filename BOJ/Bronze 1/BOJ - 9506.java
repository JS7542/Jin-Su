import java.io.*;
import java.util.*;

class Main {
    /*
     * 자기 자신을 제외한 약수를 모두 구해 합을 계산한다.
     * 완전수이면 약수의 덧셈식을, 아니면 완전수가 아니라는 문장을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            List<Integer> divisors = new ArrayList<>();
            int sum = 0;

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    divisors.add(i);
                    sum += i;
                }
            }

            if (sum == n) {
                out.append(n).append(" = ");
                for (int i = 0; i < divisors.size(); i++) {
                    if (i > 0) out.append(" + ");
                    out.append(divisors.get(i));
                }
            } else {
                out.append(n).append(" is NOT perfect.");
            }
            out.append('\n');
        }

        System.out.print(out);
    }
}
