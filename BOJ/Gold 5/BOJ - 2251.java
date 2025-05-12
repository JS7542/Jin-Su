import java.io.*;
import java.util.*;

class Main {
    /*
     * 세 물통의 현재 물 양을 상태로 BFS한다.
     * 한 물통에서 다른 물통으로 가능한 만큼 붓고 A가 비어 있을 때 C의 양을 기록한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] capacity = {
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken())
        };

        boolean[][] visited = new boolean[capacity[0] + 1][capacity[1] + 1];
        boolean[] answer = new boolean[capacity[2] + 1];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, capacity[2]});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == 0) answer[current[2]] = true;

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to || current[from] == 0 || current[to] == capacity[to]) continue;

                    int[] next = current.clone();
                    int moved = Math.min(next[from], capacity[to] - next[to]);

                    next[from] -= moved;
                    next[to] += moved;

                    if (!visited[next[0]][next[1]]) {
                        visited[next[0]][next[1]] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        StringBuilder output = new StringBuilder();

        for (int amount = 0; amount <= capacity[2]; amount++) {
            if (answer[amount]) output.append(amount).append(' ');
        }

        System.out.print(output);
    }
}
