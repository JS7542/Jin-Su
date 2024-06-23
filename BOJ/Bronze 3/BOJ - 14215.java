import java.io.*;
import java.util.*;

class Main {
    /*
     * 가장 긴 막대가 나머지 두 막대의 합보다 작도록 길이를 조정한다.
     * 가능한 최대 둘레는 min(전체 합, 나머지 두 변의 합×2-1)이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int sum = a + b + c;
        int max = Math.max(a, Math.max(b, c));
        System.out.print(Math.min(sum, (sum - max) * 2 - 1));
    }
}
