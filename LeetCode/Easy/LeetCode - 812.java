class Solution {
    /*
     * 서로 다른 세 점을 고르는 모든 조합을 확인한다.
     * 외적 절댓값의 절반으로 삼각형 넓이를 계산해 최댓값을 구한다.
     */
    public double largestTriangleArea(int[][] points) {
        double answer = 0;

        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    answer = Math.max(answer, area(points[i], points[j], points[k]));
                }
            }
        }

        return answer;
    }

    private double area(int[] a, int[] b, int[] c) {
        return Math.abs(
            a[0] * (b[1] - c[1])
            + b[0] * (c[1] - a[1])
            + c[0] * (a[1] - b[1])
        ) / 2.0;
    }
}
