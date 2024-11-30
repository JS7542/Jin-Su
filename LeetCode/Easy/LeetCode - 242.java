class Solution {
    /*
     * 첫 문자열의 문자 빈도는 증가시키고 두 번째 문자열의 빈도는 감소시킨다.
     * 모든 알파벳의 최종 빈도가 0이면 두 문자열은 애너그램이다.
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int value : count) if (value != 0) return false;
        return true;
    }
}
