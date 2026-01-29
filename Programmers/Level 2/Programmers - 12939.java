class Solution {
    /*
     * 공백으로 구분된 정수를 순회하며 최솟값과 최댓값을 갱신한다.
     * 최솟값과 최댓값을 공백으로 이어 반환한다.
     */
    public String solution(String s) {
        String[] tokens = s.split(" ");
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;

        for (String token : tokens) {
            int value = Integer.parseInt(token);
            minimum = Math.min(minimum, value);
            maximum = Math.max(maximum, value);
        }

        return minimum + " " + maximum;
    }
}
