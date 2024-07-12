import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 정수 A와 B를 입력받아 곱을 계산한다.
     * 공백 단위로 값을 분리하고 정수로 변환해 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.print(a * b);
    }
}
