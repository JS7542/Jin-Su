class Solution {
    /*
     * n, 2n, 3n을 문자열로 이어 붙인다.
     * 숫자 1부터 9가 정확히 한 번씩 등장하고 0이 없는지 확인한다.
     */
    public boolean isFascinating(int n) {
        String text = String.valueOf(n) + (n * 2) + (n * 3);

        if (text.length() != 9 || text.indexOf('0') >= 0) return false;

        boolean[] seen = new boolean[10];

        for (char ch : text.toCharArray()) {
            int digit = ch - '0';
            if (seen[digit]) return false;
            seen[digit] = true;
        }

        return true;
    }
}
