import java.io.*;
import java.util.*;

class Solution {
    static class Group {
        int row;
        int col;
        int count;
        int direction;

        Group(int row, int col, int count, int direction) {
            this.row = row;
            this.col = col;
            this.count = count;
            this.direction = direction;
        }
    }

    static class Merged {
        int total;
        int maximum;
        int direction;
        int row;
        int col;
    }

    /*
     * 모든 군집을 한 칸 이동시키고 약품 경계에서는 수를 절반으로 줄이며 방향을 반대로 바꾼다.
     * 같은 칸에 모인 군집은 합치고 가장 큰 군집의 방향을 유지한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        int[] dr = {0, -1, 1, 0, 0};
        int[] dc = {0, 0, 0, -1, 1};
        int[] opposite = {0, 2, 1, 4, 3};

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int times = Integer.parseInt(st.nextToken());
            int groupCount = Integer.parseInt(st.nextToken());

            List<Group> groups = new ArrayList<>();

            for (int i = 0; i < groupCount; i++) {
                st = new StringTokenizer(br.readLine());

                groups.add(new Group(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                ));
            }

            for (int time = 0; time < times; time++) {
                Map<Integer, Merged> mergedMap = new HashMap<>();

                for (Group group : groups) {
                    int row = group.row + dr[group.direction];
                    int col = group.col + dc[group.direction];
                    int count = group.count;
                    int direction = group.direction;

                    if (row == 0 || row == size - 1
                            || col == 0 || col == size - 1) {
                        count /= 2;
                        direction = opposite[direction];
                    }

                    if (count == 0) continue;

                    int key = row * size + col;
                    Merged merged = mergedMap.computeIfAbsent(key, ignored -> {
                        Merged value = new Merged();
                        value.row = row;
                        value.col = col;
                        return value;
                    });

                    merged.total += count;

                    if (count > merged.maximum) {
                        merged.maximum = count;
                        merged.direction = direction;
                    }
                }

                groups = new ArrayList<>();

                for (Merged merged : mergedMap.values()) {
                    groups.add(new Group(
                            merged.row,
                            merged.col,
                            merged.total,
                            merged.direction
                    ));
                }
            }

            int answer = 0;

            for (Group group : groups) answer += group.count;

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
