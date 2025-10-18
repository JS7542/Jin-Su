import java.io.*;
import java.util.*;

class Main {
    /*
     * B에서 A로 역연산을 수행한다.
     * 끝자리가 1이면 1을 제거하고, 짝수면 2로 나누며 그 외에는 변환할 수 없다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int operations = 1;

        while (b > a) {
            if (b % 10 == 1) {
                b /= 10;
            } else if (b % 2 == 0) {
                b /= 2;
            } else {
                break;
            }

            operations++;
        }

        System.out.print(b == a ? operations : -1);
    }
}
