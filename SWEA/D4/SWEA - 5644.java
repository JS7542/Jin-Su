import java.io.*;
import java.util.*;

class Solution {
    static class Charger {
        int x;
        int y;
        int range;
        int power;

        Charger(int x, int y, int range, int power) {
            this.x = x;
            this.y = y;
            this.range = range;
            this.power = power;
        }
    }

    /*
     * 두 사용자의 이동 경로를 시간별로 진행한다.
     * 각 시간에 접속 가능한 충전기 조합을 모두 비교해 중복 사용 규칙을 반영한 최대 합을 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        int[] dx = {0, 0, 1, 0, -1};
        int[] dy = {0, -1, 0, 1, 0};

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int moves = Integer.parseInt(st.nextToken());
            int chargerCount = Integer.parseInt(st.nextToken());

            int[] pathA = new int[moves];
            int[] pathB = new int[moves];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < moves; i++) {
                pathA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < moves; i++) {
                pathB[i] = Integer.parseInt(st.nextToken());
            }

            Charger[] chargers = new Charger[chargerCount + 1];
            chargers[0] = new Charger(0, 0, -1, 0);

            for (int index = 1; index <= chargerCount; index++) {
                st = new StringTokenizer(br.readLine());

                chargers[index] = new Charger(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                );
            }

            int ax = 1;
            int ay = 1;
            int bx = 10;
            int by = 10;
            int answer = 0;

            for (int time = 0; time <= moves; time++) {
                int maximum = 0;

                for (int first = 0; first <= chargerCount; first++) {
                    if (!available(ax, ay, chargers[first])) continue;

                    for (int second = 0; second <= chargerCount; second++) {
                        if (!available(bx, by, chargers[second])) continue;

                        int value = chargers[first].power
                                + chargers[second].power;

                        if (first == second && first != 0) {
                            value = chargers[first].power;
                        }

                        maximum = Math.max(maximum, value);
                    }
                }

                answer += maximum;

                if (time < moves) {
                    ax += dx[pathA[time]];
                    ay += dy[pathA[time]];
                    bx += dx[pathB[time]];
                    by += dy[pathB[time]];
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static boolean available(int x, int y, Charger charger) {
        if (charger.range < 0) return true;

        return Math.abs(x - charger.x) + Math.abs(y - charger.y)
                <= charger.range;
    }
}
