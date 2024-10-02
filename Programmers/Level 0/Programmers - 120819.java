class Solution {
    /*
     * 한 잔 가격 5500원으로 살 수 있는 최대 잔 수를 몫으로 구한다.
     * 나머지 연산으로 남은 돈을 계산해 배열로 반환한다.
     */
    public int[] solution(int money) {
        return new int[]{money / 5500, money % 5500};
    }
}
