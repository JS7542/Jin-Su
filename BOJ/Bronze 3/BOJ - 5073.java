import java.io.*;
import java.util.*;

class Main {
    /*
     * 가장 긴 변이 나머지 두 변의 합보다 작은지 확인해 삼각형 성립 여부를 판단한다.
     * 성립한다면 세 변의 동일 여부에 따라 종류를 구분한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;

            int max = Math.max(a, Math.max(b, c));
            if (a + b + c - max <= max) sb.append("Invalid");
            else if (a == b && b == c) sb.append("Equilateral");
            else if (a == b || b == c || a == c) sb.append("Isosceles");
            else sb.append("Scalene");
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
