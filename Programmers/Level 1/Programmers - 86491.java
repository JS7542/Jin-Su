class Solution {
    /*
     * 각 명함의 긴 변을 가로, 짧은 변을 세로 방향으로 통일한다.
     * 모든 가로 최댓값과 세로 최댓값을 곱해 지갑 크기를 구한다.
     */
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            maxWidth = Math.max(maxWidth, Math.max(size[0], size[1]));
            maxHeight = Math.max(maxHeight, Math.min(size[0], size[1]));
        }

        return maxWidth * maxHeight;
    }
}
