import java.io.*;
import java.util.*;

class Main {
    /*
     * 좌표를 x 오름차순, x가 같으면 y 오름차순 기준으로 정렬한다.
     * 정렬된 좌표를 입력 형식과 동일하게 한 줄씩 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points, (a, b) -> a[0] != b[0]
                ? Integer.compare(a[0], b[0])
                : Integer.compare(a[1], b[1]));

        StringBuilder sb = new StringBuilder();
        for (int[] point : points) sb.append(point[0]).append(' ').append(point[1]).append('\n');
        System.out.print(sb);
    }
}
