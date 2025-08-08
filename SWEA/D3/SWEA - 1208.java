import java.io.*;
import java.util.*;

class Solution {
    /*
     * 제한 횟수만큼 최고 상자에서 하나를 빼고 최저 상자에 하나를 더한다.
     * 매 작업 후 정렬해 최댓값과 최솟값 차이를 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int dumps = Integer.parseInt(br.readLine());
            int[] boxes = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 100; i++) boxes[i] = Integer.parseInt(st.nextToken());

            for (int count = 0; count < dumps; count++) {
                Arrays.sort(boxes);
                boxes[0]++;
                boxes[99]--;
            }

            Arrays.sort(boxes);
            output.append('#').append(tc).append(' ')
                    .append(boxes[99] - boxes[0]).append('\n');
        }

        System.out.print(output);
    }
}
