class Solution {
    /*
     * 각 학생이 받은 점수에서 자기 평가가 유일한 최고점 또는 최저점인지 확인한다.
     * 해당하면 제외한 평균, 아니면 전체 평균으로 학점을 계산한다.
     */
    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        int students = scores.length;

        for (int target = 0; target < students; target++) {
            int self = scores[target][target];
            int sum = 0;
            int count = students;
            int higherOrEqual = 0;
            int lowerOrEqual = 0;

            for (int evaluator = 0; evaluator < students; evaluator++) {
                int score = scores[evaluator][target];
                sum += score;

                if (score >= self) higherOrEqual++;
                if (score <= self) lowerOrEqual++;
            }

            if (higherOrEqual == 1 || lowerOrEqual == 1) {
                sum -= self;
                count--;
            }

            double average = (double) sum / count;
            answer.append(grade(average));
        }

        return answer.toString();
    }

    private char grade(double average) {
        if (average >= 90) return 'A';
        if (average >= 80) return 'B';
        if (average >= 70) return 'C';
        if (average >= 50) return 'D';

        return 'F';
    }
}
