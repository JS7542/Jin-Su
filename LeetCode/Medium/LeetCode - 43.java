class Solution {
    /*
     * 두 문자열의 각 자리수를 곱해 결과 배열의 대응 자리에 누적한다.
     * 낮은 자리부터 올림을 정리한 뒤 앞쪽 0을 제외해 문자열로 만든다.
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int low = i + j + 1;
                int high = i + j;

                int sum = product + result[low];
                result[low] = sum % 10;
                result[high] += sum / 10;
            }
        }

        StringBuilder answer = new StringBuilder();
        int index = result[0] == 0 ? 1 : 0;

        while (index < result.length) answer.append(result[index++]);

        return answer.toString();
    }
}
