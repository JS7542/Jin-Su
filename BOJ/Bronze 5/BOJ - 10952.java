import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 정수의 합을 반복해서 계산하되 0 0이 입력되면 종료한다.
     * 종료 전까지의 결과를 StringBuilder에 누적해 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;
            sb.append(a + b).append('\n');
        }
        System.out.print(sb);
    }
}
