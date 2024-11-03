class Solution {
    /*
     * 지금까지 테스트한 기기 수만큼 뒤 기기의 배터리가 감소했다고 생각한다.
     * 현재 배터리에서 테스트 수를 뺀 값이 양수이면 테스트 수를 증가시킨다.
     */
    public int countTestedDevices(int[] batteryPercentages) {
        int tested = 0;

        for (int battery : batteryPercentages) {
            if (battery - tested > 0) tested++;
        }

        return tested;
    }
}
