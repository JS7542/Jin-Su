import java.io.*;
import java.util.*;

class Main {
    /*
     * 집 좌표를 정렬하고 공유기 사이의 최소 거리를 이분 탐색한다.
     * 앞에서부터 가능한 가장 가까운 집에 공유기를 설치해 개수를 확인한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int routers = Integer.parseInt(st.nextToken());

        int[] houses = new int[n];

        for (int i = 0; i < n; i++) houses[i] = Integer.parseInt(br.readLine());

        Arrays.sort(houses);

        int left = 1;
        int right = houses[n - 1] - houses[0];
        int answer = 0;

        while (left <= right) {
            int distance = left + (right - left) / 2;
            int installed = 1;
            int last = houses[0];

            for (int i = 1; i < n; i++) {
                if (houses[i] - last >= distance) {
                    installed++;
                    last = houses[i];
                }
            }

            if (installed >= routers) {
                answer = distance;
                left = distance + 1;
            } else {
                right = distance - 1;
            }
        }

        System.out.print(answer);
    }
}
