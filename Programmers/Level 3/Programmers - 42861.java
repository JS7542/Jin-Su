import java.util.*;

class Solution {
    /*
     * 모든 다리를 비용 오름차순으로 정렬한다.
     * 서로 다른 집합의 섬을 연결하는 다리만 선택하는 크루스칼 알고리즘을 사용한다.
     */
    private int[] parent;

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(edge -> edge[2]));

        parent = new int[n];
        for (int island = 0; island < n; island++) parent[island] = island;

        int answer = 0;
        int selected = 0;

        for (int[] edge : costs) {
            if (!union(edge[0], edge[1])) continue;

            answer += edge[2];

            if (++selected == n - 1) break;
        }

        return answer;
    }

    private int find(int value) {
        if (parent[value] == value) return value;
        return parent[value] = find(parent[value]);
    }

    private boolean union(int first, int second) {
        int rootFirst = find(first);
        int rootSecond = find(second);

        if (rootFirst == rootSecond) return false;

        parent[rootSecond] = rootFirst;
        return true;
    }
}
