class Solution {
    /*
     * 간선을 순서대로 유니온 파인드에 추가한다.
     * 이미 같은 집합에 속한 두 정점을 연결하는 간선이 사이클을 만드는 중복 간선이다.
     */
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];

        for (int node = 1; node < parent.length; node++) parent[node] = node;

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) return edge;
        }

        return new int[0];
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
