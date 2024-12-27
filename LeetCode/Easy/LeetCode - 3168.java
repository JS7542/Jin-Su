class Solution {
    /*
     * E를 만나면 현재 인원을 늘리고 L을 만나면 줄인다.
     * 동시에 대기실에 있었던 최대 인원 수를 기록한다.
     */
    public int minimumChairs(String s) {
        int current = 0;
        int answer = 0;

        for (char event : s.toCharArray()) {
            current += event == 'E' ? 1 : -1;
            answer = Math.max(answer, current);
        }

        return answer;
    }
}
