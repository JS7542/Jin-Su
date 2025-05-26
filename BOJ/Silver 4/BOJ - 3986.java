import java.io.*;
import java.util.*;

class Main {
    /*
     * 같은 문자가 짝을 이뤄 제거되는 과정을 스택으로 시뮬레이션한다.
     * 모든 문자를 처리한 뒤 스택이 비어 있으면 좋은 단어다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        while (n-- > 0) {
            String word = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();

            for (char ch : word.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == ch) stack.pop();
                else stack.push(ch);
            }

            if (stack.isEmpty()) answer++;
        }

        System.out.print(answer);
    }
}
