import java.io.*;

class Solution {
    /*
     * 곱셈을 먼저 계산하기 위해 현재 곱셈 항을 따로 누적한다.
     * 덧셈을 만나면 완성된 항을 전체 합에 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            String expression = br.readLine();

            int sum = 0;
            int product = expression.charAt(0) - '0';

            for (int index = 1; index < expression.length(); index += 2) {
                char operator = expression.charAt(index);
                int number = expression.charAt(index + 1) - '0';

                if (operator == '*') {
                    product *= number;
                } else {
                    sum += product;
                    product = number;
                }
            }

            int answer = sum + product;

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
