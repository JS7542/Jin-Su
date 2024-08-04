class Solution {
    /*
     * 각 쿼리에 기록된 두 인덱스의 값을 교환한다.
     * 모든 교환을 순서대로 적용한 배열을 반환한다.
     */
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int temp = arr[query[0]];
            arr[query[0]] = arr[query[1]];
            arr[query[1]] = temp;
        }
        return arr;
    }
}
