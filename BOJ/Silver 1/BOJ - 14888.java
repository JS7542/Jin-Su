import java.io.*;
import java.util.*;

class Main {
    static int[] numbers;
    static int[] operators = new int[4];
    static int maximum = Integer.MIN_VALUE;
    static int minimum = Integer.MAX_VALUE;

    /*
     * 남은 연산자 중 하나를 선택해 왼쪽부터 계산하는 모든 경우를 탐색한다.
     * 모든 숫자를 사용하면 최댓값과 최솟값을 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) operators[i] = Integer.parseInt(st.nextToken());

        search(1, numbers[0]);

        System.out.println(maximum);
        System.out.print(minimum);
    }

    static void search(int index, int value) {
        if (index == numbers.length) {
            maximum = Math.max(maximum, value);
            minimum = Math.min(minimum, value);
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
