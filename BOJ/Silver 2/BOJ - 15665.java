import java.io.*;
import java.util.*;

class Main {
    static int[] unique;
    static int[] sequence;
    static int m;
    static StringBuilder output = new StringBuilder();

    /*
     * 입력 숫자를 정렬하고 중복 값을 제거한 고유 숫자 배열을 만든다.
     * 각 위치에서 모든 고유 숫자를 선택해 중복 없는 반복 수열을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);

        int count = 0;

        for (int index = 0; index < n; index++) {
            if (index == 0 || numbers[index] != numbers[index - 1]) count++;
        }

        unique = new int[count];
        int position = 0;

        for (int index = 0; index < n; index++) {
            if (index == 0 || numbers[index] != numbers[index - 1]) {
                unique[position++] = numbers[index];
            }
        }

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

        for (int value : unique) {
            sequence[depth] = value;
            search(depth + 1);
        }
    }
}
