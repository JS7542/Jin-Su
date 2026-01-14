class Solution {
    /*
     * 초 단위 차분 배열로 각 시각의 누적 시청자 수를 계산한다.
     * 광고 길이 구간의 시청 시간 합을 슬라이딩 윈도우로 비교해 가장 이른 최적 시작 시각을 구한다.
     */
    public String solution(
            String play_time,
            String adv_time,
            String[] logs
    ) {
        int play = seconds(play_time);
        int advertisement = seconds(adv_time);
        long[] viewers = new long[play + 2];

        for (String log : logs) {
            String[] parts = log.split("-");
            int start = seconds(parts[0]);
            int end = seconds(parts[1]);

            viewers[start]++;
            viewers[end]--;
        }

        for (int time = 1; time <= play; time++) {
            viewers[time] += viewers[time - 1];
        }

        for (int time = 1; time <= play; time++) {
            viewers[time] += viewers[time - 1];
        }

        long maximum = viewers[advertisement - 1];
        int bestStart = 0;

        for (int end = advertisement; end < play; end++) {
            long current = viewers[end] - viewers[end - advertisement];

            if (current > maximum) {
                maximum = current;
                bestStart = end - advertisement + 1;
            }
        }

        return format(bestStart);
    }

    private int seconds(String time) {
        String[] parts = time.split(":");

        return Integer.parseInt(parts[0]) * 3600
                + Integer.parseInt(parts[1]) * 60
                + Integer.parseInt(parts[2]);
    }

    private String format(int seconds) {
        return String.format(
                "%02d:%02d:%02d",
                seconds / 3600,
                seconds % 3600 / 60,
                seconds % 60
        );
    }
}
