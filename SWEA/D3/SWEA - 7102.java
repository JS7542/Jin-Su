import java.io.*;
import java.util.*;

class Solution {
    /*
     * 두 카드에서 나올 수 있는 모든 합의 등장 횟수를 센다.
     * 최대 등장 횟수를 구한 뒤 그 횟수와 같은 합을 오름차순으로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            int[] frequency = new int[first + second + 1];
            int maximum = 0;

            for (int a = 1; a <= first; a++) {
                for (int b = 1; b <= second; b++) {
                    maximum = Math.max(maximum, ++frequency[a + b]);
                }
            }

            output.append('#').append(tc).append(' ');

            for (int sum = 2; sum < frequency.length; sum++) {
                if (frequency[sum] == maximum) output.append(sum).append(' ');
            }

            output.append('\n');
        }

        System.out.print(output);
    }
}
