class Solution {
    /*
     * 배열의 모든 원소를 실수형 합계에 누적한다.
     * 원소 개수로 나눈 평균값을 반환한다.
     */
    public double solution(int[] numbers) {
        double sum = 0;
        for (int number : numbers) sum += number;
        return sum / numbers.length;
    }
}
