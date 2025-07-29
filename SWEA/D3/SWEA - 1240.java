import java.io.*;
import java.util.*;

class Solution {
    private static final String[] CODES = {
        "0001101", "0011001", "0010011", "0111101", "0100011",
        "0110001", "0101111", "0111011", "0110111", "0001011"
    };

    /*
     * 암호코드의 마지막 1을 찾아 그 위치에서 끝나는 56비트를 추출한다.
     * 7비트씩 숫자로 변환하고 검증식이 맞으면 숫자 합을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rows = Integer.parseInt(st.nextToken());
            int cols = Integer.parseInt(st.nextToken());

            String codeRow = null;
            int end = -1;

            for (int row = 0; row < rows; row++) {
                String line = br.readLine();

                if (end == -1) {
                    int candidate = line.lastIndexOf('1');

                    if (candidate >= 0) {
                        codeRow = line;
                        end = candidate;
                    }
                }
            }

            int[] digits = new int[8];
            int start = end - 55;

            for (int index = 0; index < 8; index++) {
                String code = codeRow.substring(
                        start + index * 7,
                        start + (index + 1) * 7
                );

                for (int digit = 0; digit < 10; digit++) {
                    if (CODES[digit].equals(code)) {
                        digits[index] = digit;
                        break;
                    }
                }
            }

            int odd = digits[0] + digits[2] + digits[4] + digits[6];
            int even = digits[1] + digits[3] + digits[5];
            int checksum = odd * 3 + even + digits[7];

            int answer = 0;

            if (checksum % 10 == 0) {
                for (int digit : digits) answer += digit;
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
