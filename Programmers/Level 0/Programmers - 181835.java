class Solution {
    /*
     * k가 홀수이면 모든 원소에 k를 곱한다.
     * k가 짝수이면 모든 원소에 k를 더해 배열을 변환한다.
     */
    public int[] solution(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = k % 2 == 1 ? arr[i] * k : arr[i] + k;
        }
        return arr;
    }
}
