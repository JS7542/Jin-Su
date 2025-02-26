class Solution {
    /*
     * 주 연료 5리터를 사용할 때마다 보조 탱크에서 1리터를 옮긴다.
     * 실제 사용할 수 있는 전체 연료에 10을 곱해 이동 거리를 구한다.
     */
    public int distanceTraveled(int mainTank, int additionalTank) {
        int used = mainTank;
        int transfers = Math.min((mainTank - 1) / 4, additionalTank);
        return (used + transfers) * 10;
    }
}
