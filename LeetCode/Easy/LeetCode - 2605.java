class Solution {
    /*
     * 두 배열에 공통된 숫자가 있으면 가장 작은 공통 숫자를 반환한다.
     * 공통 숫자가 없으면 각 배열의 최솟값을 작은 자리 순서로 이어 붙인다.
     */
    public int minNumber(int[] nums1, int[] nums2) {
        boolean[] first = new boolean[10];

        for (int number : nums1) first[number] = true;

        for (int digit = 1; digit <= 9; digit++) {
            boolean inSecond = false;

            for (int number : nums2) {
                if (number == digit) inSecond = true;
            }

            if (first[digit] && inSecond) return digit;
        }

        int min1 = 10;
        int min2 = 10;

        for (int number : nums1) min1 = Math.min(min1, number);
        for (int number : nums2) min2 = Math.min(min2, number);

        return Math.min(min1, min2) * 10 + Math.max(min1, min2);
    }
}
