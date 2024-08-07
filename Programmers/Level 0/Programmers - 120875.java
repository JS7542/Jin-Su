class Solution {
    /*
     * 네 점을 두 선분으로 나누는 세 가지 조합을 모두 확인한다.
     * 기울기를 나눗셈 없이 교차곱으로 비교해 평행한 조합이 있으면 1을 반환한다.
     */
    public int solution(int[][] dots) {
        if (parallel(dots[0], dots[1], dots[2], dots[3])) return 1;
        if (parallel(dots[0], dots[2], dots[1], dots[3])) return 1;
        if (parallel(dots[0], dots[3], dots[1], dots[2])) return 1;
        return 0;
    }

    private boolean parallel(int[] a, int[] b, int[] c, int[] d) {
        return (long) (b[1] - a[1]) * (d[0] - c[0])
                == (long) (d[1] - c[1]) * (b[0] - a[0]);
    }
}
