class Solution {
    /*
     * 처음에는 엄격히 증가하는 구간을 따라 정상까지 이동한다.
     * 정상은 양 끝이 아니어야 하며 이후 엄격히 감소해 마지막에 도달해야 한다.
     */
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;

        int index = 0;
        while (index + 1 < arr.length && arr[index] < arr[index + 1]) index++;

        if (index == 0 || index == arr.length - 1) return false;

        while (index + 1 < arr.length && arr[index] > arr[index + 1]) index++;
        return index == arr.length - 1;
    }
}
