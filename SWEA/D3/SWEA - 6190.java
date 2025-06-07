import java.io.*;
import java.util.*;

class Solution {
    /*
     * 서로 다른 두 수의 모든 곱을 계산한다.
     * 각 곱의 자릿수가 왼쪽부터 감소하지 않는지 확인해 최댓값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int count = Integer.parseInt(br.readLine());
            int[] numbers = new int[count];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < count; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            int answer = -1;

            for (int first = 0; first < count; first++) {
                for (int second = first + 1; second < count; second++) {
                    int product = numbers[first] * numbers[second];

                    if (increasing(product)) answer = Math.max(answer, product);
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static boolean increasing(int value) {
        String text = String.valueOf(value);

        for (int index = 1; index < text.length(); index++) {
            if (text.charAt(index - 1) > text.charAt(index)) return false;
        }

        return true;
    }
}
