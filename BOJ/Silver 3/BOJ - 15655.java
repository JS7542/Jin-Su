import java.io.*;
import java.util.*;

class Main {
    static int[] numbers;
    static int[] sequence;
    static int m;
    static StringBuilder output = new StringBuilder();

    /*
     * 입력 숫자를 정렬하고 인덱스를 증가시키며 M개 조합을 만든다.
     * 같은 숫자를 다시 사용하지 않고 선택 순서는 오름차순이다.
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

        for (int index = start; index < numbers.length; index++) {
            sequence[depth] = numbers[index];
            search(index + 1, depth + 1);
        }
    }
}
