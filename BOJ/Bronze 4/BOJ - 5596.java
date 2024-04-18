import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 참가자의 네 과목 점수를 각각 합산한다.
     * 두 총점 중 더 큰 값을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = sum(br.readLine());
        int second = sum(br.readLine());
        System.out.print(Math.max(first, second));
    }

    private static int sum(String line) {
        StringTokenizer st = new StringTokenizer(line);
        int result = 0;

        while (st.hasMoreTokens()) result += Integer.parseInt(st.nextToken());
        return result;
    }
}
