import java.io.*;
import java.util.*;

class Solution {
    /*
     * 카드 종류와 번호를 이차원 방문 배열에 표시한다.
     * 중복 카드가 나오면 ERROR, 아니면 종류별 부족한 카드 수를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        String suits = "SDHC";

        for (int tc = 1; tc <= tests; tc++) {
            String text = br.readLine();
            boolean[][] owned = new boolean[4][14];
            boolean error = false;

            for (int index = 0; index < text.length(); index += 3) {
                int suit = suits.indexOf(text.charAt(index));
                int number = Integer.parseInt(text.substring(index + 1, index + 3));

                if (owned[suit][number]) {
                    error = true;
                    break;
                }

                owned[suit][number] = true;
            }

            output.append('#').append(tc).append(' ');

            if (error) {
                output.append("ERROR\n");
                continue;
            }

            for (int suit = 0; suit < 4; suit++) {
                int count = 0;

                for (int number = 1; number <= 13; number++) {
                    if (owned[suit][number]) count++;
                }

                output.append(13 - count).append(' ');
            }

            output.append('\n');
        }

        System.out.print(output);
    }
}
