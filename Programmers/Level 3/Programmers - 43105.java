class Solution {
    /*
     * 두 번째 행부터 각 칸까지 내려오는 최대 합을 계산한다.
     * 양 끝은 하나의 부모만, 내부는 왼쪽 위와 오른쪽 위 부모 중 큰 값을 선택한다.
     */
    public int solution(int[][] triangle) {
        for (int row = 1; row < triangle.length; row++) {
            for (int col = 0; col <= row; col++) {
                int left = col > 0 ? triangle[row - 1][col - 1] : 0;
                int right = col < row ? triangle[row - 1][col] : 0;

                triangle[row][col] += Math.max(left, right);
            }
        }

        int answer = 0;

        for (int value : triangle[triangle.length - 1]) {
            answer = Math.max(answer, value);
        }

        return answer;
    }
}
