import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 정수 A와 B를 입력받아 합을 계산한다.
     * 공백으로 구분된 값을 StringTokenizer로 읽어 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.print(a + b);
    }
}
