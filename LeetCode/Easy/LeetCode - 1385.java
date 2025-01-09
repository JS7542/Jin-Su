class Solution {
    /*
     * arr1의 각 값과 arr2의 모든 값의 차이를 확인한다.
     * 모든 차이의 절댓값이 d보다 큰 arr1 원소의 개수를 센다.
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int answer = 0;

        for (int first : arr1) {
            boolean valid = true;

            for (int second : arr2) {
                if (Math.abs(first - second) <= d) {
                    valid = false;
                    break;
                }
            }

            if (valid) answer++;
        }

        return answer;
    }
}
