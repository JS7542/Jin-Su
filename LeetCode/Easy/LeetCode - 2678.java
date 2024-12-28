class Solution {
    /*
     * 각 상세 문자열에서 나이를 나타내는 두 자리 부분을 추출한다.
     * 나이가 60보다 큰 승객의 수를 센다.
     */
    public int countSeniors(String[] details) {
        int answer = 0;

        for (String detail : details) {
            int age = Integer.parseInt(detail.substring(11, 13));
            if (age > 60) answer++;
        }

        return answer;
    }
}
