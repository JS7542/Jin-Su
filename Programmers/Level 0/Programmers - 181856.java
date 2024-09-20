class Solution {
    /*
     * 배열 길이가 다르면 길이가 긴 배열이 더 크다.
     * 길이가 같으면 각 배열 원소 합을 비교해 -1, 0, 1을 반환한다.
     */
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return Integer.compare(arr1.length, arr2.length);
        }

        int sum1 = 0;
        int sum2 = 0;

        for (int value : arr1) sum1 += value;
        for (int value : arr2) sum2 += value;

        return Integer.compare(sum1, sum2);
    }
}
