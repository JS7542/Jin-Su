import java.io.*;
import java.util.*;

class Main {
    static int[] numbers;
    static int[] sequence;
    static boolean[] used;
    static int m;
    static StringBuilder output = new StringBuilder();

    /*
     * 입력 숫자를 정렬한 뒤 중복 없이 M개를 고르는 모든 순열을 만든다.
     * 정렬된 순서대로 탐색하므로 출력도 사전순이 된다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        sequence = new int[m];
        used = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);
        search(0);

        System.out.print(output);
    }

    static void search(int depth) {
        if (depth == m) {
            for (int value : sequence) output.append(value).append(' ');
            output.append('\n');
            return;
        }

        for (int index = 0; index < numbers.length; index++) {
            if (used[index]) continue;

            used[index] = true;
            sequence[depth] = numbers[index];
            search(depth + 1);
            used[index] = false;
        }
    }
}
