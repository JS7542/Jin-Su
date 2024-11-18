class Solution {
    /*
     * 정렬 배열에서 서로 다른 값이 나타날 때마다 쓰기 위치에 덮어쓴다.
     * 쓰기 위치가 중복을 제거한 배열의 길이가 된다.
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[read - 1]) nums[write++] = nums[read];
        }

        return write;
    }
}
