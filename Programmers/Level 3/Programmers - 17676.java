class Solution {
    /*
     * 각 로그를 밀리초 단위의 시작·종료 구간으로 변환한다.
     * 각 종료 시각부터 1초 구간과 겹치는 로그 수를 세어 최댓값을 구한다.
     */
    public int solution(String[] lines) {
        int[][] intervals = new int[lines.length][2];

        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split(" ");
            int end = parseTime(parts[1]);
            int duration = (int) Math.round(Double.parseDouble(
                    parts[2].substring(0, parts[2].length() - 1)
            ) * 1000);

            intervals[i][1] = end;
            intervals[i][0] = end - duration + 1;
        }

        int answer = 0;

        for (int[] interval : intervals) {
            int windowStart = interval[1];
            int windowEnd = windowStart + 999;
            int count = 0;

            for (int[] candidate : intervals) {
                if (candidate[0] <= windowEnd && candidate[1] >= windowStart) {
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    private int parseTime(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        double seconds = Double.parseDouble(parts[2]);

        return (int) Math.round(
                (hours * 3600 + minutes * 60 + seconds) * 1000
        );
    }
}
