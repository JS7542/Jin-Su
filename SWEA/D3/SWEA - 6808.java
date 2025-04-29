import java.io.*;
import java.util.*;

class Solution {
    static int[] gyu = new int[9];
    static int[] in = new int[9];
    static boolean[] used = new boolean[9];
    static int wins;
    static int losses;

    /*
     * 인영이 카드의 모든 순열을 백트래킹으로 만든다.
     * 각 라운드에서 더 큰 카드를 낸 사람이 두 카드 합을 얻고 최종 점수를 비교한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            boolean[] owned = new boolean[19];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 9; i++) {
                gyu[i] = Integer.parseInt(st.nextToken());
                owned[gyu[i]] = true;
            }

            int index = 0;

            for (int card = 1; card <= 18; card++) {
                if (!owned[card]) in[index++] = card;
            }

            wins = 0;
            losses = 0;
            Arrays.fill(used, false);

            play(0, 0, 0);

            output.append('#').append(tc).append(' ')
                    .append(wins).append(' ').append(losses).append('\n');
        }

        System.out.print(output);
    }

    static void play(int round, int gyuScore, int inScore) {
        if (round == 9) {
            if (gyuScore > inScore) wins++;
            else if (gyuScore < inScore) losses++;
            return;
        }

        for (int index = 0; index < 9; index++) {
            if (used[index]) continue;

            used[index] = true;
            int sum = gyu[round] + in[index];

            if (gyu[round] > in[index]) {
                play(round + 1, gyuScore + sum, inScore);
            } else {
                play(round + 1, gyuScore, inScore + sum);
            }

            used[index] = false;
        }
    }
}
