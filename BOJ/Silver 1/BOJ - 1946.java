import java.io.*;
import java.util.*;

class Main {
    /*
     * 서류 순위 오름차순으로 지원자를 정렬한다.
     * 지금까지의 면접 최고 순위보다 좋은 지원자만 선발할 수 있다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (tests-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] applicants = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken());
                applicants[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(applicants, Comparator.comparingInt(a -> a[0]));

            int selected = 0;
            int bestInterview = Integer.MAX_VALUE;

            for (int[] applicant : applicants) {
                if (applicant[1] < bestInterview) {
                    selected++;
                    bestInterview = applicant[1];
                }
            }

            output.append(selected).append('\n');
        }

        System.out.print(output);
    }
}
