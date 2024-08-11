class Solution {
    /*
     * 각 쿼리의 s부터 e까지 인덱스를 확인한다.
     * 인덱스가 k의 배수인 위치의 원소에 1을 더한다.
     */
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];

            for (int i = s; i <= e; i++) {
                if (i % k == 0) arr[i]++;
            }
        }

        return arr;
    }
}
