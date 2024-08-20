class Solution {
    /*
     * 각 쿼리의 구간에서 k보다 큰 값만 확인한다.
     * 조건을 만족하는 값 중 최솟값을 찾고 없으면 -1을 기록한다.
     */
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int min = Integer.MAX_VALUE;

            for (int i = queries[q][0]; i <= queries[q][1]; i++) {
                if (arr[i] > queries[q][2]) min = Math.min(min, arr[i]);
            }

            answer[q] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return answer;
    }
}
