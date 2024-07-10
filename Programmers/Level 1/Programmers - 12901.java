class Solution {
    /*
     * 2016년 1월 1일부터 입력 날짜까지 지난 일수를 계산한다.
     * 금요일을 시작으로 요일 배열의 나머지 위치를 반환한다.
     */
    public String solution(int a, int b) {
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int passed = b - 1;
        for (int month = 1; month < a; month++) passed += days[month];
        return week[passed % 7];
    }
}
