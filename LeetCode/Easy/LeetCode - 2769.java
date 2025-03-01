class Solution {
    /*
     * 한 번의 연산으로 x는 1 증가하고 num은 1 감소시킬 수 있다.
     * t번의 연산 차이는 총 2t이므로 num에 2t를 더한다.
     */
    public int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }
}
