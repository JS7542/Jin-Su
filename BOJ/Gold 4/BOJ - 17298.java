import java.io.*;
import java.util.*;

class Main {
    /*
     * 아직 오큰수를 찾지 못한 인덱스를 단조 감소 스택에 저장한다.
     * 현재 값이 스택 인덱스의 값보다 크면 현재 값이 해당 위치의 오큰수다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        StringBuilder output = new StringBuilder();
        for (int value : answer) output.append(value).append(' ');

        System.out.print(output);
    }
}
