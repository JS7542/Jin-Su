class Solution {
    /*
     * Boyer-Moore 투표 알고리즘으로 현재 후보와 표 수를 유지한다.
     * 표가 0이면 후보를 바꾸고 같은 값이면 증가, 다르면 감소시킨다.
     */
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int number : nums) {
            if (count == 0) candidate = number;
            count += number == candidate ? 1 : -1;
        }

        return candidate;
    }
}
