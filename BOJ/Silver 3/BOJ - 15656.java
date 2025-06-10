import java.io.*;
import java.util.*;

class Main {
    static int[] numbers;
    static int[] sequence;
    static int m;
    static StringBuilder output = new StringBuilder();

    /*
     * 입력 숫자를 정렬하고 각 위치에서 모든 숫자를 선택한다.
     * 숫자 재사용을 허용해 길이 M의 모든 수열을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        sequence = new int[m];

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

        for (int value : numbers) {
            sequence[depth] = value;
            search(depth + 1);
        }
    }
}
