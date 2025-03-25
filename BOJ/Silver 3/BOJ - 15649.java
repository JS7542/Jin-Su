import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static boolean[] used;
    static int[] sequence;
    static StringBuilder output = new StringBuilder();

    /*
     * 1부터 N까지 중복 없이 M개를 선택하는 모든 순열을 백트래킹한다.
     * 사용한 수를 표시하고 길이 M이 되면 현재 순서를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        used = new boolean[n + 1];
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
            if (used[value]) continue;

            used[value] = true;
            sequence[depth] = value;
            search(depth + 1);
            used[value] = false;
        }
    }
}
