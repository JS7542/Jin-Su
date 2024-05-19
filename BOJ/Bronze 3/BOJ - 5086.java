import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 수가 0 0이 될 때까지 약수와 배수 관계를 확인한다.
     * 첫 수가 둘째 수의 약수인지, 배수인지, 둘 다 아닌지 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) break;
            if (b % a == 0) sb.append("factor");
            else if (a % b == 0) sb.append("multiple");
            else sb.append("neither");
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
