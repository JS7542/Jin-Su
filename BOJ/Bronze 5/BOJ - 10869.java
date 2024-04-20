import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 정수에 대해 덧셈, 뺄셈, 곱셈, 몫, 나머지를 차례로 계산한다.
     * 각 연산 결과를 한 줄씩 StringBuilder에 저장해 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(a + b).append('\n');
        sb.append(a - b).append('\n');
        sb.append(a * b).append('\n');
        sb.append(a / b).append('\n');
        sb.append(a % b);
        System.out.print(sb);
    }
}
