class Solution {
    /*
     * 자리수가 짝수인 숫자만 앞 절반과 뒤 절반의 자리수 합을 계산한다.
     * 두 합이 같은 숫자의 개수를 센다.
     */
    public int countSymmetricIntegers(int low, int high) {
        int answer = 0;

        for (int value = low; value <= high; value++) {
            String text = String.valueOf(value);
            if (text.length() % 2 == 1) continue;

            int left = 0;
            int right = 0;
            int half = text.length() / 2;

            for (int i = 0; i < half; i++) left += text.charAt(i) - '0';
            for (int i = half; i < text.length(); i++) right += text.charAt(i) - '0';

            if (left == right) answer++;
        }

        return answer;
    }
}
