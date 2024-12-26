class Solution {
    /*
     * 1부터 양의 정수를 증가시키며 배열에 없는 값을 센다.
     * k번째로 빠진 양의 정수를 찾으면 반환한다.
     */
    public int findKthPositive(int[] arr, int k) {
        int index = 0;
        int value = 1;

        while (true) {
            if (index < arr.length && arr[index] == value) {
                index++;
            } else if (--k == 0) {
                return value;
            }
            value++;
        }
    }
}
