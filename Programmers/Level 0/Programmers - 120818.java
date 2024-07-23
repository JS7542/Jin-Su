class Solution {
    /*
     * 가격 구간을 높은 금액부터 확인해 적용할 할인율을 결정한다.
     * 할인 후 가격의 소수점 이하는 정수 형변환으로 버린다.
     */
    public int solution(int price) {
        if (price >= 500000) return (int) (price * 0.80);
        if (price >= 300000) return (int) (price * 0.90);
        if (price >= 100000) return (int) (price * 0.95);
        return price;
    }
}
