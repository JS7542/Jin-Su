import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 정수 A와 B의 크기를 비교한다.
     * A가 크면 >, 작으면 <, 같으면 ==를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a > b) System.out.print(">");
        else if (a < b) System.out.print("<");
        else System.out.print("==");
    }
}
