import java.io.*;
import java.util.*;

class Main {
    /*
     * 예상 등수를 오름차순으로 정렬한다.
     * 실제 등수 1부터 N까지 대응시켜 차이의 절댓값 합을 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] expected = new int[n];

        for (int i = 0; i < n; i++) {
            expected[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expected);

        long answer = 0;

        for (int i = 0; i < n; i++) {
            answer += Math.abs((long) expected[i] - (i + 1));
        }

        System.out.print(answer);
    }
}
