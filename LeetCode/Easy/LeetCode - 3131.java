class Solution {
    /*
     * 두 배열의 최솟값을 각각 찾는다.
     * 모든 원소에 같은 값이 더해졌으므로 최솟값 차이를 반환한다.
     */
    public int addedInteger(int[] nums1, int[] nums2) {
        int min1 = nums1[0];
        int min2 = nums2[0];

        for (int number : nums1) min1 = Math.min(min1, number);
        for (int number : nums2) min2 = Math.min(min2, number);

        return min2 - min1;
    }
}
