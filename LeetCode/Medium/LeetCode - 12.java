class Solution {
    /*
     * 큰 로마 숫자 값부터 가능한 횟수만큼 차례대로 사용한다.
     * 값을 뺄 때마다 대응 문자를 결과 문자열에 추가한다.
     */
    public String intToRoman(int num) {
        int[] values = {
            1000, 900, 500, 400, 100, 90, 50, 40,
            10, 9, 5, 4, 1
        };
        String[] symbols = {
            "M", "CM", "D", "CD", "C", "XC", "L",
            "XL", "X", "IX", "V", "IV", "I"
        };

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                answer.append(symbols[i]);
            }
        }

        return answer.toString();
    }
}
