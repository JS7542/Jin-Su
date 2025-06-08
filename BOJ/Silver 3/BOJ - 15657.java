import java.io.*;
import java.util.*;

class Main {
    static int[] numbers;
    static int[] sequence;
    static int m;
    static StringBuilder output = new StringBuilder();

    /*
     * 정렬된 입력 배열에서 현재 인덱스 이후 숫자만 다음 위치에 선택한다.
     * 같은 숫자 재사용을 허용해 비내림차순 수열을 만든다.
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
            search(index, depth + 1);
        }
    }
}
