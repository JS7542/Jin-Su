class Solution {
    /*
     * 두 문자열의 숫자별 등장 횟수를 센다.
     * 공통으로 등장하는 횟수만큼 9부터 0까지 이어 붙이고 결과가 0들뿐이면 0을 반환한다.
     */
    public String solution(String X, String Y) {
        int[] first = new int[10];
        int[] second = new int[10];

        for (char digit : X.toCharArray()) first[digit - '0']++;
        for (char digit : Y.toCharArray()) second[digit - '0']++;

        StringBuilder answer = new StringBuilder();

        for (int digit = 9; digit >= 0; digit--) {
            int count = Math.min(first[digit], second[digit]);

            while (count-- > 0) answer.append(digit);
        }

        if (answer.length() == 0) return "-1";
        if (answer.charAt(0) == '0') return "0";

        return answer.toString();
    }
}
