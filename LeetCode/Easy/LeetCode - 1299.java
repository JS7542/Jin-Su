class Solution {
    /*
     * 배열의 오른쪽 끝부터 현재까지의 최댓값을 유지한다.
     * 각 위치에는 기존 오른쪽 최댓값을 저장하고 현재 값을 최댓값에 반영한다.
     */
    public int[] replaceElements(int[] arr) {
        int maxRight = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = maxRight;
            maxRight = Math.max(maxRight, current);
        }

        return arr;
    }
}
