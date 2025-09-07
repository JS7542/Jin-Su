class Solution {
    /*
     * 샵 음표를 한 문자로 치환해 부분문자열 비교가 정확히 동작하게 만든다.
     * 재생 시간만큼 멜로디를 반복하고 조건을 만족하는 가장 긴 곡을 선택한다.
     */
    public String solution(String m, String[] musicinfos) {
        String target = normalize(m);
        String answer = "(None)";
        int longest = -1;

        for (String information : musicinfos) {
            String[] parts = information.split(",");
            int playTime = minutes(parts[1]) - minutes(parts[0]);
            String melody = normalize(parts[3]);

            StringBuilder played = new StringBuilder();

            for (int i = 0; i < playTime; i++) {
                played.append(melody.charAt(i % melody.length()));
            }

            if (played.indexOf(target) >= 0 && playTime > longest) {
                longest = playTime;
                answer = parts[2];
            }
        }

        return answer;
    }

    private int minutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private String normalize(String melody) {
        return melody
                .replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }
}
