import java.io.*;
import java.util.*;

class Main {
    /*
     * 이전 세대 방향을 역순으로 읽고 시계 방향 회전한 방향을 뒤에 추가한다.
     * 생성된 방향대로 점을 표시한 뒤 네 꼭짓점이 모두 있는 단위 정사각형을 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int curves = Integer.parseInt(br.readLine());
        boolean[][] point = new boolean[101][101];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int curve = 0; curve < curves; curve++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int generation = Integer.parseInt(st.nextToken());

            List<Integer> directions = new ArrayList<>();
            directions.add(direction);

            for (int currentGeneration = 0;
                    currentGeneration < generation;
                    currentGeneration++) {
                for (int index = directions.size() - 1; index >= 0; index--) {
                    directions.add((directions.get(index) + 1) % 4);
                }
            }

            point[y][x] = true;

            for (int currentDirection : directions) {
                x += dx[currentDirection];
                y += dy[currentDirection];
                point[y][x] = true;
            }
        }

        int answer = 0;

        for (int row = 0; row < 100; row++) {
            for (int col = 0; col < 100; col++) {
                if (point[row][col]
                        && point[row + 1][col]
                        && point[row][col + 1]
                        && point[row + 1][col + 1]) {
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }
}
