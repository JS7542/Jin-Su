import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 정수 A와 B를 입력받아 A-B를 계산한다.
     * 입력값을 정수로 변환한 뒤 결과를 바로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.print(a - b);
    }
}
