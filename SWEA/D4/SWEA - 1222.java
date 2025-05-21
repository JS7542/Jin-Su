import java.io.*;

class Solution {
    /*
     * 식은 한 자리 숫자와 덧셈 연산자로만 구성된다.
     * 숫자 문자를 정수로 변환해 모두 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            String expression = br.readLine();
            int answer = 0;

            for (char ch : expression.toCharArray()) {
                if (Character.isDigit(ch)) answer += ch - '0';
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
