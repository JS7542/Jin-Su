class Solution {
    /*
     * 각 열을 위에서 아래로 확인하며 문자가 감소하는 위치가 있는지 검사한다.
     * 정렬되지 않은 열의 개수를 센다.
     */
    public int minDeletionSize(String[] strs) {
        int answer = 0;

        for (int col = 0; col < strs[0].length(); col++) {
            for (int row = 1; row < strs.length; row++) {
                if (strs[row - 1].charAt(col) > strs[row].charAt(col)) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
