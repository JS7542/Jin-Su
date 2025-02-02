class Solution {
    /*
     * 급여의 합과 최솟값, 최댓값을 한 번의 순회로 구한다.
     * 양 끝 값을 제외한 합을 n-2로 나누어 평균을 계산한다.
     */
    public double average(int[] salary) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int value : salary) {
            sum += value;
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        return (double) (sum - min - max) / (salary.length - 2);
    }
}
