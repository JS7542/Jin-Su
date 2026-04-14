class Solution {
    /*
     * 쓰기 위치가 2보다 작거나 현재 값이 두 칸 앞 값과 다르면 저장한다.
     * 각 숫자를 최대 두 번만 남긴 뒤 유효 길이를 반환한다.
     */
    public int removeDuplicates(int[] nums) {
        int write = 0;

        for (int number : nums) {
            if (write < 2 || number != nums[write - 2]) {
                nums[write++] = number;
            }
        }

        return write;
    }
}
