import java.io.*;
import java.util.*;

class Main {
    /*
     * 직사각형에서는 각 x좌표와 y좌표가 두 번씩 등장한다.
     * 같은 값끼리 XOR하면 사라지는 성질로 한 번만 나온 좌표를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;
        int y = 0;

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x ^= Integer.parseInt(st.nextToken());
            y ^= Integer.parseInt(st.nextToken());
        }

        System.out.print(x + " " + y);
    }
}
