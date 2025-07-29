import java.io.*;
import java.util.*;

class Solution {
    /*
     * 숫자를 스택에 차례대로 넣는다.
     * 현재 숫자가 스택 마지막 숫자와 같으면 제거하고 다르면 추가한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            String password = st.nextToken();
            StringBuilder stack = new StringBuilder();

            for (int i = 0; i < length; i++) {
                char digit = password.charAt(i);
                int size = stack.length();

                if (size > 0 && stack.charAt(size - 1) == digit) {
                    stack.deleteCharAt(size - 1);
                } else {
                    stack.append(digit);
                }
            }

            output.append('#').append(tc).append(' ').append(stack).append('\n');
        }

        System.out.print(output);
    }
}
