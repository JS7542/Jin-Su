import java.io.*;
import java.util.*;

class Main {
    /*
     * 길이 1과 길이 2 구간을 초기화한 뒤 구간 길이를 늘리며 팰린드롬 여부를 계산한다.
     * 양 끝 값이 같고 내부 구간이 팰린드롬이면 현재 구간도 팰린드롬이다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        boolean[][] palindrome = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) palindrome[i][i] = true;

        for (int i = 1; i < n; i++) {
            palindrome[i][i + 1] = numbers[i] == numbers[i + 1];
        }

        for (int length = 3; length <= n; length++) {
            for (int start = 1; start + length - 1 <= n; start++) {
                int end = start + length - 1;

                palindrome[start][end] = numbers[start] == numbers[end]
                        && palindrome[start + 1][end - 1];
            }
        }

        int queries = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (queries-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            output.append(palindrome[start][end] ? 1 : 0).append('\n');
        }

        System.out.print(output);
    }
}
