import java.io.*;
import java.util.*;

class Solution {
    /*
     * 손님 도착 시간을 오름차순으로 정렬한다.
     * 각 손님 도착 시각까지 만든 붕어빵 수가 지금까지 온 손님 수 이상인지 확인한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int customers = Integer.parseInt(st.nextToken());
            int seconds = Integer.parseInt(st.nextToken());
            int breads = Integer.parseInt(st.nextToken());

            int[] arrivals = new int[customers];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < customers; i++) {
                arrivals[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrivals);
            boolean possible = true;

            for (int i = 0; i < customers; i++) {
                int produced = arrivals[i] / seconds * breads;

                if (produced < i + 1) {
                    possible = false;
                    break;
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(possible ? "Possible" : "Impossible")
                    .append('\n');
        }

        System.out.print(output);
    }
}
