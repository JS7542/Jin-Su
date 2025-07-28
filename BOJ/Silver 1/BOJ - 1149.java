import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 집을 특정 색으로 칠했을 때의 최소 누적 비용을 계산한다.
     * 현재 색과 다른 이전 두 색의 비용 중 작은 값에 현재 비용을 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] previous = new int[3];

        for (int house = 0; house < n; house++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            int[] current = new int[3];
            current[0] = red + Math.min(previous[1], previous[2]);
            current[1] = green + Math.min(previous[0], previous[2]);
            current[2] = blue + Math.min(previous[0], previous[1]);
            previous = current;
        }

        System.out.print(Math.min(previous[0], Math.min(previous[1], previous[2])));
    }
}
