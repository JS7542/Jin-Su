import java.io.*;
import java.util.*;

class Solution {
    /*
     * 실제 운동 시간이 최소 권장 시간보다 작으면 부족한 시간을 출력한다.
     * 권장 범위 안이면 0, 최대 권장 시간을 넘으면 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int minimum = Integer.parseInt(st.nextToken());
            int maximum = Integer.parseInt(st.nextToken());
            int exercise = Integer.parseInt(st.nextToken());

            int answer;

            if (exercise < minimum) answer = minimum - exercise;
            else if (exercise > maximum) answer = -1;
            else answer = 0;

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
