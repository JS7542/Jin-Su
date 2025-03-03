class Solution {
    /*
     * 각 숫자의 등장 여부를 boolean 배열에 표시한다.
     * 이미 등장한 숫자 두 개를 발견 순서대로 결과에 저장한다.
     */
    public int[] getSneakyNumbers(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        int[] answer = new int[2];
        int index = 0;

        for (int number : nums) {
            if (seen[number]) answer[index++] = number;
            else seen[number] = true;
        }

        return answer;
    }
}
