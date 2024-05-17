class Solution {
    /*
     * 기존 행과 열 중 큰 값을 새 정사각형의 한 변으로 사용한다.
     * 원본 값을 같은 위치에 복사하고 나머지 칸은 기본값 0으로 둔다.
     */
    public int[][] solution(int[][] arr) {
        int size = Math.max(arr.length, arr[0].length);
        int[][] answer = new int[size][size];

        for (int r = 0; r < arr.length; r++) {
            System.arraycopy(arr[r], 0, answer[r], 0, arr[r].length);
        }

        return answer;
    }
}
