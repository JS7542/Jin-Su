class Solution {
    /*
     * 문자열의 앞 절반 모음은 1을 더하고 뒤 절반 모음은 1을 뺀다.
     * 최종 균형값이 0이면 두 절반의 모음 개수가 같다.
     */
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int balance = 0;
        int half = s.length() / 2;

        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) >= 0) balance += i < half ? 1 : -1;
        }

        return balance == 0;
    }
}
