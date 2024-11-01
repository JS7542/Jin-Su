class Solution {
    /*
     * 연산 문자열에 +가 포함되면 값을 1 증가시키고 아니면 1 감소시킨다.
     * 모든 연산을 적용한 최종 값을 반환한다.
     */
    public int finalValueAfterOperations(String[] operations) {
        int value = 0;

        for (String operation : operations) {
            value += operation.contains("+") ? 1 : -1;
        }

        return value;
    }
}
