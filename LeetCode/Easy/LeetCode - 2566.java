class Solution {
    /*
     * 최댓값은 처음 9가 아닌 숫자를 9로, 최솟값은 첫 숫자를 0으로 바꾼다.
     * 두 변환 결과의 차이를 반환한다.
     */
    public int minMaxDifference(int num) {
        String text = String.valueOf(num);

        char maxTarget = 0;

        for (char ch : text.toCharArray()) {
            if (ch != '9') {
                maxTarget = ch;
                break;
            }
        }

        String maxText = maxTarget == 0 ? text : text.replace(maxTarget, '9');
        String minText = text.replace(text.charAt(0), '0');

        return Integer.parseInt(maxText) - Integer.parseInt(minText);
    }
}
