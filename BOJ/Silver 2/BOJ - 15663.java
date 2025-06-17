import java.io.*;
import java.util.*;

class Main {
    static int[] numbers;
    static int[] sequence;
    static boolean[] used;
    static int m;
    static StringBuilder output = new StringBuilder();

    /*
     * 정렬된 입력에서 같은 깊이에 같은 값을 한 번만 선택한다.
     * 인덱스 사용 여부를 관리해 중복 없는 순열만 출력한다.
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

        int previous = Integer.MIN_VALUE;

        for (int index = 0; index < numbers.length; index++) {
            if (used[index] || numbers[index] == previous) continue;

            previous = numbers[index];
            used[index] = true;
            sequence[depth] = numbers[index];
            search(depth + 1);
            used[index] = false;
        }
    }
}
