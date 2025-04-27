class NumArray {
    /*
     * 생성 시 prefix[i]에 앞 i개 원소의 합을 저장한다.
     * 구간 합은 prefix[right+1]-prefix[left]로 즉시 계산한다.
     */
    private final int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
