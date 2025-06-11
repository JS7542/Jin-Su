import java.io.*;
import java.util.*;

class Solution {
    /*
     * 각 버스 노선의 시작 정류장부터 끝 정류장까지 운행 횟수를 증가시킨다.
     * 질의로 주어진 정류장별 운행 버스 수를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int routes = Integer.parseInt(br.readLine());
            int[] count = new int[5001];

            for (int i = 0; i < routes; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                for (int stop = start; stop <= end; stop++) count[stop]++;
            }

            int queries = Integer.parseInt(br.readLine());
            output.append('#').append(tc).append(' ');

            for (int i = 0; i < queries; i++) {
                int stop = Integer.parseInt(br.readLine());
                output.append(count[stop]).append(' ');
            }

            output.append('\n');
        }

        System.out.print(output);
    }
}
