import java.io.*;
import java.util.*;

class Solution {
    /*
     * 각 건물의 양쪽 두 칸에서 가장 높은 건물을 찾는다.
     * 현재 높이가 주변 최댓값보다 높다면 그 차이를 조망권 수에 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] heights = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) heights[i] = Integer.parseInt(st.nextToken());

            int answer = 0;

            for (int i = 2; i < n - 2; i++) {
                int around = Math.max(
                        Math.max(heights[i - 2], heights[i - 1]),
                        Math.max(heights[i + 1], heights[i + 2])
                );

                if (heights[i] > around) answer += heights[i] - around;
            }

            output.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.print(output);
    }
}
