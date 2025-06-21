import java.io.*;
import java.util.*;

class Main {
    /*
     * 1번 칸에서 주사위 1~6 이동을 BFS로 탐색한다.
     * 도착 칸에 사다리나 뱀이 있으면 즉시 이동한 칸을 다음 상태로 사용한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ladders = Integer.parseInt(st.nextToken());
        int snakes = Integer.parseInt(st.nextToken());

        int[] move = new int[101];

        for (int i = 0; i < ladders + snakes; i++) {
            st = new StringTokenizer(br.readLine());
            move[Integer.parseInt(st.nextToken())] =
                    Integer.parseInt(st.nextToken());
        }

        int[] distance = new int[101];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == 100) break;

            for (int dice = 1; dice <= 6; dice++) {
                int next = current + dice;

                if (next > 100) continue;
                if (move[next] != 0) next = move[next];
                if (distance[next] != -1) continue;

                distance[next] = distance[current] + 1;
                queue.offer(next);
            }
        }

        System.out.print(distance[100]);
    }
}
