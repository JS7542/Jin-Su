class Solution {
    /*
     * 각 키의 지속 시간은 현재 해제 시간에서 이전 해제 시간을 뺀 값이다.
     * 더 긴 시간 또는 같은 시간의 더 큰 문자를 정답으로 유지한다.
     */
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int longest = releaseTimes[0];
        char answer = keysPressed.charAt(0);

        for (int i = 1; i < releaseTimes.length; i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            char key = keysPressed.charAt(i);

            if (duration > longest || (duration == longest && key > answer)) {
                longest = duration;
                answer = key;
            }
        }

        return answer;
    }
}
