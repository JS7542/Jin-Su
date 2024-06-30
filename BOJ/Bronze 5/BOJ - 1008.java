import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 실수를 입력받아 A/B 값을 계산한다.
     * double 자료형을 사용해 소수점 결과를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        System.out.print(a / b);
    }
}
