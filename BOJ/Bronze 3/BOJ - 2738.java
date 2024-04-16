import java.io.*;
import java.util.*;

class Main {
    /*
     * 첫 번째 행렬을 저장한 뒤 두 번째 행렬을 입력받으며 같은 위치에 더한다.
     * 완성된 합 행렬을 행 단위로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) matrix[i][j] += Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int value : row) sb.append(value).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
