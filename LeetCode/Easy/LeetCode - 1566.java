class Solution {
    /*
     * 각 시작 위치에서 길이 m의 패턴이 k번 연속 반복되는지 확인한다.
     * 대응하는 원소가 하나라도 다르면 다음 시작 위치로 이동한다.
     */
    public boolean containsPattern(int[] arr, int m, int k) {
        int needed = m * k;

        for (int start = 0; start + needed <= arr.length; start++) {
            boolean valid = true;

            for (int offset = m; offset < needed; offset++) {
                if (arr[start + offset] != arr[start + offset % m]) {
                    valid = false;
                    break;
                }
            }

            if (valid) return true;
        }

        return false;
    }
}
