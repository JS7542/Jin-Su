import java.io.*;
import java.util.*;

class Solution {
    /*
     * N개의 정수를 배열에 저장한 뒤 오름차순으로 정렬한다.
     * 정렬된 값을 테스트 케이스 형식에 맞춰 한 줄로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] numbers = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(numbers);

            sb.append('#').append(tc);
            for (int number : numbers) sb.append(' ').append(number);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
