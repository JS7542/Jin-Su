import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 정수를 각각 뒤집어 더한다.
     * 합을 다시 뒤집고 정수로 변환해 앞쪽 0을 제거한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = reverse(Integer.parseInt(st.nextToken()));
        int second = reverse(Integer.parseInt(st.nextToken()));

        System.out.print(reverse(first + second));
    }

    private static int reverse(int value) {
        int reversed = 0;

        while (value > 0) {
            reversed = reversed * 10 + value % 10;
            value /= 10;
        }

        return reversed;
    }
}
