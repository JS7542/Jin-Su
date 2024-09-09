class Solution {
    /*
     * 배열 길이가 홀수이면 짝수 인덱스, 짝수이면 홀수 인덱스에 n을 더한다.
     * 조건에 맞는 위치만 수정한 배열을 반환한다.
     */
    public int[] solution(int[] arr, int n) {
        int start = arr.length % 2 == 1 ? 0 : 1;

        for (int i = start; i < arr.length; i += 2) {
            arr[i] += n;
        }

        return arr;
    }
}
