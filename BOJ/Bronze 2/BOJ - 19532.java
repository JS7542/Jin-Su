import java.io.*;
import java.util.*;

class Main {
    /*
     * 가능한 x와 y 범위인 -999부터 999까지 모든 조합을 검사한다.
     * 두 일차방정식을 동시에 만족하는 유일한 해를 찾으면 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (a * x + b * y == c && d * x + e * y == f) {
                    System.out.print(x + " " + y);
                    return;
                }
            }
        }
    }
}
