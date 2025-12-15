import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 행에서 세 열까지의 최대·최소 누적합을 동시에 계산한다.
     * 현재 열에 올 수 있는 이전 열만 비교해 메모리를 한 행으로 줄인다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] maximum = new int[3];
        int[] minimum = new int[3];

        for (int row = 0; row < n; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] values = {
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            };

            if (row == 0) {
                maximum = values.clone();
                minimum = values.clone();
                continue;
            }

            int[] nextMaximum = new int[3];
            int[] nextMinimum = new int[3];

            nextMaximum[0] = values[0] + Math.max(maximum[0], maximum[1]);
            nextMaximum[1] = values[1] + Math.max(maximum[0], Math.max(maximum[1], maximum[2]));
            nextMaximum[2] = values[2] + Math.max(maximum[1], maximum[2]);

            nextMinimum[0] = values[0] + Math.min(minimum[0], minimum[1]);
            nextMinimum[1] = values[1] + Math.min(minimum[0], Math.min(minimum[1], minimum[2]));
            nextMinimum[2] = values[2] + Math.min(minimum[1], minimum[2]);

            maximum = nextMaximum;
            minimum = nextMinimum;
        }

        int maxAnswer = Math.max(maximum[0], Math.max(maximum[1], maximum[2]));
        int minAnswer = Math.min(minimum[0], Math.min(minimum[1], minimum[2]));

        System.out.print(maxAnswer + " " + minAnswer);
    }
}
