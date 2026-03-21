import java.io.*;
import java.util.*;

class Main {
    /*
     * 뱀의 몸을 덱과 점유 배열로 관리한다.
     * 매초 머리를 이동하고 사과가 없으면 꼬리를 제거하며 예약된 방향 전환을 적용한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        boolean[][] apple = new boolean[size][size];

        int apples = Integer.parseInt(br.readLine());

        for (int i = 0; i < apples; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            apple[row][col] = true;
        }

        int commands = Integer.parseInt(br.readLine());
        Map<Integer, Character> turns = new HashMap<>();

        for (int i = 0; i < commands; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            turns.put(
                    Integer.parseInt(st.nextToken()),
                    st.nextToken().charAt(0)
            );
        }

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Deque<int[]> snake = new ArrayDeque<>();
        boolean[][] occupied = new boolean[size][size];

        snake.offerFirst(new int[]{0, 0});
        occupied[0][0] = true;

        int direction = 0;
        int time = 0;

        while (true) {
            time++;

            int[] head = snake.peekFirst();
            int nr = head[0] + dr[direction];
            int nc = head[1] + dc[direction];

            if (nr < 0 || nr >= size || nc < 0 || nc >= size || occupied[nr][nc]) {
                break;
            }

            snake.offerFirst(new int[]{nr, nc});
            occupied[nr][nc] = true;

            if (apple[nr][nc]) {
                apple[nr][nc] = false;
            } else {
                int[] tail = snake.pollLast();
                occupied[tail[0]][tail[1]] = false;
            }

            if (turns.containsKey(time)) {
                direction = turns.get(time) == 'D'
                        ? (direction + 1) % 4
                        : (direction + 3) % 4;
            }
        }

        System.out.print(time);
    }
}
