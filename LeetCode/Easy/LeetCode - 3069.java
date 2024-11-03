class Solution {
    /*
     * 첫 두 원소를 각각 arr1과 arr2에 넣는다.
     * 이후 두 배열의 마지막 값 중 큰 쪽에 현재 값을 추가한다.
     */
    public int[] resultArray(int[] nums) {
        int[] first = new int[nums.length];
        int[] second = new int[nums.length];
        int firstSize = 1;
        int secondSize = 1;

        first[0] = nums[0];
        second[0] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            if (first[firstSize - 1] > second[secondSize - 1]) {
                first[firstSize++] = nums[i];
            } else {
                second[secondSize++] = nums[i];
            }
        }

        int[] answer = new int[nums.length];
        System.arraycopy(first, 0, answer, 0, firstSize);
        System.arraycopy(second, 0, answer, firstSize, secondSize);

        return answer;
    }
}
