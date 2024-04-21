class Solution {
    /*
     * 각 행에서 처음 음수가 나타나는 위치를 이분 탐색한다.
     * 해당 위치부터 행의 끝까지의 개수를 전체 결과에 더한다.
     */
    public int countNegatives(int[][] grid) {
        int answer = 0;

        for (int[] row : grid) {
            int left = 0;
            int right = row.length;

            while (left < right) {
                int mid = (left + right) / 2;
                if (row[mid] < 0) right = mid;
                else left = mid + 1;
            }

            answer += row.length - left;
        }

        return answer;
    }
}
