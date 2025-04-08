import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[] sequence;
    static StringBuilder output = new StringBuilder();

    /*
     * 각 위치에 1부터 N까지 모든 수를 독립적으로 선택한다.
     * 중복 선택을 허용하며 길이 M의 모든 수열을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sequence = new int[m];

        search(0);
        System.out.print(output);
    }

    static void search(int depth) {
        if (depth == m) {
            for (int value : sequence) output.append(value).append(' ');
            output.append('\n');
            return;
        }

        for (int value = 1; value <= n; value++) {
            sequence[depth] = value;
            search(depth + 1);
        }
    }
}
