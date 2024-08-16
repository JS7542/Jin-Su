class Solution {
    /*
     * 여섯 조각 피자를 모두 같은 수만큼 먹으려면 총 조각 수가 n의 배수여야 한다.
     * 판 수를 하나씩 늘리며 6×판 수가 n으로 나누어지는 최초 값을 찾는다.
     */
    public int solution(int n) {
        int pizza = 1;
        while ((pizza * 6) % n != 0) pizza++;
        return pizza;
    }
}
