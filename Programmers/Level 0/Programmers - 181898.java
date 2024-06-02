class Solution {
    /*
     * idx부터 배열 끝까지 순회하며 값이 1인지 확인한다.
     * 처음 발견한 위치를 반환하고 없으면 -1을 반환한다.
     */
    public int solution(int[] arr, int idx) {
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] == 1) return i;
        }
        return -1;
    }
}
