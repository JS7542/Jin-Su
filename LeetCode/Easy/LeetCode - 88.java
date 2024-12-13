class Solution {
    /*
     * 두 정렬 배열의 가장 큰 값부터 비교해 nums1의 뒤쪽에 채운다.
     * 뒤에서 병합하면 nums1의 아직 사용하지 않은 값을 덮어쓰지 않는다.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int write = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) nums1[write--] = nums1[i--];
            else nums1[write--] = nums2[j--];
        }
    }
}
