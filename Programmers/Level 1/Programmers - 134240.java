class Solution {
    /*
     * 각 음식 수를 두 선수에게 절반씩 배치할 수 있는 만큼 왼쪽 문자열에 추가한다.
     * 왼쪽 문자열과 물 0, 왼쪽 문자열의 역순을 이어 붙인다.
     */
    public String solution(int[] food) {
        StringBuilder left = new StringBuilder();

        for (int type = 1; type < food.length; type++) {
            left.append(String.valueOf(type).repeat(food[type] / 2));
        }

        return left + "0" + left.reverse();
    }
}
