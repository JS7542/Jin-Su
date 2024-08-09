class Solution {
    /*
     * 공원에서 시작 위치를 찾고 각 명령의 이동 경로가 모두 유효한지 확인한다.
     * 경계를 넘거나 장애물을 만나지 않는 명령만 실제 위치에 반영한다.
     */
    public int[] solution(String[] park, String[] routes) {
        int row = 0;
        int col = 0;

        for (int r = 0; r < park.length; r++) {
            int index = park[r].indexOf('S');
            if (index >= 0) {
                row = r;
                col = index;
            }
        }

        for (String route : routes) {
            String[] parts = route.split(" ");
            char direction = parts[0].charAt(0);
            int distance = Integer.parseInt(parts[1]);
            int dr = direction == 'N' ? -1 : direction == 'S' ? 1 : 0;
            int dc = direction == 'W' ? -1 : direction == 'E' ? 1 : 0;

            int nr = row;
            int nc = col;
            boolean valid = true;

            for (int step = 0; step < distance; step++) {
                nr += dr;
                nc += dc;

                if (nr < 0 || nr >= park.length || nc < 0 || nc >= park[0].length()
                        || park[nr].charAt(nc) == 'X') {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                row = nr;
                col = nc;
            }
        }

        return new int[]{row, col};
    }
}
