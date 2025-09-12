class Solution {
    /*
     * 자르는 단위를 1부터 문자열 절반까지 모두 시도한다.
     * 연속해서 같은 조각의 개수를 세어 압축 문자열 길이의 최솟값을 구한다.
     */
    public int solution(String s) {
        int answer = s.length();

        for (int size = 1; size <= s.length() / 2; size++) {
            String previous = s.substring(0, size);
            int count = 1;
            int compressed = 0;

            for (int start = size; start < s.length(); start += size) {
                String current = s.substring(start, Math.min(start + size, s.length()));

                if (current.equals(previous)) {
                    count++;
                } else {
                    compressed += previous.length();
                    if (count > 1) compressed += String.valueOf(count).length();
                    previous = current;
                    count = 1;
                }
            }

            compressed += previous.length();
            if (count > 1) compressed += String.valueOf(count).length();

            answer = Math.min(answer, compressed);
        }

        return answer;
    }
}
