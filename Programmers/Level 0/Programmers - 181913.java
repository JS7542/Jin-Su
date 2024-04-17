class Solution {
    /*
     * 각 쿼리의 시작과 끝 인덱스 사이 문자를 양 끝에서 교환한다.
     * 모든 구간 뒤집기를 순서대로 적용한 문자열을 반환한다.
     */
    public String solution(String my_string, int[][] queries) {
        char[] chars = my_string.toCharArray();

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];

            while (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
        }

        return new String(chars);
    }
}
