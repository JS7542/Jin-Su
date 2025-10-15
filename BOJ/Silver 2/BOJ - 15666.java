import java.io.*;
import java.util.*;

class Main {
    static int[] unique;
    static int[] sequence;
    static int m;
    static StringBuilder output = new StringBuilder();

    /*
     * 입력의 고유 숫자를 오름차순 배열로 만든다.
     * 현재 인덱스 이후 숫자를 반복 선택해 중복 없는 비내림차순 수열을 출력한다.
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
        search(0, 0);

        System.out.print(output);
    }

    static void search(int start, int depth) {
        if (depth == m) {
            for (int value : sequence) output.append(value).append(' ');
            output.append('\n');
            return;
        }

        for (int index = start; index < unique.length; index++) {
            sequence[depth] = unique[index];
            search(index, depth + 1);
        }
    }
}
