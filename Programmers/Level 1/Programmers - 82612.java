class Solution {
    /*
     * 놀이기구를 1회부터 count회까지 이용하는 전체 비용을 등차수열 합으로 계산한다.
     * 가진 돈을 뺀 부족 금액과 0 중 큰 값을 반환한다.
     */
    public long solution(int price, int money, int count) {
        long cost = (long) price * count * (count + 1) / 2;
        return Math.max(0, cost - money);
    }
}
