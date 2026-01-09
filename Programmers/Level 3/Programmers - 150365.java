class Solution {
    /*
     * 사전순 d, l, r, u 순서로 다음 이동을 시도한다.
     * 이동 후 남은 거리와 남은 횟수의 크기·홀짝 조건을 만족하는 첫 방향을 선택한다.
     */
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int initialDistance = Math.abs(x - r) + Math.abs(y - c);

        if (initialDistance > k || (k - initialDistance) % 2 == 1) {
            return "impossible";
        }

        char[] command = {'d', 'l', 'r', 'u'};
        int[] dr = {1, 0, 0, -1};
        int[] dc = {0, -1, 1, 0};

        StringBuilder answer = new StringBuilder();
        int row = x;
        int col = y;

        for (int step = 0; step < k; step++) {
            int remaining = k - step - 1;

            for (int direction = 0; direction < 4; direction++) {
                int nr = row + dr[direction];
                int nc = col + dc[direction];

                if (nr < 1 || nr > n || nc < 1 || nc > m) continue;

                int distance = Math.abs(nr - r) + Math.abs(nc - c);

                if (distance <= remaining && (remaining - distance) % 2 == 0) {
                    answer.append(command[direction]);
                    row = nr;
                    col = nc;
                    break;
                }
            }
        }

        return answer.toString();
    }
}
