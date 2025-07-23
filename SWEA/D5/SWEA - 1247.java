import java.io.*;
import java.util.*;

class Solution {
    static int customersCount;
    static int companyX;
    static int companyY;
    static int homeX;
    static int homeY;
    static int[][] customers;
    static boolean[] visited;
    static int answer;

    /*
     * 회사에서 출발해 모든 고객을 방문하는 순서를 백트래킹한다.
     * 현재 거리가 이미 최솟값 이상이면 가지치기하고 마지막에 집까지 이동한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            customersCount = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            companyX = Integer.parseInt(st.nextToken());
            companyY = Integer.parseInt(st.nextToken());
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());

            customers = new int[customersCount][2];

            for (int i = 0; i < customersCount; i++) {
                customers[i][0] = Integer.parseInt(st.nextToken());
                customers[i][1] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[customersCount];
            answer = Integer.MAX_VALUE;

            search(0, companyX, companyY, 0);

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void search(int count, int x, int y, int distance) {
        if (distance >= answer) return;

        if (count == customersCount) {
            answer = Math.min(
                    answer,
                    distance + Math.abs(x - homeX) + Math.abs(y - homeY)
            );
            return;
        }

        for (int i = 0; i < customersCount; i++) {
            if (visited[i]) continue;

            visited[i] = true;

            search(
                    count + 1,
                    customers[i][0],
                    customers[i][1],
                    distance
                            + Math.abs(x - customers[i][0])
                            + Math.abs(y - customers[i][1])
            );

            visited[i] = false;
        }
    }
}
