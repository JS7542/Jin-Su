import java.io.*;
import java.util.*;

class Main {
    static int size;
    static int[][] synergy;
    static boolean[] startTeam;
    static int answer = Integer.MAX_VALUE;

    /*
     * N명 중 절반을 스타트 팀으로 고르는 조합을 만든다.
     * 두 팀의 모든 쌍 능력치 합을 계산해 차이의 최솟값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        synergy = new int[size][size];
        startTeam = new boolean[size];

        for (int row = 0; row < size; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int col = 0; col < size; col++) {
                synergy[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        startTeam[0] = true;
        choose(1, 1);

        System.out.print(answer);
    }

    static void choose(int start, int count) {
        if (count == size / 2) {
            answer = Math.min(answer, difference());
            return;
        }

        for (int player = start; player < size; player++) {
            startTeam[player] = true;
            choose(player + 1, count + 1);
            startTeam[player] = false;
        }
    }

    static int difference() {
        int startScore = 0;
        int linkScore = 0;

        for (int first = 0; first < size; first++) {
            for (int second = first + 1; second < size; second++) {
                int value = synergy[first][second] + synergy[second][first];

                if (startTeam[first] && startTeam[second]) startScore += value;
                else if (!startTeam[first] && !startTeam[second]) linkScore += value;
            }
        }

        return Math.abs(startScore - linkScore);
    }
}
