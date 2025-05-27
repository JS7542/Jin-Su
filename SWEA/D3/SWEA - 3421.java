import java.io.*;
import java.util.*;

class Solution {
    static int ingredients;
    static boolean[][] incompatible;
    static int answer;

    /*
     * 각 재료를 선택하거나 선택하지 않는 부분집합을 백트래킹한다.
     * 새 재료가 이미 선택한 재료와 궁합이 나쁜 경우 해당 선택 분기를 건너뛴다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredients = Integer.parseInt(st.nextToken());
            int pairs = Integer.parseInt(st.nextToken());

            incompatible = new boolean[ingredients][ingredients];

            for (int i = 0; i < pairs; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken()) - 1;
                int second = Integer.parseInt(st.nextToken()) - 1;

                incompatible[first][second] = true;
                incompatible[second][first] = true;
            }

            answer = 0;
            search(0, 0);

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void search(int index, int selectedMask) {
        if (index == ingredients) {
            answer++;
            return;
        }

        search(index + 1, selectedMask);

        boolean possible = true;

        for (int selected = 0; selected < ingredients; selected++) {
            if ((selectedMask & (1 << selected)) != 0
                    && incompatible[index][selected]) {
                possible = false;
                break;
            }
        }

        if (possible) search(index + 1, selectedMask | (1 << index));
    }
}
