import java.io.*;
import java.util.*;

class Solution {
    static String[] values;
    static int[] left;
    static int[] right;

    /*
     * 각 노드에 숫자 또는 연산자와 자식 번호를 저장한다.
     * 리프는 숫자를 반환하고 연산자 노드는 두 자식의 결과를 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            values = new String[n + 1];
            left = new int[n + 1];
            right = new int[n + 1];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                values[node] = st.nextToken();

                if (st.hasMoreTokens()) {
                    left[node] = Integer.parseInt(st.nextToken());
                    right[node] = Integer.parseInt(st.nextToken());
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(evaluate(1)).append('\n');
        }

        System.out.print(output);
    }

    static int evaluate(int node) {
        if (left[node] == 0) return Integer.parseInt(values[node]);

        int first = evaluate(left[node]);
        int second = evaluate(right[node]);

        return switch (values[node]) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            default -> first / second;
        };
    }
}
