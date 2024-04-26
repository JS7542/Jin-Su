import java.io.*;
import java.util.*;

class Main {
    /*
     * 세 정수에 대한 네 가지 나머지 연산 결과를 계산한다.
     * 괄호 위치에 따른 연산 결과를 문제에서 요구한 순서대로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append((a + b) % c).append('\n');
        sb.append(((a % c) + (b % c)) % c).append('\n');
        sb.append((a * b) % c).append('\n');
        sb.append(((a % c) * (b % c)) % c);
        System.out.print(sb);
    }
}
