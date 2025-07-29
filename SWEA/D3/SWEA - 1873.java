import java.io.*;
import java.util.*;

class Solution {
    /*
     * 전차의 위치와 방향을 추적하며 이동 명령은 평지일 때만 위치를 변경한다.
     * 발사 명령은 현재 방향으로 벽이나 맵 경계를 만날 때까지 진행하고 벽돌 벽을 파괴한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        char[] tank = {'^', 'v', '<', '>'};

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rows = Integer.parseInt(st.nextToken());
            int cols = Integer.parseInt(st.nextToken());

            char[][] map = new char[rows][cols];
            int tankRow = 0;
            int tankCol = 0;
            int direction = 0;

            for (int row = 0; row < rows; row++) {
                map[row] = br.readLine().toCharArray();

                for (int col = 0; col < cols; col++) {
                    for (int d = 0; d < 4; d++) {
                        if (map[row][col] == tank[d]) {
                            tankRow = row;
                            tankCol = col;
                            direction = d;
                        }
                    }
                }
            }

            br.readLine();
            String commands = br.readLine();

            for (char command : commands.toCharArray()) {
                if (command == 'S') {
                    int row = tankRow + dr[direction];
                    int col = tankCol + dc[direction];

                    while (row >= 0 && row < rows && col >= 0 && col < cols) {
                        if (map[row][col] == '*') {
                            map[row][col] = '.';
                            break;
                        }

                        if (map[row][col] == '#') break;

                        row += dr[direction];
                        col += dc[direction];
                    }
                } else {
                    if (command == 'U') direction = 0;
                    else if (command == 'D') direction = 1;
                    else if (command == 'L') direction = 2;
                    else direction = 3;

                    map[tankRow][tankCol] = tank[direction];

                    int nextRow = tankRow + dr[direction];
                    int nextCol = tankCol + dc[direction];

                    if (nextRow >= 0 && nextRow < rows
                            && nextCol >= 0 && nextCol < cols
                            && map[nextRow][nextCol] == '.') {
                        map[tankRow][tankCol] = '.';
                        tankRow = nextRow;
                        tankCol = nextCol;
                        map[tankRow][tankCol] = tank[direction];
                    }
                }
            }

            output.append('#').append(tc).append(' ');

            for (char[] row : map) {
                output.append(row).append('\n');
            }
        }

        System.out.print(output);
    }
}
