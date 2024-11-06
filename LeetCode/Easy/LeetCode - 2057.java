class Solution {
    /*
     * 각 인덱스를 10으로 나눈 나머지와 해당 원소를 비교한다.
     * 조건을 처음 만족하는 가장 작은 인덱스를 반환한다.
     */
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) return i;
        }
        return -1;
    }
}
