import java.io.*;
import java.util.*;

class Solution {
    static int count;
    static long[] x;
    static long[] y;
    static long totalX;
    static long totalY;
    static long answer;

    /*
     * N개 지렁이 중 절반을 벡터의 양의 방향으로 선택한다.
     * 선택한 좌표 합의 두 배에서 전체 좌표 합을 뺀 벡터 크기 제곱의 최솟값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            count = Integer.parseInt(br.readLine());
            x = new long[count];
            y = new long[count];
            totalX = 0;
            totalY = 0;

            for (int index = 0; index < count; index++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x[index] = Long.parseLong(st.nextToken());
                y[index] = Long.parseLong(st.nextToken());
                totalX += x[index];
                totalY += y[index];
            }

            answer = Long.MAX_VALUE;
            choose(0, 0, 0, 0);

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void choose(int start, int selected, long selectedX, long selectedY) {
        if (selected == count / 2) {
            long vectorX = selectedX * 2 - totalX;
            long vectorY = selectedY * 2 - totalY;
            answer = Math.min(answer, vectorX * vectorX + vectorY * vectorY);
            return;
        }

        if (count - start < count / 2 - selected) return;

        for (int index = start; index < count; index++) {
            choose(
                    index + 1,
                    selected + 1,
                    selectedX + x[index],
                    selectedY + y[index]
            );
        }
    }
}
