import java.io.*;
import java.util.*;

class Main {
    /*
     * 사과와 오렌지를 서로 반대 상자로 옮기는 두 경우를 계산한다.
     * A+D와 B+C 중 더 작은 이동 횟수를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer first = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(first.nextToken());
        int b = Integer.parseInt(first.nextToken());

        StringTokenizer second = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(second.nextToken());
        int d = Integer.parseInt(second.nextToken());

        System.out.print(Math.min(a + d, b + c));
    }
}
