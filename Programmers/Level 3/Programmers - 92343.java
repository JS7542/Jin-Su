import java.util.*;

class Solution {
    /*
     * 현재까지 방문 가능한 노드 집합에서 다음 노드를 하나 선택한다.
     * 양 수가 늑대 수보다 클 때만 탐색을 이어가며 최대 양 수를 갱신한다.
     */
    private int[] info;
    private List<Integer>[] children;
    private int answer;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        children = new ArrayList[info.length];

        for (int node = 0; node < info.length; node++) {
            children[node] = new ArrayList<>();
        }

        for (int[] edge : edges) children[edge[0]].add(edge[1]);

        List<Integer> candidates = new ArrayList<>(children[0]);
        search(1, 0, candidates);

        return answer;
    }

    private void search(
            int sheep,
            int wolves,
            List<Integer> candidates
    ) {
        answer = Math.max(answer, sheep);

        for (int index = 0; index < candidates.size(); index++) {
            int node = candidates.get(index);
            int nextSheep = sheep + (info[node] == 0 ? 1 : 0);
            int nextWolves = wolves + (info[node] == 1 ? 1 : 0);

            if (nextSheep <= nextWolves) continue;

            List<Integer> nextCandidates = new ArrayList<>(candidates);
            nextCandidates.remove(index);
            nextCandidates.addAll(children[node]);

            search(nextSheep, nextWolves, nextCandidates);
        }
    }
}
