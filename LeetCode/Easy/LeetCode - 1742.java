class Solution {
    /*
     * 각 공 번호의 자리수 합을 상자 번호로 사용한다.
     * 상자별 공 개수를 세며 가장 많은 공이 들어간 상자의 개수를 반환한다.
     */
    public int countBalls(int lowLimit, int highLimit) {
        int[] boxes = new int[46];
        int answer = 0;

        for (int number = lowLimit; number <= highLimit; number++) {
            int box = digitSum(number);
            answer = Math.max(answer, ++boxes[box]);
        }

        return answer;
    }

    private int digitSum(int value) {
        int sum = 0;
        while (value > 0) {
            sum += value % 10;
            value /= 10;
        }
        return sum;
    }
}
