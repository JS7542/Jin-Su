class Solution {
    /*
     * 각 원소가 포함되는 전체 부분 배열 수에서 홀수 길이 부분 배열 수를 계산한다.
     * 해당 등장 횟수와 원소 값을 곱해 전체 합에 더한다.
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int answer = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int total = (i + 1) * (n - i);
            int odd = (total + 1) / 2;
            answer += arr[i] * odd;
        }

        return answer;
    }
}
