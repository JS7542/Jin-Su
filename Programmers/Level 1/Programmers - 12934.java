class Solution {
    /*
     * n의 제곱근을 정수로 변환한 값이 정확히 제곱해서 n이 되는지 확인한다.
     * 완전제곱수이면 다음 정수의 제곱을, 아니면 -1을 반환한다.
     */
    public long solution(long n) {
        long root = (long) Math.sqrt(n);
        return root * root == n ? (root + 1) * (root + 1) : -1;
    }
}
