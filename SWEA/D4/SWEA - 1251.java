import java.io.*;
import java.util.*;

class Solution {
    /*
     * 섬을 정점, 거리 제곱을 간선 비용으로 보고 프림 MST를 구성한다.
     * 선택된 최소 거리 합에 환경 부담 세율을 곱해 반올림한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            long[] x = new long[n];
            long[] y = new long[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) x[i] = Long.parseLong(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) y[i] = Long.parseLong(st.nextToken());

            double rate = Double.parseDouble(br.readLine());

            boolean[] selected = new boolean[n];
            long[] minimum = new long[n];
            Arrays.fill(minimum, Long.MAX_VALUE);
            minimum[0] = 0;

            long total = 0;

            for (int count = 0; count < n; count++) {
                int current = -1;

                for (int island = 0; island < n; island++) {
                    if (!selected[island]
                            && (current == -1 || minimum[island] < minimum[current])) {
                        current = island;
                    }
                }

                selected[current] = true;
                total += minimum[current];

                for (int next = 0; next < n; next++) {
                    if (selected[next]) continue;

                    long dx = x[current] - x[next];
                    long dy = y[current] - y[next];
                    long distance = dx * dx + dy * dy;
                    minimum[next] = Math.min(minimum[next], distance);
                }
            }

            output.append('#').append(tc).append(' ')
                    .append(Math.round(total * rate)).append('\n');
        }

        System.out.print(output);
    }
}
