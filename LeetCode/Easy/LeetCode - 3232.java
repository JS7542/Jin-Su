class Solution {
    /*
     * 한 자리 숫자의 합과 두 자리 숫자의 합을 각각 계산한다.
     * 두 합이 다르면 Alice가 더 큰 그룹을 선택해 이길 수 있다.
     */
    public boolean canAliceWin(int[] nums) {
        int single = 0;
        int doubleDigit = 0;

        for (int number : nums) {
            if (number < 10) single += number;
            else doubleDigit += number;
        }

        return single != doubleDigit;
    }
}
