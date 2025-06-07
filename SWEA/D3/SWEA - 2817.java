import java.io.*;
import java.util.*;

class Solution {
    static int[] numbers;
    static int target;
    static int answer;

    /*
     * 각 숫자를 선택하는 경우와 선택하지 않는 경우를 재귀적으로 탐색한다.
     * 배열 끝에서 누적합이 K와 같은 부분수열의 개수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            numbers = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());

            answer = 0;
            search(0, 0);

            output.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void search(int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) answer++;
            return;
        }

        search(index + 1, sum);
        search(index + 1, sum + numbers[index]);
    }
}
