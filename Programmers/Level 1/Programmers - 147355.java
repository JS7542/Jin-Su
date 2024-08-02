class Solution {
    /*
     * t에서 p와 같은 길이의 모든 부분문자열을 확인한다.
     * 숫자 범위를 고려해 long으로 변환하고 p 이하인 경우를 센다.
     */
    public int solution(String t, String p) {
        long target = Long.parseLong(p);
        int answer = 0;

        for (int start = 0; start <= t.length() - p.length(); start++) {
            long value = Long.parseLong(t.substring(start, start + p.length()));
            if (value <= target) answer++;
        }

        return answer;
    }
}
