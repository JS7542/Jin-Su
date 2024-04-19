import java.io.*;
import java.util.*;

class Main {
    /*
     * 테스트 케이스마다 두 정수와 합을 계산한다.
     * Case #x: A + B = C 형식으로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(tc).append(": ")
              .append(a).append(" + ").append(b).append(" = ").append(a + b)
              .append('\n');
        }

        System.out.print(sb);
    }
}
