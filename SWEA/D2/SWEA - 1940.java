import java.io.*;
import java.util.*;

class Solution {
    /*
     * 명령에 따라 속도를 증가하거나 감소시킨다.
     * 매초 현재 속도만큼 이동하므로 속도를 거리 합에 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int commands = Integer.parseInt(br.readLine());
            int speed = 0;
            int distance = 0;

            for (int i = 0; i < commands; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());

                if (command == 1) speed += Integer.parseInt(st.nextToken());
                else if (command == 2) speed = Math.max(0, speed - Integer.parseInt(st.nextToken()));

                distance += speed;
            }

            output.append('#').append(tc).append(' ')
                    .append(distance).append('\n');
        }

        System.out.print(output);
    }
}
