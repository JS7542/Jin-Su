class Solution {
    /*
     * 각 선수가 다른 모든 선수에게 이기는지 확인한다.
     * 행의 자기 자신 제외 값이 모두 1인 선수 인덱스를 반환한다.
     */
    public int findChampion(int[][] grid) {
        for (int player = 0; player < grid.length; player++) {
            boolean champion = true;

            for (int opponent = 0; opponent < grid.length; opponent++) {
                if (player != opponent && grid[player][opponent] == 0) {
                    champion = false;
                    break;
                }
            }

            if (champion) return player;
        }

        return -1;
    }
}
