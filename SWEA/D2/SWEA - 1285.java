import java.io.*;
import java.util.*;

class Solution {
    /*
     * 각 돌의 위치 절댓값을 계산한다.
     * 원점과의 최소 거리와 그 최소 거리를 가진 돌의 개수를 함께 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int stones = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int minimum = Integer.MAX_VALUE;
            int count = 0;

            for (int i = 0; i < stones; i++) {
                int distance = Math.abs(Integer.parseInt(st.nextToken()));

                if (distance < minimum) {
                    minimum = distance;
                    count = 1;
                } else if (distance == minimum) {
                    count++;
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(minimum).append(' ').append(count).append('\n');
        }

        System.out.print(output);
    }
}
