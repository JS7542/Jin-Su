import java.io.*;
import java.util.*;

class Solution {
    /*
     * 방 번호를 같은 복도 구간 번호인 (room+1)/2로 변환한다.
     * 각 학생 이동 구간의 복도 사용 횟수를 누적하고 최대 겹침 수를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int students = Integer.parseInt(br.readLine());
            int[] corridor = new int[201];

            for (int i = 0; i < students; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = (Integer.parseInt(st.nextToken()) + 1) / 2;
                int end = (Integer.parseInt(st.nextToken()) + 1) / 2;

                if (start > end) {
                    int temp = start;
                    start = end;
                    end = temp;
                }

                for (int section = start; section <= end; section++) {
                    corridor[section]++;
                }
            }

            int answer = 0;

            for (int count : corridor) answer = Math.max(answer, count);

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
