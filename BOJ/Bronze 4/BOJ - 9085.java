import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 테스트 케이스에서 N개의 정수를 입력받아 합산한다.
     * 테스트 케이스별 합을 StringBuilder에 저장해 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;

            for (int i = 0; i < n; i++) sum += Integer.parseInt(st.nextToken());

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
