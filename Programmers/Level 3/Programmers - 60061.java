import java.util.*;

class Solution {
    /*
     * 명령을 임시로 적용한 뒤 전체 구조물이 설치 조건을 만족하는지 검사한다.
     * 조건을 깨뜨리는 설치·삭제는 되돌리고 마지막 구조물을 정렬해 반환한다.
     */
    public int[][] solution(int n, int[][] build_frame) {
        boolean[][] pillar = new boolean[n + 1][n + 1];
        boolean[][] beam = new boolean[n + 1][n + 1];

        for (int[] command : build_frame) {
            int x = command[0];
            int y = command[1];
            int type = command[2];
            boolean install = command[3] == 1;

            if (type == 0) pillar[x][y] = install;
            else beam[x][y] = install;

            if (!valid(n, pillar, beam)) {
                if (type == 0) pillar[x][y] = !install;
                else beam[x][y] = !install;
            }
        }

        List<int[]> result = new ArrayList<>();

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (pillar[x][y]) result.add(new int[]{x, y, 0});
                if (beam[x][y]) result.add(new int[]{x, y, 1});
            }
        }

        return result.toArray(new int[0][]);
    }

    private boolean valid(
            int n,
            boolean[][] pillar,
            boolean[][] beam
    ) {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (pillar[x][y]) {
                    boolean supported = y == 0
                            || pillar[x][y - 1]
                            || (x > 0 && beam[x - 1][y])
                            || beam[x][y];

                    if (!supported) return false;
                }

                if (beam[x][y]) {
                    boolean supported = (y > 0 && pillar[x][y - 1])
                            || (x < n && y > 0 && pillar[x + 1][y - 1])
                            || (x > 0 && x < n
                            && beam[x - 1][y] && beam[x + 1][y]);

                    if (!supported) return false;
                }
            }
        }

        return true;
    }
}
