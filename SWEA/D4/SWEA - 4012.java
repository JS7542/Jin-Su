import java.io.*;
import java.util.*;

class Solution {
    static int size;
    static int[][] synergy;
    static boolean[] selected;
    static int answer;

    /*
     * N개 식재료 중 절반을 첫 번째 음식 재료로 조합한다.
     * 두 음식의 모든 식재료 쌍 시너지 합을 계산해 차이의 최솟값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            size = Integer.parseInt(br.readLine());
            synergy = new int[size][size];
            selected = new boolean[size];

            for (int row = 0; row < size; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int col = 0; col < size; col++) {
                    synergy[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            answer = Integer.MAX_VALUE;
            selected[0] = true;
            choose(1, 1);

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void choose(int start, int count) {
        if (count == size / 2) {
            answer = Math.min(answer, difference());
            return;
        }

        for (int index = start; index < size; index++) {
            selected[index] = true;
            choose(index + 1, count + 1);
            selected[index] = false;
        }
    }

    static int difference() {
        int first = 0;
        int second = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int value = synergy[i][j] + synergy[j][i];

                if (selected[i] && selected[j]) first += value;
                else if (!selected[i] && !selected[j]) second += value;
            }
        }

        return Math.abs(first - second);
    }
}
