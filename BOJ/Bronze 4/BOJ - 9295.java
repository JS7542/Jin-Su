import java.io.*;
import java.util.*;

class Main {
    /*
     * 테스트 케이스마다 두 주사위 값을 더한다.
     * Case 번호와 합을 지정된 형식으로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            sb.append("Case ").append(tc).append(": ").append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
