class Solution {
    /*
     * 정렬 배열에서 25%를 초과해 등장한 값은 quarter 간격의 두 위치가 같다.
     * 해당 조건을 처음 만족하는 값을 반환한다.
     */
    public int findSpecialInteger(int[] arr) {
        int quarter = arr.length / 4;

        for (int i = 0; i + quarter < arr.length; i++) {
            if (arr[i] == arr[i + quarter]) return arr[i];
        }

        return -1;
    }
}
