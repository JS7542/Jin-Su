import java.io.*;
import java.util.*;

class Main {
    /*
     * 회전 대상 톱니의 좌우 접점 극을 회전 전에 비교해 연쇄 회전 방향을 결정한다.
     * 각 톱니 문자열의 시작 인덱스를 이동해 실제 배열 이동 없이 회전을 표현한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] gears = new char[4][];

        for (int gear = 0; gear < 4; gear++) gears[gear] = br.readLine().toCharArray();

        int[] offset = new int[4];
        int operations = Integer.parseInt(br.readLine());

        while (operations-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            int[] rotate = new int[4];
            rotate[target] = direction;

            for (int gear = target - 1; gear >= 0; gear--) {
                char rightPole = gears[gear][(offset[gear] + 2) % 8];
                char leftPole = gears[gear + 1][(offset[gear + 1] + 6) % 8];

                if (rightPole == leftPole) break;

                rotate[gear] = -rotate[gear + 1];
            }

            for (int gear = target + 1; gear < 4; gear++) {
                char leftPole = gears[gear][(offset[gear] + 6) % 8];
                char rightPole = gears[gear - 1][(offset[gear - 1] + 2) % 8];

                if (leftPole == rightPole) break;

                rotate[gear] = -rotate[gear - 1];
            }

            for (int gear = 0; gear < 4; gear++) {
                offset[gear] = (offset[gear] - rotate[gear] + 8) % 8;
            }
        }

        int score = 0;

        for (int gear = 0; gear < 4; gear++) {
            if (gears[gear][offset[gear]] == '1') score += 1 << gear;
        }

        System.out.print(score);
    }
}
