class Solution {
    /*
     * 주문 이름에 americano가 포함되면 4500원으로 계산한다.
     * 그 외 카페라테 주문은 5000원으로 계산해 총액을 구한다.
     */
    public int solution(String[] order) {
        int answer = 0;

        for (String drink : order) {
            answer += drink.contains("americano") || drink.equals("anything") ? 4500 : 5000;
        }

        return answer;
    }
}
