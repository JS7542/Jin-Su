class Solution {
    /*
     * 새 배열에 원본 값을 순서대로 복사하되 0을 만나면 한 번 더 기록한다.
     * 새 배열의 길이를 넘지 않는 범위만 원본 배열에 다시 복사한다.
     */
    public void duplicateZeros(int[] arr) {
        int[] copy = new int[arr.length];
        int write = 0;

        for (int value : arr) {
            if (write >= copy.length) break;
            copy[write++] = value;
            if (value == 0 && write < copy.length) copy[write++] = 0;
        }

        System.arraycopy(copy, 0, arr, 0, arr.length);
    }
}
