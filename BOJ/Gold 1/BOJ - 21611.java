import java.io.*;
import java.util.*;

class Main {
    /*
     * 격자를 달팽이 순서의 1차원 구슬 배열로 변환한다.
     * 파괴 후 빈칸 제거, 연속 4개 이상 폭발, 그룹 변환을 반복해 점수를 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int spells = Integer.parseInt(st.nextToken());

        int[][] board = new int[size][size];

        for (int row = 0; row < size; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < size; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> order = spiralOrder(size);
        int[] marbles = new int[size * size - 1];

        for (int index = 0; index < order.size(); index++) {
            int[] cell = order.get(index);
            marbles[index] = board[cell[0]][cell[1]];
        }

        int[] destroyed = new int[4];
        int center = size / 2;
        int[] spellR = {0, -1, 1, 0, 0};
        int[] spellC = {0, 0, 0, -1, 1};

        Map<Integer, Integer> indexByCell = new HashMap<>();

        for (int index = 0; index < order.size(); index++) {
            int[] cell = order.get(index);
            indexByCell.put(cell[0] * size + cell[1], index);
        }

        for (int spell = 0; spell < spells; spell++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            for (int step = 1; step <= distance; step++) {
                int row = center + spellR[direction] * step;
                int col = center + spellC[direction] * step;
                Integer index = indexByCell.get(row * size + col);

                if (index != null) marbles[index] = 0;
            }

            marbles = compact(marbles);

            while (explode(marbles, destroyed)) {
                marbles = compact(marbles);
            }

            marbles = transform(marbles);
        }

        int answer = destroyed[1] + destroyed[2] * 2 + destroyed[3] * 3;
        System.out.print(answer);
    }

    static List<int[]> spiralOrder(int size) {
        List<int[]> order = new ArrayList<>();
        int row = size / 2;
        int col = size / 2;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {-1, 0, 1, 0};

        int direction = 0;
        int distance = 1;

        while (order.size() < size * size - 1) {
            for (int repeat = 0; repeat < 2; repeat++) {
                for (int step = 0; step < distance; step++) {
                    row += dr[direction];
                    col += dc[direction];

                    if (row >= 0 && row < size && col >= 0 && col < size) {
                        order.add(new int[]{row, col});

                        if (order.size() == size * size - 1) return order;
                    }
                }

                direction = (direction + 1) % 4;
            }

            distance++;
        }

        return order;
    }

    static int[] compact(int[] marbles) {
        int[] result = new int[marbles.length];
        int index = 0;

        for (int marble : marbles) {
            if (marble != 0) result[index++] = marble;
        }

        return result;
    }

    static boolean explode(int[] marbles, int[] destroyed) {
        boolean exploded = false;
        int index = 0;

        while (index < marbles.length && marbles[index] != 0) {
            int end = index + 1;

            while (end < marbles.length && marbles[end] == marbles[index]) end++;

            if (end - index >= 4) {
                exploded = true;
                destroyed[marbles[index]] += end - index;

                for (int current = index; current < end; current++) {
                    marbles[current] = 0;
                }
            }

            index = end;
        }

        return exploded;
    }

    static int[] transform(int[] marbles) {
        int[] result = new int[marbles.length];
        int write = 0;
        int index = 0;

        while (index < marbles.length
                && marbles[index] != 0
                && write < result.length) {
            int end = index + 1;

            while (end < marbles.length && marbles[end] == marbles[index]) end++;

            if (write < result.length) result[write++] = end - index;
            if (write < result.length) result[write++] = marbles[index];

            index = end;
        }

        return result;
    }
}
