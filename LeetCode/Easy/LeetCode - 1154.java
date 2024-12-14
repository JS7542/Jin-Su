class Solution {
    /*
     * 날짜 문자열에서 연, 월, 일을 분리한다.
     * 이전 달의 일수를 더하고 윤년이면 2월 이후 날짜에 하루를 추가한다.
     */
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int answer = day;
        for (int current = 1; current < month; current++) answer += days[current];

        boolean leap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        if (leap && month > 2) answer++;

        return answer;
    }
}
