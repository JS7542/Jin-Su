import java.io.*;
import java.util.*;

class Main {
    /*
     * 다섯 참가자의 네 평가 점수를 각각 합산한다.
     * 가장 높은 총점을 가진 참가자 번호와 점수를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int winner = 0;
        int bestScore = -1;

        for (int person = 1; person <= 5; person++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int score = 0;

            while (st.hasMoreTokens()) score += Integer.parseInt(st.nextToken());

            if (score > bestScore) {
                bestScore = score;
                winner = person;
            }
        }

        System.out.print(winner + " " + bestScore);
    }
}
