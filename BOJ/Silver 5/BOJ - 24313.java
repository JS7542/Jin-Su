import java.io.*;
import java.util.*;

class Main {
    /*
     * n0에서 a1*n+a0가 c*n 이하인지 확인하고 a1이 c 이하인지 검사한다.
     * 두 조건을 모두 만족하면 1, 아니면 0을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        boolean valid = a1 * n0 + a0 <= c * n0 && a1 <= c;
        System.out.print(valid ? 1 : 0);
    }
}
