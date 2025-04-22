import java.io.*;
import java.util.*;

class Main {
    static int[] numbers;
    static int[] sequence;
    static int m;
    static StringBuilder output = new StringBuilder();

    /*
     * 정렬된 배열에서 인덱스를 증가시키며 조합을 만든다.
     * 같은 깊이에서 같은 값은 한 번만 선택해 중복 조합을 제거한다.
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
        search(0, 0);

        System.out.print(output);
    }

    static void search(int start, int depth) {
        if (depth == m) {
            for (int value : sequence) output.append(value).append(' ');
            output.append('\n');
            return;
        }

        int previous = Integer.MIN_VALUE;

        for (int index = start; index < numbers.length; index++) {
            if (numbers[index] == previous) continue;

            previous = numbers[index];
            sequence[depth] = numbers[index];
            search(index + 1, depth + 1);
        }
    }
}
