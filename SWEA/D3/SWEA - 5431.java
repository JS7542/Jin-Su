import java.io.*;
import java.util.*;

class Solution {
    /*
     * 과제를 제출한 학생 번호를 boolean 배열에 표시한다.
     * 1번부터 N번까지 표시되지 않은 학생 번호를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int students = Integer.parseInt(st.nextToken());
            int submittedCount = Integer.parseInt(st.nextToken());

            boolean[] submitted = new boolean[students + 1];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < submittedCount; i++) {
                submitted[Integer.parseInt(st.nextToken())] = true;
            }

            output.append('#').append(tc).append(' ');

            for (int student = 1; student <= students; student++) {
                if (!submitted[student]) output.append(student).append(' ');
            }

            output.append('\n');
        }

        System.out.print(output);
    }
}
