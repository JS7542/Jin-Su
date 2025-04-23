import java.io.*;
import java.util.*;

class Solution {
    /*
     * 기존 관문 이후 관문이 없는 연속 도시 수를 센다.
     * 거리가 제한 D에 도달하면 현재 도시에 새 관문을 설치하고 거리를 초기화한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cities = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int distance = 0;
            int installed = 0;

            for (int city = 0; city < cities; city++) {
                int gate = Integer.parseInt(st.nextToken());

                if (gate == 1) {
                    distance = 0;
                } else {
                    distance++;

                    if (distance == limit) {
                        installed++;
                        distance = 0;
                    }
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(installed).append('\n');
        }

        System.out.print(output);
    }
}
