import java.io.*;
import java.util.*;

class Main {
    /*
     * 현재 층에서 위 U층과 아래 D층으로 이동하는 상태 그래프를 BFS로 탐색한다.
     * 목표 층의 최초 방문 횟수를 출력하고 도달하지 못하면 문구를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int floors = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        int[] distance = new int[floors + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : new int[]{current + up, current - down}) {
                if (next < 1 || next > floors || distance[next] != -1) continue;

                distance[next] = distance[current] + 1;
                queue.offer(next);
            }
        }

        if (distance[target] == -1) System.out.print("use the stairs");
        else System.out.print(distance[target]);
    }
}
