import java.io.*;
import java.util.*;

class Main {
    /*
     * 큰 범위의 세 정수를 입력받아 합을 계산한다.
     * int 범위를 넘을 수 있으므로 long 자료형을 사용한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        System.out.print(a + b + c);
    }
}
