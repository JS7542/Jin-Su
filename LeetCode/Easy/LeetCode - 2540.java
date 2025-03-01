class Solution {
    /*
     * 두 정렬 배열에 각각 포인터를 둔다.
     * 값이 같으면 반환하고 작은 값을 가진 배열의 포인터를 이동한다.
     */
    public int getCommon(int[] nums1, int[] nums2) {
        int first = 0;
        int second = 0;

        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] == nums2[second]) return nums1[first];

            if (nums1[first] < nums2[second]) first++;
            else second++;
        }

        return -1;
    }
}
