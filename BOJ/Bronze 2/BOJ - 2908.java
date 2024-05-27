import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 세 자리 수를 문자열로 입력받아 각각 뒤집는다.
     * 뒤집힌 값을 정수로 변환한 뒤 더 큰 수를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        System.out.print(Math.max(a, b));
    }
}
