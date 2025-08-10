import java.io.*;
import java.util.*;

class Solution {
    /*
     * 가로·세로 이동을 한 번씩 묶으면 두 좌표 차이를 각각 1씩 줄일 수 있다.
     * 남은 한 방향 거리의 홀짝에 따라 번갈아 이동하며 필요한 횟수를 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int dx = Math.abs(x1 - x2);
            int dy = Math.abs(y1 - y2);
            int common = Math.min(dx, dy);
            int difference = Math.abs(dx - dy);

            int answer = common * 2
                    + (difference % 2 == 0
                    ? difference * 2
                    : difference * 2 - 1);

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
