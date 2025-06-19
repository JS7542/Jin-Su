import java.io.*;
import java.util.*;

class Solution {
    static int count;
    static int[] weights;
    static boolean[] used;
    static long answer;

    /*
     * 추의 순서와 왼쪽·오른쪽 배치를 동시에 백트래킹한다.
     * 오른쪽 무게가 왼쪽을 넘지 않는 경우만 탐색해 가능한 배치 수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            count = Integer.parseInt(br.readLine());
            weights = new int[count];
            used = new boolean[count];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < count; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }

            answer = 0;
            search(0, 0, 0);

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void search(int placed, int leftWeight, int rightWeight) {
        if (placed == count) {
            answer++;
            return;
        }

        for (int index = 0; index < count; index++) {
            if (used[index]) continue;

            used[index] = true;
            search(placed + 1, leftWeight + weights[index], rightWeight);

            if (rightWeight + weights[index] <= leftWeight) {
                search(placed + 1, leftWeight, rightWeight + weights[index]);
            }

            used[index] = false;
        }
    }
}
