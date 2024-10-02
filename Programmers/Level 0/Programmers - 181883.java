class Solution {
    /*
     * 각 쿼리의 시작 인덱스부터 끝 인덱스까지 순회한다.
     * 해당 구간의 모든 원소에 1을 더한 배열을 반환한다.
     */
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[1]; i++) arr[i]++;
        }
        return arr;
    }
}
