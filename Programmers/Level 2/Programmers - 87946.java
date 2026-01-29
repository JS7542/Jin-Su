class Solution {
    /*
     * 아직 방문하지 않은 던전 중 현재 피로도로 입장 가능한 곳을 선택한다.
     * 모든 방문 순서를 백트래킹하며 탐험 가능한 최대 던전 수를 구한다.
     */
    private int answer;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        search(k, dungeons, visited, 0);
        return answer;
    }

    private void search(
            int fatigue,
            int[][] dungeons,
            boolean[] visited,
            int count
    ) {
        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || fatigue < dungeons[i][0]) continue;

            visited[i] = true;
            search(fatigue - dungeons[i][1], dungeons, visited, count + 1);
            visited[i] = false;
        }
    }
}
