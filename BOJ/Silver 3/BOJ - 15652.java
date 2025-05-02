import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[] sequence;
    static StringBuilder output = new StringBuilder();

    /*
     * 현재 위치의 수 이상만 다음 위치에서 선택해 비내림차순 수열을 만든다.
     * 중복 선택을 허용하며 길이 M이 되면 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sequence = new int[m];

        search(1, 0);
        System.out.print(output);
    }

    static void search(int start, int depth) {
        if (depth == m) {
            for (int value : sequence) output.append(value).append(' ');
            output.append('\n');
            return;
        }

        for (int value = start; value <= n; value++) {
            sequence[depth] = value;
            search(value, depth + 1);
        }
    }
}
