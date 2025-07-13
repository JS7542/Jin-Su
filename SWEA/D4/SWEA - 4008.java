import java.io.*;
import java.util.*;

class Solution {
    static int count;
    static int[] operators;
    static int[] numbers;
    static int minimum;
    static int maximum;

    /*
     * 남은 연산자 개수를 관리하며 숫자 순서 사이에 연산자를 배치한다.
     * 모든 연산자를 사용한 결과의 최댓값과 최솟값 차이를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            count = Integer.parseInt(br.readLine());
            operators = new int[4];
            numbers = new int[count];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int operator = 0; operator < 4; operator++) {
                operators[operator] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < count; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            minimum = Integer.MAX_VALUE;
            maximum = Integer.MIN_VALUE;

            search(1, numbers[0]);

            output.append('#').append(tc).append(' ')
                    .append(maximum - minimum).append('\n');
        }

        System.out.print(output);
    }

    static void search(int index, int value) {
        if (index == count) {
            minimum = Math.min(minimum, value);
            maximum = Math.max(maximum, value);
            return;
        }

        for (int operator = 0; operator < 4; operator++) {
            if (operators[operator] == 0) continue;

            operators[operator]--;
            int next;

            if (operator == 0) next = value + numbers[index];
            else if (operator == 1) next = value - numbers[index];
            else if (operator == 2) next = value * numbers[index];
            else next = value / numbers[index];

            search(index + 1, next);
            operators[operator]++;
        }
    }
}
