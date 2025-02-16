class Solution {
    /*
     * 원형 배열의 각 위치를 가운데로 하는 길이 3 구간을 확인한다.
     * 가운데 색이 양쪽 색과 모두 다른 경우를 센다.
     */
    public int numberOfAlternatingGroups(int[] colors) {
        int answer = 0;
        int n = colors.length;

        for (int i = 0; i < n; i++) {
            int previous = colors[(i - 1 + n) % n];
            int next = colors[(i + 1) % n];

            if (colors[i] != previous && colors[i] != next) answer++;
        }

        return answer;
    }
}
