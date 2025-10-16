import java.io.*;
import java.util.*;

class Main {
    static class Fireball {
        int row;
        int col;
        int mass;
        int speed;
        int direction;

        Fireball(int row, int col, int mass, int speed, int direction) {
            this.row = row;
            this.col = col;
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
        }
    }

    /*
     * 모든 파이어볼을 속도와 방향에 따라 동시에 이동시킨다.
     * 같은 칸의 파이어볼은 합친 뒤 질량·속도·방향 규칙에 따라 네 개로 다시 나눈다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int commands = Integer.parseInt(st.nextToken());

        List<Fireball> fireballs = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            fireballs.add(new Fireball(
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        while (commands-- > 0) {
            List<Fireball>[][] cells = new ArrayList[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    cells[row][col] = new ArrayList<>();
                }
            }

            for (Fireball fireball : fireballs) {
                int distance = fireball.speed % size;
                int row = (fireball.row + dr[fireball.direction] * distance) % size;
                int col = (fireball.col + dc[fireball.direction] * distance) % size;

                if (row < 0) row += size;
                if (col < 0) col += size;

                fireball.row = row;
                fireball.col = col;
                cells[row][col].add(fireball);
            }

            List<Fireball> next = new ArrayList<>();

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    List<Fireball> cell = cells[row][col];

                    if (cell.isEmpty()) continue;

                    if (cell.size() == 1) {
                        next.add(cell.get(0));
                        continue;
                    }

                    int mass = 0;
                    int speed = 0;
                    boolean even = true;
                    boolean odd = true;

                    for (Fireball fireball : cell) {
                        mass += fireball.mass;
                        speed += fireball.speed;

                        if (fireball.direction % 2 == 0) odd = false;
                        else even = false;
                    }

                    mass /= 5;

                    if (mass == 0) continue;

                    speed /= cell.size();
                    int startDirection = even || odd ? 0 : 1;

                    for (int direction = startDirection; direction < 8; direction += 2) {
                        next.add(new Fireball(
                                row, col, mass, speed, direction
                        ));
                    }
                }
            }

            fireballs = next;
        }

        int answer = 0;

        for (Fireball fireball : fireballs) answer += fireball.mass;

        System.out.print(answer);
    }
}
