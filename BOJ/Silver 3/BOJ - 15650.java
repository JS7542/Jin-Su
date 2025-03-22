import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[] sequence;
    static StringBuilder output = new StringBuilder();

    /*
     * 다음 수를 직전 수보다 크게 선택해 오름차순 조합만 만든다.
     * 길이 M이 되면 중복 없는 조합을 출력한다.
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
            search(value + 1, depth + 1);
        }
    }
}
