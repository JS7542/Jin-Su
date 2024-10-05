class Solution {
    /*
     * 공격력이 큰 장군개미부터 최대한 사용한다.
     * 남은 체력을 병정개미와 일개미로 처리해 최소 개미 수를 구한다.
     */
    public int solution(int hp) {
        return hp / 5 + hp % 5 / 3 + hp % 5 % 3;
    }
}
