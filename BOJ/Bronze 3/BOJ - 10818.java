import java.io.*;
import java.util.*;

class Main {
    /*
     * 수열을 한 번 순회하며 현재 최솟값과 최댓값을 갱신한다.
     * 모든 값을 확인한 뒤 두 값을 공백으로 구분해 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        System.out.print(min + " " + max);
    }
}
