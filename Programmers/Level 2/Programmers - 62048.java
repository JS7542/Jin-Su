class Solution {
    /*
     * 대각선이 지나가는 칸 수는 w+h-gcd(w,h)다.
     * 전체 칸 수에서 사용할 수 없는 칸 수를 빼 반환한다.
     */
    public long solution(int w, int h) {
        long gcd = gcd(w, h);
        return (long) w * h - (w + h - gcd);
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
