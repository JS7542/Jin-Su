class Solution {
    /*
     * 배열의 모든 정수를 실수형 합계에 누적한다.
     * 합을 배열 길이로 나눈 평균을 반환한다.
     */
    public double solution(int[] arr) {
        double sum = 0;
        for (int number : arr) sum += number;
        return sum / arr.length;
    }
}
