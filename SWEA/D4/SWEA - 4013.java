import java.io.*;
import java.util.*;

class Solution {
    /*
     * 회전 대상 자석의 양옆 접점 극을 회전 전에 비교해 연쇄 회전 방향을 결정한다.
     * 각 자석의 시작 인덱스를 이동해 실제 배열 복사 없이 회전을 표현한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int commands = Integer.parseInt(br.readLine());
            int[][] magnets = new int[4][8];

            for (int magnet = 0; magnet < 4; magnet++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int index = 0; index < 8; index++) {
                    magnets[magnet][index] = Integer.parseInt(st.nextToken());
                }
            }

            int[] offset = new int[4];

            while (commands-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int target = Integer.parseInt(st.nextToken()) - 1;
                int direction = Integer.parseInt(st.nextToken());

                int[] rotate = new int[4];
                rotate[target] = direction;

                for (int magnet = target - 1; magnet >= 0; magnet--) {
                    int right = magnets[magnet][(offset[magnet] + 2) % 8];
                    int left = magnets[magnet + 1][
                            (offset[magnet + 1] + 6) % 8
                    ];

                    if (right == left) break;

                    rotate[magnet] = -rotate[magnet + 1];
                }

                for (int magnet = target + 1; magnet < 4; magnet++) {
                    int left = magnets[magnet][(offset[magnet] + 6) % 8];
                    int right = magnets[magnet - 1][
                            (offset[magnet - 1] + 2) % 8
                    ];

                    if (left == right) break;

                    rotate[magnet] = -rotate[magnet - 1];
                }

                for (int magnet = 0; magnet < 4; magnet++) {
                    offset[magnet] = (offset[magnet] - rotate[magnet] + 8) % 8;
                }
            }

            int answer = 0;

            for (int magnet = 0; magnet < 4; magnet++) {
                if (magnets[magnet][offset[magnet]] == 1) {
                    answer += 1 << magnet;
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
