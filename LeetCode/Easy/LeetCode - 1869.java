class Solution {
    /*
     * 0과 1의 현재 연속 길이와 최대 길이를 각각 유지한다.
     * 가장 긴 1 구간이 가장 긴 0 구간보다 큰지 비교한다.
     */
    public boolean checkZeroOnes(String s) {
        int currentZero = 0;
        int currentOne = 0;
        int maxZero = 0;
        int maxOne = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                currentOne++;
                currentZero = 0;
                maxOne = Math.max(maxOne, currentOne);
            } else {
                currentZero++;
                currentOne = 0;
                maxZero = Math.max(maxZero, currentZero);
            }
        }

        return maxOne > maxZero;
    }
}
