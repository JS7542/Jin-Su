import java.io.*;
import java.util.*;

class Main {
    /*
     * 플로이드-워셜 방식으로 i에서 k, k에서 j 경로가 있으면 i에서 j를 연결한다.
     * 모든 중간 정점을 반영한 도달 가능 행렬을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] reachable = new int[n][n];

        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) reachable[r][c] = Integer.parseInt(st.nextToken());
        }

        for (int middle = 0; middle < n; middle++) {
            for (int start = 0; start < n; start++) {
                if (reachable[start][middle] == 0) continue;

                for (int end = 0; end < n; end++) {
                    if (reachable[middle][end] == 1) reachable[start][end] = 1;
                }
            }
        }

        StringBuilder output = new StringBuilder();

        for (int[] row : reachable) {
            for (int value : row) output.append(value).append(' ');
            output.append('\n');
        }

        System.out.print(output);
    }
}
