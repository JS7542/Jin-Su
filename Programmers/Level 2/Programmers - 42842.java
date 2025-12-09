class Solution {
    /*
     * 전체 격자 수의 약수 쌍을 너비와 높이 후보로 확인한다.
     * 내부 노란 격자 수가 (너비-2)(높이-2)와 같으면 정답이다.
     */
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int height = 3; height * height <= total; height++) {
            if (total % height != 0) continue;

            int width = total / height;

            if ((width - 2) * (height - 2) == yellow) {
                return new int[]{width, height};
            }
        }

        return new int[0];
    }
}
