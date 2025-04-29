import java.io.*;
import java.util.*;

class Solution {
    /*
     * 일반 숫자는 스택에 저장하고 0이 나오면 가장 최근 숫자를 제거한다.
     * 모든 입력 처리 후 스택에 남은 숫자의 합을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int commands = Integer.parseInt(br.readLine());
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < commands; i++) {
                int value = Integer.parseInt(br.readLine());

                if (value == 0) stack.pop();
                else stack.push(value);
            }

            int sum = 0;

            for (int value : stack) sum += value;

            output.append('#').append(tc).append(' ')
                    .append(sum).append('\n');
        }

        System.out.print(output);
    }
}
