import java.io.*;
import java.util.*;

class Solution {
    static int depth;
    static int width;
    static int required;
    static int[][] film;
    static int answer;

    /*
     * 각 행을 그대로 두거나 A·B 약품으로 바꾸는 경우를 백트래킹한다.
     * 모든 열이 같은 특성 K개 이상 연속 조건을 만족하는 최소 약품 투입 수를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            depth = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            required = Integer.parseInt(st.nextToken());

            film = new int[depth][width];

            for (int row = 0; row < depth; row++) {
                st = new StringTokenizer(br.readLine());

                for (int col = 0; col < width; col++) {
                    film[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            answer = required;

            if (required == 1 || passes()) {
                answer = 0;
            } else {
                search(0, 0);
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void search(int row, int injected) {
        if (injected >= answer) return;

        if (row == depth) {
            if (passes()) answer = injected;
            return;
        }

        int[] original = film[row].clone();

        search(row + 1, injected);

        Arrays.fill(film[row], 0);
        search(row + 1, injected + 1);

        Arrays.fill(film[row], 1);
        search(row + 1, injected + 1);

        film[row] = original;
    }

    static boolean passes() {
        for (int col = 0; col < width; col++) {
            int consecutive = 1;
            boolean valid = required == 1;

            for (int row = 1; row < depth; row++) {
                if (film[row][col] == film[row - 1][col]) consecutive++;
                else consecutive = 1;

                if (consecutive >= required) {
                    valid = true;
                    break;
                }
            }

            if (!valid) return false;
        }

        return true;
    }
}
