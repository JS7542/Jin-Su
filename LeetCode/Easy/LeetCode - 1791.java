class Solution {
    /*
     * 별 그래프의 중심은 첫 두 간선에 공통으로 등장하는 정점이다.
     * 첫 간선의 각 정점이 두 번째 간선에 포함되는지 확인한다.
     */
    public int findCenter(int[][] edges) {
        int first = edges[0][0];
        return first == edges[1][0] || first == edges[1][1] ? first : edges[0][1];
    }
}
