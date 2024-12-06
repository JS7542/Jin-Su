class Solution {
    /*
     * 출생 연도에는 인구를 1 더하고 사망 연도에는 1을 뺀 차이 배열을 만든다.
     * 연도별 누적 인구가 최대가 되는 가장 이른 연도를 반환한다.
     */
    public int maximumPopulation(int[][] logs) {
        int[] change = new int[101];

        for (int[] log : logs) {
            change[log[0] - 1950]++;
            change[log[1] - 1950]--;
        }

        int population = 0;
        int max = 0;
        int answer = 1950;

        for (int year = 0; year < change.length; year++) {
            population += change[year];

            if (population > max) {
                max = population;
                answer = 1950 + year;
            }
        }

        return answer;
    }
}
